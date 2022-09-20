package com.stocksignalplusapp.us.data.finnhub

import com.stocksignalplusapp.us.data.finnhub.remote.FinnHubRemoteDataSource
import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolDto
import com.stocksignalplusapp.us.domain.models.Candles
import com.stocksignalplusapp.us.domain.repository.FinnHubRepository
import com.stocksignalplusapp.us.util.Result

class FinnHubRepositoryImpl (
    private val finnHubRemoteDataSource: FinnHubRemoteDataSource
) : FinnHubRepository {

    override suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable> =
        finnHubRemoteDataSource.symbolLookup(query)

    override suspend fun candles(symbol: String, resolution: String, from: Long, to: Long):
            Result<Candles, Throwable> =
        finnHubRemoteDataSource.candles(symbol, resolution, from, to)

}