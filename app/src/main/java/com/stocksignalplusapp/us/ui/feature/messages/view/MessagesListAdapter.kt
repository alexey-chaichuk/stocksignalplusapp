package com.stocksignalplusapp.us.ui.feature.messages.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.data.models.Message

class MessagesListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var messages = listOf<Message>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MessageDataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.view_holder_message_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MessageDataViewHolder -> {
                holder.onBind(messages[position])
            }
        }
    }

    override fun getItemCount(): Int = messages.size

    fun bindMessages(newMessages : List<Message>) {
        messages = newMessages
        notifyDataSetChanged()
    }
}

private class MessageDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val title: TextView = itemView.findViewById(R.id.message_item_caption)
    private val text: TextView = itemView.findViewById(R.id.message_item_description)
    private val date: TextView = itemView.findViewById(R.id.message_item_date)

    fun onBind(message: Message) {

        title.text = message.title
        text.text = message.text
        date.text = message.date
    }
}