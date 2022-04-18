package com.stocksignalplusapp.us.data.mock

import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.domain.models.StockItem

object StockItemsMock {
    private val items = listOf(
        StockItem("Apple Inc.", "AAPL", R.drawable.aapl),
        StockItem("Tesla, Inc.", "TSLA", R.drawable.tsla),
        StockItem("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        StockItem("Apple Inc.", "AAPL", R.drawable.aapl),
        StockItem("Tesla, Inc.", "TSLA", R.drawable.tsla),
        StockItem("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        StockItem("Apple Inc.", "AAPL", R.drawable.aapl),
        StockItem("Tesla, Inc.", "TSLA", R.drawable.tsla),
        StockItem("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        StockItem("Apple Inc.", "AAPL", R.drawable.aapl),
        StockItem("Tesla, Inc.", "TSLA", R.drawable.tsla),
        StockItem("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        StockItem("Apple Inc.", "AAPL", R.drawable.aapl),
        StockItem("Tesla, Inc.", "TSLA", R.drawable.tsla),
        StockItem("Amazon.com, Inc", "AMZN", R.drawable.amzn),
        StockItem("Apple Inc.", "AAPL", R.drawable.aapl),
        StockItem("Tesla, Inc.", "TSLA", R.drawable.tsla),
        StockItem("Amazon.com, Inc", "AMZN", R.drawable.amzn),
    )

    fun getItems(): List<StockItem> = items
}