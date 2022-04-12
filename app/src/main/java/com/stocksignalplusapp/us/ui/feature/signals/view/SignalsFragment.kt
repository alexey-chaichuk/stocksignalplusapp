package com.stocksignalplusapp.us.ui.feature.signals.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.data.mock.MessagesMock
import com.stocksignalplusapp.us.data.mock.SignalsMock
import com.stocksignalplusapp.us.databinding.FragmentMessagesListBinding
import com.stocksignalplusapp.us.databinding.FragmentSignalsBinding
import com.stocksignalplusapp.us.ui.feature.messages.view.MessagesListAdapter

class SignalsFragment : Fragment(R.layout.fragment_signals) {

    private val binding by viewBinding(FragmentSignalsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signalsRv.adapter = SignalsListAdapter()
        (binding.signalsRv.adapter as SignalsListAdapter).bindSignals(SignalsMock.getItems())

    }
}