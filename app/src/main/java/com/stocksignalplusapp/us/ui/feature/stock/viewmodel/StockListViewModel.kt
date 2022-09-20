package com.stocksignalplusapp.us.ui.feature.stock.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StockListViewModel(): ViewModel() {
    private val uiStateMutable = MutableStateFlow<StockListEvent>(StockListEvent.Waiting)
    val uiState: StateFlow<StockListEvent> = uiStateMutable

}