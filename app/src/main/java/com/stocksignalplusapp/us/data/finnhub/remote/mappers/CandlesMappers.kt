package com.stocksignalplusapp.us.data.finnhub.remote.mappers

import com.stocksignalplusapp.us.data.finnhub.remote.dto.CandlesDto
import com.stocksignalplusapp.us.domain.models.Candles

fun CandlesDto.toDomain(): Candles {
    return Candles(
        closePrice,
        highPrice,
        lowPrice,
        openPrice,
        status,
        timestamp,
        volume
    )
}

fun Candles.fromDomain(): CandlesDto {
    return CandlesDto(
        closePrice,
        highPrice,
        lowPrice,
        openPrice,
        status,
        timestamp,
        volume
    )
}