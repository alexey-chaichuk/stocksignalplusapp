package com.stocksignalplusapp.us.ui.feature.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentHomeBinding
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenEvents
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenViewModel
import com.stocksignalplusapp.us.ui.feature.main.view.ToolbarHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val toolbar = parentFragment?.parentFragment
        if(toolbar is ToolbarHolder) {
            toolbar.setCaption(getString(R.string.stock_signal))
            toolbar.showDisclaimerIcon()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        binding.card11.signalItemTicker.text = "TSLA"
        binding.card11.signalItemName.text = "Tesla, Inc."
        binding.card11.signalItemImage.setImageResource(R.drawable.tsla)


        binding.card21.stockItemTicker.text =  "AAPL"
        binding.card21.stockItemName.text = "Apple Inc."
        binding.card21.stockItemImage.setImageResource(R.drawable.aapl)

        binding.card22.stockItemTicker.text =  "TSLA"
        binding.card22.stockItemName.text = "Tesla Inc."
        binding.card22.stockItemImage.setImageResource(R.drawable.tsla)

        binding.card23.stockItemTicker.text =  "AMZN"
        binding.card23.stockItemName.text = "Amazon.com, Inc."
        binding.card23.stockItemImage.setImageResource(R.drawable.amzn)


        binding.card31.messageItemCaption.text = "Top Gainer"
        binding.card31.messageItemDescription.text = "Check out today's top gainers"
        binding.card31.messageItemDate.text = "22/12 20:36"

        binding.card32.messageItemCaption.text = "Trade Idea"
        binding.card32.messageItemDescription.text = "\$DOCU 08/20 312.5C Entry:310, Targets :3"
        binding.card32.messageItemDate.text = "22/12 20:36"

        binding.card33.messageItemCaption.text = "Pattern Notification"
        binding.card33.messageItemDescription.text = "AMC earnings release at 04:15 PM"
        binding.card33.messageItemDate.text = "22/12 20:36"


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