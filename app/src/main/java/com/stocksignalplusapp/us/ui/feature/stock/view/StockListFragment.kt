package com.stocksignalplusapp.us.ui.feature.stock.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.TopFragmentHolder
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
    private var topFragmentHolder: TopFragmentHolder? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topParent = parentFragment?.parentFragment
        if(topParent is ToolbarHolder) {
            topParent.setCaption(getString(R.string.stock))
            topParent.hideDisclaimerIcon()
        }

        val activity = requireActivity()
        if(activity is TopFragmentHolder) topFragmentHolder = activity

        binding.stockItemsRv.adapter = StockItemListAdapter(topFragmentHolder)
        (binding.stockItemsRv.adapter as StockItemListAdapter).bindStockItems(StockItemsMock.getItems())

        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    override fun onDestroyView() {
        topFragmentHolder = null
        super.onDestroyView()
    }

    private fun handleEvents(event: StockListEvent) {
        when (event) {
            StockListEvent.Waiting -> {}
        }
    }
}