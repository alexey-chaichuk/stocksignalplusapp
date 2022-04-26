package com.stocksignalplusapp.us.ui.feature.search.view

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.TopFragmentHolder
import com.stocksignalplusapp.us.data.mock.StockItemsMock
import com.stocksignalplusapp.us.databinding.FragmentSearchBinding
import com.stocksignalplusapp.us.domain.models.StockItem
import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisEvent
import com.stocksignalplusapp.us.ui.feature.search.viewmodel.SearchEvent
import com.stocksignalplusapp.us.ui.feature.search.viewmodel.SearchViewModel
import com.stocksignalplusapp.us.ui.feature.stock.view.StockItemListAdapter
import com.stocksignalplusapp.us.util.afterTextChanged
import com.stocksignalplusapp.us.util.exhaustive
import com.stocksignalplusapp.us.util.toGone
import com.stocksignalplusapp.us.util.toVisible
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import kotlin.math.truncate

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()
    private var topFragmentHolder: TopFragmentHolder? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity()
        if(activity is TopFragmentHolder) topFragmentHolder = activity

        binding.searchResultsRv.adapter = SearchResultsListAdapter(topFragmentHolder)

        with (binding.searchEditText) {
            afterTextChanged(viewModel::onNewQuery)
            showSoftInputOnFocus = true
            binding.searchEditText.requestFocus()
        }

        viewModel.events.observe(viewLifecycleOwner, ::handleEvents)
    }

    override fun onDestroyView() {
        topFragmentHolder = null
        super.onDestroyView()
    }

    private fun handleEvents(event: SearchEvent) {
        when (event) {
            is SearchEvent.Waiting -> {}
            is SearchEvent.SuccessResult -> {
                val symbols = event.stockItems
                if(symbols.isEmpty()) {
                    Timber.d("Received empty result")
                    binding.searchResultsRv.toGone()
                    with (binding.searchPlaceholder) {
                        text = "There are no results for your search"
                        toVisible()
                    }
                } else {
                    Timber.d("Received result: %s", symbols.toString())
                    binding.searchPlaceholder.toGone()
                    val stockItems = mutableListOf<StockItem>()
                    for (symbol in symbols) {
                        stockItems.add(StockItem(symbol.description, symbol.displaySymbol,
                            R.drawable.tsla, null))
                    }
                    (binding.searchResultsRv.adapter as SearchResultsListAdapter).bindStockItems(stockItems)
                    binding.searchResultsRv.toVisible()
                }
            }
            is SearchEvent.ErrorResult -> {
                binding.searchResultsRv.toGone()
                with (binding.searchPlaceholder) {
                    text = event.e.localizedMessage
                    toVisible()
                }

            }
        }
    }

}