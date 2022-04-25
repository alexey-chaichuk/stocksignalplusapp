package com.stocksignalplusapp.us.ui.feature.analysis.view

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.mikephil.charting.data.*
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentAnalysisBinding
import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisEvent
import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.text.SimpleDateFormat


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

        val from = SimpleDateFormat("yyyy-MM-dd").parse("2022-03-20")?.time
        val to = SimpleDateFormat("yyyy-MM-dd").parse("2022-04-20")?.time
        if (to != null && from != null) {
            viewModel.getCandles(stockItem, "D", from /1000, to /1000)
        }
    }

    private fun handleEvents(event: AnalysisEvent) {
        when (event) {
            is AnalysisEvent.Waiting -> {}
            is AnalysisEvent.GotCandles -> {
                val candles = event.candles
                val eList = mutableListOf<Entry>()
                with(candles) {
                    var x: Float = 1f
                    closePrice.forEach { price ->
                        eList.add(
                            Entry(
                                x, price
                            )
                        )
                        x += 1f
                    }
                }
                val ds = LineDataSet(eList, "Close price")
                with(ds) {
                    setDrawIcons(false)
                    color = Color.GREEN
                    setDrawCircles(false)
                    lineWidth = 2f
                }

                with(binding.analysisChart) {
                    legend.isEnabled = false
                    data = LineData(ds)
                    data.setDrawValues(false)
                    invalidate()
                }
            }
        }
    }
}