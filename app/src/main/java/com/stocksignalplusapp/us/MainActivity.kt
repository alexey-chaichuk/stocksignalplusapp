package com.stocksignalplusapp.us

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.databinding.ActivityMainBinding
import com.stocksignalplusapp.us.ui.feature.main.view.MainFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main), MenuDrawer, DisclaimerHolder  {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onResume() {
        super.onResume()
        binding.menuNavigation.itemIconTintList = null
        binding.menuNavigation.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.privacy_policy -> binding.navHostFragmentContentMain.findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToPrivacyPolicyFragment())
            }
            binding.drawerLayout.close()
            true
        }

    }

    override fun openMenu() {
        binding.drawerLayout.open()
    }

    override fun closeMenu() {
        binding.drawerLayout.close()
    }

    override fun openDisclaimer() {
        binding.navHostFragmentContentMain.findNavController()
            .navigate(MainFragmentDirections.actionMainFragmentToDisclaimerFragment())
    }

}

interface MenuDrawer {
    fun openMenu()
    fun closeMenu()
}

interface DisclaimerHolder {
    fun openDisclaimer()
}