package com.example.testapp1.ui.feature.messages.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testapp1.R
import com.example.testapp1.data.mock.MessagesMock
import com.example.testapp1.data.mock.StockItemsMock
import com.example.testapp1.databinding.FragmentMessagesListBinding
import com.example.testapp1.ui.feature.stock.view.StockItemListAdapter

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