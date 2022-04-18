package com.stocksignalplusapp.us.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Signal(
    val name: String,
    val ticker: String,
    val stockImage: Int
): Parcelable
