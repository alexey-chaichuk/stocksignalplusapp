package com.stocksignalplusapp.us.di

import com.stocksignalplusapp.us.data.core.network.FinnHubHttpClient
import com.stocksignalplusapp.us.data.core.network.FinnHubHttpClientImpl
import com.stocksignalplusapp.us.data.finnhub.remote.api.FinnHubApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    @Singleton
    fun bindFinnHubClient(
        impl: FinnHubHttpClientImpl,
    ): FinnHubHttpClient
}

@Module
@InstallIn(SingletonComponent::class)
object ApiWrapperModule {

    @Provides
    @Singleton
    fun provideFinnHubApi(client: FinnHubHttpClient): FinnHubApi = client.finnHubApi
}