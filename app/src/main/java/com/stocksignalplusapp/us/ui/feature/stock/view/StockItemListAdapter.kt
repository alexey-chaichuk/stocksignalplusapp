package com.stocksignalplusapp.us.ui.feature.stock.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.TopFragmentHolder
import com.stocksignalplusapp.us.domain.models.StockItem
import timber.log.Timber

class StockItemListAdapter(
    private val topFragmentHolder: TopFragmentHolder?
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var stockItems = listOf<StockItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StockDataViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.view_holder_stock_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is StockDataViewHolder -> {
                holder.onBind(stockItems[position])
                val analysisBtn: ImageButton = holder.itemView.findViewById(R.id.stock_item_analysis)
                analysisBtn.setOnClickListener {
                    Timber.d("topFragmentHolder -> %s", topFragmentHolder)
                    Timber.d("stockItem -> %s", stockItems[position].toString())
                    topFragmentHolder?.openAnalysis(stockItems[position])
                }
            }
        }
    }

    override fun getItemCount(): Int = stockItems.size

    fun bindStockItems(newStockItems : List<StockItem>) {
        stockItems = newStockItems
        notifyDataSetChanged()
    }
}

private class StockDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val stockImage: ImageView = itemView.findViewById(R.id.stock_item_image)
    private val name: TextView = itemView.findViewById(R.id.stock_item_name)
    private val ticker: TextView = itemView.findViewById(R.id.stock_item_ticker)

    fun onBind(stockItem: StockItem) {

        stockImage.load(stockItem.stockImage)
        name.text = stockItem.name
        ticker.text = stockItem.ticker
    }
}