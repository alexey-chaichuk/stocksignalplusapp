package com.stocksignalplusapp.us.di

import com.stocksignalplusapp.us.data.core.network.FinnHubHttpClient
import com.stocksignalplusapp.us.data.core.network.FinnHubHttpClientImpl
import org.koin.dsl.module

val networkModule = module {

    single<FinnHubHttpClient> {
        FinnHubHttpClientImpl(finnHubUrlProvider = get())
    }

    single {
        get<FinnHubHttpClient>().finnHubApi
    }

}