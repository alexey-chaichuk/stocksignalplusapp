package com.stocksignalplusapp.us.ui.feature.analysis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.data.finnhub.FinnHubRepository
import com.stocksignalplusapp.us.domain.models.StockItem
import com.stocksignalplusapp.us.util.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AnalysisViewModel @Inject constructor(
    private val finnHubRepository: FinnHubRepository
) : ViewModel() {
    private val uiStateMutable = MutableStateFlow<AnalysisEvent>(AnalysisEvent.Waiting)
    val uiState: StateFlow<AnalysisEvent> = uiStateMutable

    fun getCandles(stockItem: StockItem, resolution: String, from: Long, to: Long) {
        viewModelScope.launch {
            try {
                finnHubRepository.candles(stockItem.ticker, resolution, from, to)
                    .doOnSuccess { candlesDto ->
                        uiStateMutable.value = AnalysisEvent.GotCandles(candlesDto)
                    }
            } catch (e: Exception) {
                Timber.d("Error on getting candles: %s", e.localizedMessage)
            }
        }
    }
}