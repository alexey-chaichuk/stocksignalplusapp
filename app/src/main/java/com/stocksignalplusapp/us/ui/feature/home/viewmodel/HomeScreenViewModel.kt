package com.stocksignalplusapp.us.ui.feature.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(

): ViewModel() {
    private val _events = MutableStateFlow<HomeScreenEvents>(HomeScreenEvents.Waiting)
    val events: LiveData<HomeScreenEvents>
        get() = _events.asLiveData(viewModelScope.coroutineContext)

}
