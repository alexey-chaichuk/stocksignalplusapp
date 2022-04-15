package com.stocksignalplusapp.us.ui.feature.loader.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoaderViewModel @Inject constructor(

): ViewModel() {
    private val _events = MutableStateFlow<LoaderEvents>(LoaderEvents.Waiting)
    val events: LiveData<LoaderEvents>
        get() = _events.asLiveData(viewModelScope.coroutineContext)

    fun onTimerFinish() {
        _events.value = LoaderEvents.GoToHomeScreen
    }
}