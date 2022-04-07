package com.example.testapp1.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StockItem(
    val name: String,
    val ticker: String,
    val stockImage: String
): Parcelable
