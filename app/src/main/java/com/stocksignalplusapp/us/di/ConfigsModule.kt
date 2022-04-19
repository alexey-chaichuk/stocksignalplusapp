package com.stocksignalplusapp.us.di

import com.stocksignalplusapp.us.BuildConfig
import com.stocksignalplusapp.us.core.FinnHubUrlProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ConfigsModule {

    @Provides
    fun provideFinnHubUrlProvider() : FinnHubUrlProvider = FinnHubUrlProvider(
        baseUrl = "https://finnhub.io/api/v1/",
        apiKey = BuildConfig.FINNHUB_API_KEY,
    )
}