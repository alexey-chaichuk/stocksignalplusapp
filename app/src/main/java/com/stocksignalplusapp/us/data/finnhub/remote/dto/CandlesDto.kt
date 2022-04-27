package com.stocksignalplusapp.us.data.finnhub.remote.dto

import com.google.gson.annotations.SerializedName

data class CandlesDto(
    @SerializedName("c")
    val closePrice: List<Float>,

    @SerializedName("h")
    val highPrice: List<Float>,

    @SerializedName("l")
    val lowPrice: List<Float>,

    @SerializedName("o")
    val openPrice: List<Float>,

    @SerializedName("s")
    val status: String,

    @SerializedName("t")
    val timestamp: List<Long>,

    @SerializedName("v")
    val volume: List<Long>,
)
