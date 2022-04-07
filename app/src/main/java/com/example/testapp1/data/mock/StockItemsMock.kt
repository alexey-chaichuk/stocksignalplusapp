package com.example.testapp1.data.mock

import com.example.testapp1.data.models.StockItem

object StockItemsMock {
    private val items = listOf(
        StockItem("Apple Inc.", "AAPL", "imgAAPL"),
        StockItem("Tesla, Inc.", "TSLA", "imgTSLA"),
        StockItem("Amazon.com, Inc", "AMZN", "imgAMZN"),
        StockItem("Apple Inc.", "AAPL", "imgAAPL"),
        StockItem("Tesla, Inc.", "TSLA", "imgTSLA"),
        StockItem("Amazon.com, Inc", "AMZN", "imgAMZN"),
        StockItem("Apple Inc.", "AAPL", "imgAAPL"),
        StockItem("Tesla, Inc.", "TSLA", "imgTSLA"),
        StockItem("Amazon.com, Inc", "AMZN", "imgAMZN"),
        StockItem("Apple Inc.", "AAPL", "imgAAPL"),
        StockItem("Tesla, Inc.", "TSLA", "imgTSLA"),
        StockItem("Amazon.com, Inc", "AMZN", "imgAMZN"),
    )

    fun getItems(): List<StockItem> = items
}