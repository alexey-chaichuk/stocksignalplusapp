package com.stocksignalplusapp.us.data.mock

import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.data.models.Signal

object SignalsMock {
    private val items = listOf(
        Signal("Apple Inc.", "AAPL", R.drawable.aapl),
        Signal("Tesla, Inc.", "TSLA", R.drawable.tsla),
        Signal("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        Signal("Apple Inc.", "AAPL", R.drawable.aapl),
        Signal("Tesla, Inc.", "TSLA", R.drawable.tsla),
        Signal("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        Signal("Apple Inc.", "AAPL", R.drawable.aapl),
        Signal("Tesla, Inc.", "TSLA", R.drawable.tsla),
        Signal("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        Signal("Apple Inc.", "AAPL", R.drawable.aapl),
        Signal("Tesla, Inc.", "TSLA", R.drawable.tsla),
        Signal("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        Signal("Apple Inc.", "AAPL", R.drawable.aapl),
        Signal("Tesla, Inc.", "TSLA", R.drawable.tsla),
        Signal("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        Signal("Apple Inc.", "AAPL", R.drawable.aapl),
        Signal("Tesla, Inc.", "TSLA", R.drawable.tsla),
        Signal("Amazon.com, Inc", "AMZN", R.drawable.amzn),
    )

    fun getItems(): List<Signal> = items
}