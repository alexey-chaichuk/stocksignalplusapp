package com.stocksignalplusapp.us.data.core.network

import com.stocksignalplusapp.us.core.FinnHubUrlProvider
import com.stocksignalplusapp.us.data.finnhub.remote.api.FinnHubApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface FinnHubHttpClient {
    val finnHubApi : FinnHubApi
}

class FinnHubHttpClientImpl @Inject constructor(
    finnHubUrlProvider: FinnHubUrlProvider,
) : FinnHubHttpClient {

    private val client = OkHttpClient.Builder()
        .addInterceptor(QueryInterceptor(hashMapOf("api_key" to finnHubUrlProvider.apiKey)))
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(finnHubUrlProvider.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override val finnHubApi: FinnHubApi by lazy(LazyThreadSafetyMode.NONE) { retrofit.create(FinnHubApi::class.java) }
}