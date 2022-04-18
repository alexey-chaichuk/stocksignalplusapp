package com.stocksignalplusapp.us.ui.feature.analysis.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentAnalysisBinding
import com.stocksignalplusapp.us.ui.feature.analysis.viewmodel.AnalysisViewModel

class AnalysisFragment : Fragment(R.layout.fragment_analysis) {
    private val binding by viewBinding(FragmentAnalysisBinding::bind)
    private val viewModel: AnalysisViewModel by viewModels()

}