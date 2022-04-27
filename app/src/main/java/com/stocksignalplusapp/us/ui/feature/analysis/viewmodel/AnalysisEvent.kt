package com.stocksignalplusapp.us.ui.feature.analysis.viewmodel

import com.stocksignalplusapp.us.data.finnhub.remote.dto.CandlesDto

sealed class AnalysisEvent {
    object Waiting : AnalysisEvent()
    data class GotCandles(val candles: CandlesDto) : AnalysisEvent()
}
