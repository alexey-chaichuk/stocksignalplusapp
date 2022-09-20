package com.stocksignalplusapp.us.ui.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeScreenViewModel(): ViewModel() {
    private val uiStateMutable = MutableStateFlow<HomeScreenEvents>(HomeScreenEvents.Waiting)
    val uiState: StateFlow<HomeScreenEvents> = uiStateMutable

}
