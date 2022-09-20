package com.stocksignalplusapp.us.ui.feature.analysis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.domain.models.StockItem
import com.stocksignalplusapp.us.domain.repository.FinnHubRepository
import com.stocksignalplusapp.us.util.doOnSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class AnalysisViewModel (
    private val finnHubRepository: FinnHubRepository
) : ViewModel() {
    private val uiStateMutable = MutableStateFlow<AnalysisEvent>(AnalysisEvent.Waiting)
    val uiState: StateFlow<AnalysisEvent> = uiStateMutable

    fun getCandles(stockItem: StockItem, resolution: String, from: Long, to: Long) {
        viewModelScope.launch {
            try {
                finnHubRepository.candles(stockItem.ticker, resolution, from, to)
                    .doOnSuccess { candles ->
                        uiStateMutable.value = AnalysisEvent.GotCandles(candles)
                    }
            } catch (e: Exception) {
                Timber.d("Error on getting candles: %s", e.localizedMessage)
            }
        }
    }
}