package com.stocksignalplusapp.us.data.finnhub.remote.api

import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolLookupResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FinnHubApi {

    @GET("search")
    suspend fun symbolLookup(
        @Query("q") query: String,
    ): SymbolLookupResultDto
}