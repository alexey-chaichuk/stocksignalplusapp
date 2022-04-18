package com.stocksignalplusapp.us.ui.feature.signals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.domain.models.Signal

class SignalsListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var signals = listOf<Signal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SignalDataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.view_holder_signal_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is SignalDataViewHolder -> {
                holder.onBind(signals[position])
            }
        }
    }

    override fun getItemCount(): Int = signals.size

    fun bindSignals(newSignals : List<Signal>) {
        signals = newSignals
        notifyDataSetChanged()
    }
}

private class SignalDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val ticker: TextView = itemView.findViewById(R.id.signal_item_ticker)
    private val name: TextView = itemView.findViewById(R.id.signal_item_name)

    fun onBind(signal: Signal) {
        ticker.text = signal.ticker
        name.text = signal.name
    }
}