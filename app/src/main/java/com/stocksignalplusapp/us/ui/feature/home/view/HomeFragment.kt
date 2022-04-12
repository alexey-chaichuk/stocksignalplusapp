package com.stocksignalplusapp.us.ui.feature.home.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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

    private fun handleEvents(event: HomeScreenEvents) {
        when (event) {
            HomeScreenEvents.Waiting -> {}
        }
    }
}