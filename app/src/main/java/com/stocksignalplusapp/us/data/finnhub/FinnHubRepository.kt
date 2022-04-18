package com.stocksignalplusapp.us.data.finnhub

import com.stocksignalplusapp.us.data.finnhub.remote.FinnHubRemoteDataSource
import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolDto
import com.stocksignalplusapp.us.util.Result
import javax.inject.Inject

interface FinnHubRepository {
    suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable>
}

class FinnHubRepositoryImpl @Inject constructor(
    private val finnHubRemoteDataSource: FinnHubRemoteDataSource
) : FinnHubRepository {

    override suspend fun symbolLookup(query: String): Result<List<SymbolDto>, Throwable> =
        finnHubRemoteDataSource.symbolLookup(query)

}