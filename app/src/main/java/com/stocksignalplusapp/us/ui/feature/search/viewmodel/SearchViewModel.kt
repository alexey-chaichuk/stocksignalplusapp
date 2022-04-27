package com.stocksignalplusapp.us.ui.feature.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.data.finnhub.FinnHubRepository
import com.stocksignalplusapp.us.util.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel  @Inject constructor(
    private val finnHubRepository: FinnHubRepository
): ViewModel() {
    private val _events = MutableStateFlow<SearchEvent>(SearchEvent.Waiting)
    val events: LiveData<SearchEvent>
        get() = _events.asLiveData(viewModelScope.coroutineContext)

    private var searchJob: Job? = null

    fun onNewQuery(query: String) {
        Timber.d("OnNewQuery: %s", query)
        if(query.isEmpty()) return
        if(searchJob?.isActive == true) searchJob?.cancel()
        _events.value = SearchEvent.Searching
        searchJob = viewModelScope.launch {
            try {
                finnHubRepository.symbolLookup(query)
                    .doOnSuccess { result ->
                        _events.value = SearchEvent.SuccessResult(result)
                        Timber.d("Got result: %s", result.toString())
                    }
            } catch (e: CancellationException) {
                // ignore job cancel
            } catch (e: Exception) {
                Timber.d("Error on symbol lookup: %s", e.localizedMessage)
                _events.value = SearchEvent.ErrorResult(e)
            }
        }
    }

}