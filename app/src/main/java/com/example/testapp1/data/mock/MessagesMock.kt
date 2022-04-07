package com.example.testapp1.data.mock

import com.example.testapp1.data.models.Message
import com.example.testapp1.data.models.StockItem

object MessagesMock {
    private val items = listOf(
        Message("Top Gainer", "Check out today's top gainers", "21/12 20:36"),
        Message("Pattern Notification", "AMC earnings release at 04:15 PM", "22/12 14:36"),
        Message("Trade Idea", "\$DOCU 08/20 312.5C Entry:310, Targets :3 ", "23/12 20:37"),
        Message("Top Gainer", "Check out today's top gainers", "21/12 20:36"),
        Message("Pattern Notification", "AMC earnings release at 04:15 PM", "22/12 14:36"),
        Message("Trade Idea", "\$DOCU 08/20 312.5C Entry:310, Targets :3 ", "23/12 20:37"),
        Message("Top Gainer", "Check out today's top gainers", "21/12 20:36"),
        Message("Pattern Notification", "AMC earnings release at 04:15 PM", "22/12 14:36"),
        Message("Trade Idea", "\$DOCU 08/20 312.5C Entry:310, Targets :3 ", "23/12 20:37"),
        Message("Top Gainer", "Check out today's top gainers", "21/12 20:36"),
        Message("Pattern Notification", "AMC earnings release at 04:15 PM", "22/12 14:36"),
        Message("Trade Idea", "\$DOCU 08/20 312.5C Entry:310, Targets :3 ", "23/12 20:37"),
        Message("Top Gainer", "Check out today's top gainers", "21/12 20:36"),
        Message("Pattern Notification", "AMC earnings release at 04:15 PM", "22/12 14:36"),
        Message("Trade Idea", "\$DOCU 08/20 312.5C Entry:310, Targets :3 ", "23/12 20:37"),
        )

    fun getItems(): List<Message> = items
}