package com.stocksignalplusapp.us.domain.repository

import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolDto
import com.stocksignalplusapp.us.domain.models.Candles
import com.stocksignalplusapp.us.util.Result

interface FinnHubRepository {
    suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable>

    suspend fun candles(symbol: String, resolution: String, from: Long, to: Long):
            Result<Candles, Throwable>
}