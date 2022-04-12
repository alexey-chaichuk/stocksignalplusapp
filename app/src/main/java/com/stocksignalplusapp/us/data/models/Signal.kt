package com.stocksignalplusapp.us.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Signal(
    val name: String,
    val ticker: String,
    val stockImage: Int
): Parcelable
