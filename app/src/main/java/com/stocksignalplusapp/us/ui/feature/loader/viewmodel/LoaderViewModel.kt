package com.stocksignalplusapp.us.ui.feature.loader.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoaderViewModel(): ViewModel() {
    private val uiStateMutable = MutableStateFlow<LoaderEvents>(LoaderEvents.Waiting)
    val uiState: StateFlow<LoaderEvents> = uiStateMutable

    fun onTimerFinish() {
        uiStateMutable.value = LoaderEvents.GoToHomeScreen
    }
}