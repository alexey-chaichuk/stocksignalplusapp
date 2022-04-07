package com.example.testapp1.ui.feature.stock.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testapp1.R
import com.example.testapp1.data.mock.StockItemsMock
import com.example.testapp1.databinding.FragmentStockListBinding
import com.example.testapp1.ui.feature.stock.viewmodel.StockListEvent
import com.example.testapp1.ui.feature.stock.viewmodel.StockListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockListFragment : Fragment(R.layout.fragment_stock_list) {

    private val binding by viewBinding(FragmentStockListBinding::bind)
    private val viewModel: StockListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.stockItemsRv.adapter = StockItemListAdapter()
        (binding.stockItemsRv.adapter as StockItemListAdapter).bindStockItems(StockItemsMock.getItems())

        binding.stockItemsMessageBtn.setOnClickListener {
            findNavController().navigate(
                StockListFragmentDirections.actionStockListFragmentToMessagesListFragment()
            )
        }

        binding.stockItemsMenu.setOnClickListener {
            findNavController().navigate(
                StockListFragmentDirections.actionStockListFragmentToSignUpFragment()
            )
        }

        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    private fun handleEvents(event: StockListEvent) {
        when (event) {
            StockListEvent.Waiting -> {}
        }
    }
}