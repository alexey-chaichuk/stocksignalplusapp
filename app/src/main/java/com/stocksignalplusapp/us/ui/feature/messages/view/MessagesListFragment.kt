package com.stocksignalplusapp.us.ui.feature.messages.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.data.mock.MessagesMock
import com.stocksignalplusapp.us.databinding.FragmentMessagesListBinding

class MessagesListFragment : Fragment(R.layout.fragment_messages_list) {

    private val binding by viewBinding(FragmentMessagesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.messagesRv.adapter = MessagesListAdapter()
        (binding.messagesRv.adapter as MessagesListAdapter).bindMessages(MessagesMock.getItems())

        binding.messagesItemsCategoryBtn.setOnClickListener {
            findNavController().navigate(
                MessagesListFragmentDirections.actionMessagesListFragmentToStockListFragment()
            )
        }

    }
}