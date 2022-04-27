package com.stocksignalplusapp.us.ui.feature.disclaimer.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentDisclaimerBinding

class DisclaimerFragment : Fragment(R.layout.fragment_disclaimer) {
    private val binding by viewBinding(FragmentDisclaimerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentDisclaimerBackBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}