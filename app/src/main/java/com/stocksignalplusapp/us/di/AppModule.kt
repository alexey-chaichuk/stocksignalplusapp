package com.stocksignalplusapp.us.di

import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisViewModel
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenViewModel
import com.stocksignalplusapp.us.ui.feature.loader.viewmodel.LoaderViewModel
import com.stocksignalplusapp.us.ui.feature.search.viewmodel.SearchViewModel
import com.stocksignalplusapp.us.ui.feature.stock.viewmodel.StockListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    viewModelOf (::AnalysisViewModel)
    viewModelOf (::HomeScreenViewModel)
    viewModelOf (::LoaderViewModel)
    viewModelOf (::SearchViewModel)
    viewModelOf (::StockListViewModel)

}
