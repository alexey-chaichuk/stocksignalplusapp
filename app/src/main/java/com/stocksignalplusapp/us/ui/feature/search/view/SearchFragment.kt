package com.stocksignalplusapp.us.ui.feature.search.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.TopFragmentHolder
import com.stocksignalplusapp.us.databinding.FragmentSearchBinding
import com.stocksignalplusapp.us.domain.models.StockItem
import com.stocksignalplusapp.us.ui.feature.search.viewmodel.SearchEvent
import com.stocksignalplusapp.us.ui.feature.search.viewmodel.SearchViewModel
import com.stocksignalplusapp.us.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel: SearchViewModel by viewModels()
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

        val activity = requireActivity()
        if (activity is TopFragmentHolder) topFragmentHolder = activity

        with(binding.searchResultsRv) {
            adapter = SearchResultsListAdapter(topFragmentHolder)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                        recyclerView.hideKeyboard()
                    }
                }
            })
        }

        with(binding.searchEditText) {
            afterTextChanged(viewModel::onNewQuery)
            binding.searchEditText.requestFocus()
            showKeyboard()
        }

    }

    override fun onDestroyView() {
        topFragmentHolder = null
        super.onDestroyView()
    }

    private fun handleEvents(event: SearchEvent) {
        when (event) {
            is SearchEvent.Waiting -> {}
            is SearchEvent.Searching -> {
                binding.searchResultsRv.toGone()
                with(binding.searchPlaceholder) {
                    text = "Searching..."
                    toVisible()
                }
            }
            is SearchEvent.SuccessResult -> {
                val symbols = event.stockItems
                if (symbols.isEmpty()) {
                    Timber.d("Received empty result")
                    binding.searchResultsRv.toGone()
                    with(binding.searchPlaceholder) {
                        text = "There are no results for your search"
                        toVisible()
                    }
                } else {
                    Timber.d("Received result: %s", symbols.toString())
                    binding.searchPlaceholder.toGone()
                    val stockItems = mutableListOf<StockItem>()
                    for (symbol in symbols) {
                        stockItems.add(
                            StockItem(
                                symbol.description, symbol.displaySymbol,
                                R.drawable.tsla, null
                            )
                        )
                    }
                    (binding.searchResultsRv.adapter as SearchResultsListAdapter).bindStockItems(
                        stockItems
                    )
                    binding.searchResultsRv.toVisible()
                }
            }
            is SearchEvent.ErrorResult -> {
                binding.searchResultsRv.toGone()
                with(binding.searchPlaceholder) {
                    text = event.e.localizedMessage
                    toVisible()
                }

            }
        }
    }

}