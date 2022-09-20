package com.stocksignalplusapp.us.di

import com.stocksignalplusapp.us.data.finnhub.FinnHubRepositoryImpl
import com.stocksignalplusapp.us.data.finnhub.remote.FinnHubRemoteDataSource
import com.stocksignalplusapp.us.data.finnhub.remote.FinnHubRemoteDataSourceImpl
import com.stocksignalplusapp.us.domain.repository.FinnHubRepository
import org.koin.dsl.module

val finnHubModule = module {

    single<FinnHubRemoteDataSource> {
        FinnHubRemoteDataSourceImpl(finnHubApi = get())
    }

    single<FinnHubRepository> {
        FinnHubRepositoryImpl(finnHubRemoteDataSource = get())
    }
}
