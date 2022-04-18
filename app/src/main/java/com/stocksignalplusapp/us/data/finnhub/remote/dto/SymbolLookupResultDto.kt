package com.stocksignalplusapp.us.data.finnhub.remote.dto

import com.google.gson.annotations.SerializedName

data class SymbolLookupResultDto (
    @SerializedName("count")
    val count : Int,

    @SerializedName("result")
    val result : List<SymbolDto>,
)