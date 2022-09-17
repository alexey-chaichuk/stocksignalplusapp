package com.stocksignalplusapp.us.ui.feature.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.TopFragmentHolder
import com.stocksignalplusapp.us.databinding.FragmentHomeBinding
import com.stocksignalplusapp.us.domain.models.StockItem
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenEvents
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenViewModel
import com.stocksignalplusapp.us.ui.feature.main.view.ToolbarHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeScreenViewModel by viewModels()
    private var topFragmentHolder: TopFragmentHolder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState -> handleEvents(uiState) }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = parentFragment?.parentFragment
        if(toolbar is ToolbarHolder) {
            toolbar.setCaption(getString(R.string.stock_signal))
            toolbar.showDisclaimerIcon()
        }
        val activity = requireActivity()
        if(activity is TopFragmentHolder) topFragmentHolder = activity

    }

    override fun onDestroyView() {
        topFragmentHolder = null

        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()

        with(binding.card11) {
            signalItemTicker.text = "TSLA"
            signalItemName.text = "Tesla, Inc."
            signalItemImage.setImageResource(R.drawable.tsla)
        }

        with(binding.card21) {
            stockItemTicker.text = "AAPL"
            stockItemName.text = "Apple Inc."
            stockItemImage.setImageResource(R.drawable.aapl)
            stockItemAnalysis.setOnClickListener {
                topFragmentHolder?.openAnalysis(StockItem("Apple Inc.", "AAPL", R.drawable.aapl))
            }
        }

        with(binding.card22) {
            stockItemTicker.text = "TSLA"
            stockItemName.text = "Tesla Inc."
            stockItemImage.setImageResource(R.drawable.tsla)
            stockItemAnalysis.setOnClickListener {
                topFragmentHolder?.openAnalysis(StockItem("Apple Inc.", "TSLA", R.drawable.tsla))
            }
        }

        with(binding.card23) {
            stockItemTicker.text = "AMZN"
            stockItemName.text = "Amazon.com, Inc."
            stockItemImage.setImageResource(R.drawable.amzn)
            stockItemAnalysis.setOnClickListener {
                topFragmentHolder?.openAnalysis(StockItem("Amazon.com, Inc.", "AMZN", R.drawable.amzn))
            }
        }

        with(binding.card31) {
            messageItemCaption.text = "Top Gainer"
            messageItemDescription.text = "Check out today's top gainers"
            messageItemDate.text = "22/12 20:36"
        }

        with(binding.card32) {
            messageItemCaption.text = "Trade Idea"
            messageItemDescription.text = "\$DOCU 08/20 312.5C Entry:310, Targets :3"
            messageItemDate.text = "22/12 20:36"
        }

        with(binding.card33) {
            messageItemCaption.text = "Pattern Notification"
            messageItemDescription.text = "AMC earnings release at 04:15 PM"
            messageItemDate.text = "22/12 20:36"
        }

        /*binding.fragmentHomeReadMoreStocks.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToStockListFragment())
        }

        binding.fragmentHomeReadMoreMessages.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMessagesListFragment())
        }*/
    }

    private fun handleEvents(event: HomeScreenEvents) {
        when (event) {
            HomeScreenEvents.Waiting -> {}
        }
    }
}