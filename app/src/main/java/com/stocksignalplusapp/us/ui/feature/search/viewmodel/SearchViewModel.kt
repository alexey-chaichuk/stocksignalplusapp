package com.stocksignalplusapp.us.ui.feature.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.data.finnhub.FinnHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel  @Inject constructor(
    private val finnHubRepository: FinnHubRepository
): ViewModel() {
    private val _events = MutableStateFlow<SearchEvent>(SearchEvent.Waiting)
    val events: LiveData<SearchEvent>
        get() = _events.asLiveData(viewModelScope.coroutineContext)

    fun onNewQuery(query: String) {

    }

}