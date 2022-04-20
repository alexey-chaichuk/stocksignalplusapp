package com.stocksignalplusapp.us.ui.feature.analysis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.data.finnhub.FinnHubRepository
import com.stocksignalplusapp.us.data.finnhub.remote.dto.CandlesDto
import com.stocksignalplusapp.us.domain.models.StockItem
import com.stocksignalplusapp.us.util.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class AnalysisViewModel @Inject constructor(
    private val finnHubRepository: FinnHubRepository
) : ViewModel() {
    private val _events = MutableStateFlow<AnalysisEvent>(AnalysisEvent.Waiting)
    val events: LiveData<AnalysisEvent>
        get() = _events.asLiveData(viewModelScope.coroutineContext)

    fun getCandles(stockItem: StockItem) {
        viewModelScope.launch {
            try {
                val from = SimpleDateFormat("yyyy-MM-dd").parse("2022-03-20")?.time
                val to = SimpleDateFormat("yyyy-MM-dd").parse("2022-04-20")?.time
                if (to != null && from != null)  {
                    finnHubRepository.candles(stockItem.ticker, "D", from /1000, to /1000).
                        doOnSuccess { candlesDto ->
                            _events.value = AnalysisEvent.GotCandles(candlesDto)
                        }
                }
            } catch (e: Exception) {
                Timber.d("Error on getting candles: %s", e.localizedMessage)
            }
        }
    }
}