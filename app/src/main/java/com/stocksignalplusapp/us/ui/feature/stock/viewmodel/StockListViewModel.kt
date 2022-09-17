package com.stocksignalplusapp.us.ui.feature.stock.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StockListViewModel @Inject constructor(

): ViewModel() {
    private val uiStateMutable = MutableStateFlow<StockListEvent>(StockListEvent.Waiting)
    val uiState: StateFlow<StockListEvent> = uiStateMutable

}