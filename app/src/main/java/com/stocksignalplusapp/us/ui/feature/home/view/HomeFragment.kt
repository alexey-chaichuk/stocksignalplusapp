package com.stocksignalplusapp.us.ui.feature.home.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentHomeBinding
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenEvents
import com.stocksignalplusapp.us.ui.feature.home.viewmodel.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    private fun handleEvents(event: HomeScreenEvents) {
        when (event) {
            HomeScreenEvents.Waiting -> {}
        }
    }
}