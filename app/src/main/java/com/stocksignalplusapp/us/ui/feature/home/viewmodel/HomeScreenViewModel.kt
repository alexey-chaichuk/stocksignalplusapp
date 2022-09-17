package com.stocksignalplusapp.us.ui.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(

): ViewModel() {
    private val uiStateMutable = MutableStateFlow<HomeScreenEvents>(HomeScreenEvents.Waiting)
    val uiState: StateFlow<HomeScreenEvents> = uiStateMutable

}
