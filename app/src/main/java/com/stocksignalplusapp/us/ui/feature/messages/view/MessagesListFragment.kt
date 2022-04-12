package com.stocksignalplusapp.us.ui.feature.messages.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.data.mock.MessagesMock
import com.stocksignalplusapp.us.databinding.FragmentMessagesListBinding
import com.stocksignalplusapp.us.ui.feature.main.view.ToolbarHolder

class MessagesListFragment : Fragment(R.layout.fragment_messages_list) {

    private val binding by viewBinding(FragmentMessagesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.messagesRv.adapter = MessagesListAdapter()
        (binding.messagesRv.adapter as MessagesListAdapter).bindMessages(MessagesMock.getItems())

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val toolbar = parentFragment?.parentFragment
        if(toolbar is ToolbarHolder) {
            toolbar.setCaption(getString(R.string.messages))
            toolbar.hideDisclaimerIcon()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}