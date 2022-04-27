package com.stocksignalplusapp.us.data.finnhub

import com.stocksignalplusapp.us.data.finnhub.remote.FinnHubRemoteDataSource
import com.stocksignalplusapp.us.data.finnhub.remote.dto.CandlesDto
import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolDto
import com.stocksignalplusapp.us.util.Result
import javax.inject.Inject

interface FinnHubRepository {
    suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable>

    suspend fun candles(symbol: String, resolution: String, from: Long, to: Long):
            Result<CandlesDto, Throwable>
}

class FinnHubRepositoryImpl @Inject constructor(
    private val finnHubRemoteDataSource: FinnHubRemoteDataSource
) : FinnHubRepository {

    override suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable> =
        finnHubRemoteDataSource.symbolLookup(query)

    override suspend fun candles(symbol: String, resolution: String, from: Long, to: Long):
            Result<CandlesDto, Throwable> =
        finnHubRemoteDataSource.candles(symbol, resolution, from, to)

}