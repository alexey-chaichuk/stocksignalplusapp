package com.stocksignalplusapp.us.data.finnhub.remote.mappers

import com.stocksignalplusapp.us.data.finnhub.remote.dto.SymbolDto
import com.stocksignalplusapp.us.domain.models.StockItem

fun StockItem.fromDomain(): SymbolDto {
    return SymbolDto(
        description = name,
        displaySymbol = "",
        symbol = ticker,
        type = ""
    )
}

fun SymbolDto.toDomain(): StockItem {
    return StockItem(
        name = description,
        ticker = symbol,
        stockImage = null,
        stockImageUrl = null
    )
}