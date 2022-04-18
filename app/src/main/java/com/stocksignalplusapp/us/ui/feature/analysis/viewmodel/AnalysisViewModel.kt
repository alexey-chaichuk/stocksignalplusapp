package com.stocksignalplusapp.us.ui.feature.analysis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.data.finnhub.FinnHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class AnalysisViewModel @Inject constructor(
    finnHubRepository: FinnHubRepository
) : ViewModel() {
    private val _events = MutableStateFlow<AnalysisEvent>(AnalysisEvent.Waiting)
    val events: LiveData<AnalysisEvent>
        get() = _events.asLiveData(viewModelScope.coroutineContext)
}