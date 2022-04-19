package com.stocksignalplusapp.us.data.finnhub.remote.dto

import com.google.gson.annotations.SerializedName

data class CandlesDto(
    @SerializedName("c")
    val currentPrice: List<Double>,

    @SerializedName("h")
    val highPrice: List<Double>,

    @SerializedName("l")
    val lowPrice: List<Double>,

    @SerializedName("o")
    val openPrice: List<Double>,

    @SerializedName("s")
    val status: String,

    @SerializedName("t")
    val timestamp: List<Long>,

    @SerializedName("v")
    val volume: List<Long>,
)
