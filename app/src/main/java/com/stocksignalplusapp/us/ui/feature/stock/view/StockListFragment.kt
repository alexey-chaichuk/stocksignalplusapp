package com.stocksignalplusapp.us.ui.feature.stock.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.data.mock.StockItemsMock
import com.stocksignalplusapp.us.databinding.FragmentStockListBinding
import com.stocksignalplusapp.us.ui.feature.main.view.ToolbarHolder
import com.stocksignalplusapp.us.ui.feature.stock.viewmodel.StockListEvent
import com.stocksignalplusapp.us.ui.feature.stock.viewmodel.StockListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockListFragment : Fragment(R.layout.fragment_stock_list) {

    private val binding by viewBinding(FragmentStockListBinding::bind)
    private val viewModel: StockListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.stockItemsRv.adapter = StockItemListAdapter()
        (binding.stockItemsRv.adapter as StockItemListAdapter).bindStockItems(StockItemsMock.getItems())

        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val toolbar = parentFragment?.parentFragment
        if(toolbar is ToolbarHolder) {
            toolbar.setCaption(getString(R.string.stock))
            toolbar.hideDisclaimerIcon()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun handleEvents(event: StockListEvent) {
        when (event) {
            StockListEvent.Waiting -> {}
        }
    }
}