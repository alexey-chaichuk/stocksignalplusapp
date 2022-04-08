package com.stocksignalplusapp.us.ui.feature.stock.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class StockListViewModel @Inject constructor(

): ViewModel() {
    private val _events = MutableStateFlow<StockListEvent>(StockListEvent.Waiting)
    val events: LiveData<StockListEvent>
        get() = _events.asLiveData(viewModelScope.coroutineContext)

}