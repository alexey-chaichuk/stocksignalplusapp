package com.stocksignalplusapp.us.ui.feature.loader.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoaderViewModel @Inject constructor(

): ViewModel() {
    private val uiStateMutable = MutableStateFlow<LoaderEvents>(LoaderEvents.Waiting)
    val uiState: StateFlow<LoaderEvents> = uiStateMutable

    fun onTimerFinish() {
        uiStateMutable.value = LoaderEvents.GoToHomeScreen
    }
}