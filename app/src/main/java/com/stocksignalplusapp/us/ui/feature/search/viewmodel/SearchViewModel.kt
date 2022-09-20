package com.stocksignalplusapp.us.ui.feature.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.domain.repository.FinnHubRepository
import com.stocksignalplusapp.us.util.doOnSuccess
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel (
    private val finnHubRepository: FinnHubRepository
): ViewModel() {
    private val uiStateMutable = MutableStateFlow<SearchEvent>(SearchEvent.Waiting)
    val uiState: StateFlow<SearchEvent> = uiStateMutable

    private var searchJob: Job? = null

    fun onNewQuery(query: String) {
        Timber.d("OnNewQuery: %s", query)
        if(query.isEmpty()) return
        if(searchJob?.isActive == true) searchJob?.cancel()
        uiStateMutable.value = SearchEvent.Searching
        searchJob = viewModelScope.launch {
            try {
                finnHubRepository.symbolLookup(query)
                    .doOnSuccess { result ->
                        uiStateMutable.value = SearchEvent.SuccessResult(result)
                        Timber.d("Got result: %s", result.toString())
                    }
            } catch (e: CancellationException) {
                // ignore job cancel
            } catch (e: Exception) {
                Timber.d("Error on symbol lookup: %s", e.localizedMessage)
                uiStateMutable.value = SearchEvent.ErrorResult(e)
            }
        }
    }

}