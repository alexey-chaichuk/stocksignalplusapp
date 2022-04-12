package com.stocksignalplusapp.us.ui.feature.main.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.MainActivity
import com.stocksignalplusapp.us.MenuDrawer
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private var menuDrawer : MenuDrawer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeMenuBtn.setOnClickListener {
            menuDrawer?.openMenu()
        }

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MenuDrawer) {
            menuDrawer = context
        }
    }

    override fun onDetach() {
        menuDrawer = null
        super.onDetach()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        binding.bottomNavigation.setupWithNavController(
            binding.fragmentMainNavHostContainer.findNavController()
        )
    }
}