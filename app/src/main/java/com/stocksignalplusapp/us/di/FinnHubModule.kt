package com.stocksignalplusapp.us.di

import com.stocksignalplusapp.us.data.finnhub.FinnHubRepository
import com.stocksignalplusapp.us.data.finnhub.FinnHubRepositoryImpl
import com.stocksignalplusapp.us.data.finnhub.remote.FinnHubRemoteDataSource
import com.stocksignalplusapp.us.data.finnhub.remote.FinnHubRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FinnHubModule {

    @Binds
    fun bindFinnHubRemoteDataSource(
        impl: FinnHubRemoteDataSourceImpl,
    ): FinnHubRemoteDataSource

    @Binds
    fun bindFinnHubRepository(
        impl: FinnHubRepositoryImpl,
    ): FinnHubRepository
}