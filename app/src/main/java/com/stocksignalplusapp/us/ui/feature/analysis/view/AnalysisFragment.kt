package com.stocksignalplusapp.us.ui.feature.analysis.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentAnalysisBinding
import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisEvent
import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisViewModel
import com.stocksignalplusapp.us.ui.feature.stock.viewmodel.StockListEvent
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AnalysisFragment : Fragment(R.layout.fragment_analysis) {
    private val binding by viewBinding(FragmentAnalysisBinding::bind)
    private val viewModel: AnalysisViewModel by viewModels()
    private val args: AnalysisFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stockItem = args.stockItem
        Timber.d(stockItem.toString())

        binding.stockItemImage.setImageResource(stockItem.stockImage)
        binding.stockItemTicker.text = stockItem.ticker
        binding.stockItemName.text = stockItem.name

        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    private fun handleEvents(event: AnalysisEvent) {
        when (event) {
            AnalysisEvent.Waiting -> {}
        }
    }
}