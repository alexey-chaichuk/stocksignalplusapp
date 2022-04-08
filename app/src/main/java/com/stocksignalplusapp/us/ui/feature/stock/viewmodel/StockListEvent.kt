package com.stocksignalplusapp.us.ui.feature.stock.viewmodel

sealed class StockListEvent {
    object Waiting : StockListEvent()
}
