package com.stocksignalplusapp.us.data.finnhub.remote

import com.stocksignalplusapp.us.core.FinnHubUrlProvider
import com.stocksignalplusapp.us.data.finnhub.remote.api.FinnHubApi
import com.stocksignalplusapp.us.data.finnhub.remote.dto.CandlesDto
import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolDto
import com.stocksignalplusapp.us.util.Result
import com.stocksignalplusapp.us.util.doOnError
import com.stocksignalplusapp.us.util.runOperationCatching
import timber.log.Timber
import javax.inject.Inject

interface FinnHubRemoteDataSource {
    suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable>

    suspend fun candles(symbol: String, resolution: String, from: Long, to: Long):
            Result<CandlesDto, Throwable>
}

class FinnHubRemoteDataSourceImpl @Inject constructor(
    private val finnHubApi: FinnHubApi
) : FinnHubRemoteDataSource {

    override suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable> =
        runOperationCatching { finnHubApi.symbolLookup(query).result }
            .doOnError { error -> Timber.e("Symbol Lookup server error", error) }

    override suspend fun candles(symbol: String, resolution: String, from: Long, to: Long):
            Result<CandlesDto, Throwable> =
        runOperationCatching { finnHubApi.candles(symbol, resolution, from, to) }
            .doOnError { error -> Timber.e("Server error while getting candles", error) }

}