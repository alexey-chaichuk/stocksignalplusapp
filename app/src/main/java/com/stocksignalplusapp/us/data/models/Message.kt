package com.stocksignalplusapp.us.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val title: String,
    val text: String,
    val date: String
): Parcelable
