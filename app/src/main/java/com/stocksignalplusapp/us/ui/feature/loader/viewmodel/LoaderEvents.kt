package com.stocksignalplusapp.us.ui.feature.loader.viewmodel

sealed class LoaderEvents {
    object Waiting : LoaderEvents()
    object GoToHomeScreen : LoaderEvents()
}