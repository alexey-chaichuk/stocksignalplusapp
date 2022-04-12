package com.stocksignalplusapp.us

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main), MenuDrawer  {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onResume() {
        super.onResume()
        binding.menuNavigation.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
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

}

interface MenuDrawer {
    fun openMenu()
    fun closeMenu()
}