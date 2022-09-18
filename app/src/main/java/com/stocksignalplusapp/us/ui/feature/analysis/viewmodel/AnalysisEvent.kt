package com.stocksignalplusapp.us.ui.feature.analysis.viewmodel

import com.stocksignalplusapp.us.domain.models.Candles

sealed class AnalysisEvent {
    object Waiting : AnalysisEvent()
    data class GotCandles(val candles: Candles) : AnalysisEvent()
}
