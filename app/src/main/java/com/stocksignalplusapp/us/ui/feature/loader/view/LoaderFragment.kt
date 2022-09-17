package com.stocksignalplusapp.us.ui.feature.loader.view

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentLoaderBinding
import com.stocksignalplusapp.us.ui.feature.loader.viewmodel.LoaderEvents
import com.stocksignalplusapp.us.ui.feature.loader.viewmodel.LoaderViewModel
import kotlinx.coroutines.launch

class LoaderFragment : Fragment(R.layout.fragment_loader) {
    private val binding by viewBinding(FragmentLoaderBinding::bind)
    private val viewModel: LoaderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState -> handleEvents(uiState) }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        val timer = object: CountDownTimer(3000, 100) {
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                viewModel.onTimerFinish()
            }
        }
        timer.start()
    }

    private fun handleEvents(event: LoaderEvents) {
        when (event) {
            LoaderEvents.Waiting -> {}
            LoaderEvents.GoToHomeScreen ->
                findNavController()
                    .navigate(LoaderFragmentDirections.actionLoaderFragmentToMainFragment())
        }
    }
}