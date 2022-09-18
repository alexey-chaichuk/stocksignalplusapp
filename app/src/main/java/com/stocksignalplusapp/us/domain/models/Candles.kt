package com.stocksignalplusapp.us.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Candles(
    val closePrice: List<Float>,
    val highPrice: List<Float>,
    val lowPrice: List<Float>,
    val openPrice: List<Float>,
    val status: String,
    val timestamp: List<Long>,
    val volume: List<Long>
): Parcelable