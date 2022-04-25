package com.stocksignalplusapp.us.ui.feature.search.view

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentSearchBinding
import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisEvent
import com.stocksignalplusapp.us.ui.feature.search.viewmodel.SearchEvent
import com.stocksignalplusapp.us.ui.feature.search.viewmodel.SearchViewModel
import com.stocksignalplusapp.us.util.afterTextChanged
import com.stocksignalplusapp.us.util.exhaustive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchEditText.afterTextChanged(viewModel::onNewQuery)
        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    private fun handleEvents(event: SearchEvent) {
        when (event) {
            is SearchEvent.Waiting -> {}
            is SearchEvent.SuccessResult -> {

            }
            is SearchEvent.ErrorResult -> {

            }
        }
    }

}