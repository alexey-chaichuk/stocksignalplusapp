package com.example.testapp1.ui.feature.stock.viewmodel

sealed class StockListEvent {
    object Waiting : StockListEvent()
}
