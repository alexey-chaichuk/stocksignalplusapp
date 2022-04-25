package com.stocksignalplusapp.us.ui.feature.search.viewmodel

import com.stocksignalplusapp.us.domain.models.StockItem

sealed class SearchEvent {
    object Waiting : SearchEvent()
    data class SuccessResult (val stockItems: List<StockItem>) : SearchEvent()
    data class ErrorResult(val e: Throwable) : SearchEvent()
}
