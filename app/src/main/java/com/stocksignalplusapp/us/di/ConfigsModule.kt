package com.stocksignalplusapp.us.di

import com.stocksignalplusapp.us.BuildConfig
import com.stocksignalplusapp.us.core.FinnHubUrlProvider
import org.koin.dsl.module

val configsModule = module {

    single<FinnHubUrlProvider> {
        FinnHubUrlProvider(
            baseUrl = "https://finnhub.io/api/v1/",
            apiKey = BuildConfig.FINNHUB_API_KEY,
        )
    }
}
