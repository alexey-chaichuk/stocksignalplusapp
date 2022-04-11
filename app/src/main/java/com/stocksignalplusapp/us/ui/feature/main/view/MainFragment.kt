package com.stocksignalplusapp.us.ui.feature.main.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeMenuBtn.setOnClickListener {
            binding.drawerLayout.open()
        }

        binding.menuNavigation.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            binding.drawerLayout.close()
            true
        }

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
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