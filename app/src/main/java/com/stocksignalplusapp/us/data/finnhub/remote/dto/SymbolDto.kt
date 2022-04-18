package com.stocksignalplusapp.us.data.finnhub.remote.dto

import com.google.gson.annotations.SerializedName

data class SymbolDto (
    @SerializedName("description")
    val description : String,

    @SerializedName("displaySymbol")
    val displaySymbol : String,

    @SerializedName("symbol")
    val symbol : String,

    @SerializedName("type")
    val type : String,
)