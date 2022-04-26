package com.stocksignalplusapp.us.ui.feature.search.viewmodel

import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolDto

sealed class SearchEvent {
    object Waiting : SearchEvent()
    data class SuccessResult(val stockItems: List<SymbolDto>) : SearchEvent()
    data class ErrorResult(val e: Throwable) : SearchEvent()
}
