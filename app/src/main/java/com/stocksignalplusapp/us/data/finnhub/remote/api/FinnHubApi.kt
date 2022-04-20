package com.stocksignalplusapp.us.data.finnhub.remote.api

import com.stocksignalplusapp.us.data.finnhub.remote.dto.CandlesDto
import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolLookupResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface FinnHubApi {

    @GET("search")
    suspend fun symbolLookup(
        @Query("q") query: String,
    ): SymbolLookupResultDto

    //Supported resolution includes 1, 5, 15, 30, 60, D, W, M
    //from and to - UNIX timestamps
    @GET("stock/candle")
    suspend fun candles(
        @Query("symbol") symbol: String,
        @Query("resolution") resolution: String,
        @Query("from") from: Long,
        @Query("to") to: Long,
    ): CandlesDto

}