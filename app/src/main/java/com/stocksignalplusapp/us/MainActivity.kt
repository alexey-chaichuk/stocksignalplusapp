package com.stocksignalplusapp.us

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.stocksignalplusapp.us.databinding.ActivityMainBinding
import com.stocksignalplusapp.us.domain.models.StockItem
import com.stocksignalplusapp.us.ui.feature.main.view.MainFragmentDirections
import com.yandex.metrica.YandexMetrica
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main), MenuDrawer, TopFragmentHolder  {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val date = SimpleDateFormat("yyyy-M-d hh:mm:ss", Locale.getDefault()).format(Date())

        firebaseAnalytics = Firebase.analytics
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW) {
            param(FirebaseAnalytics.Param.SCREEN_NAME, "home")
            param(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        }

        YandexMetrica.reportEvent("Start date and time", date)
        YandexMetrica.reportAppOpen(this)
    }

    override fun onResume() {
        super.onResume()
        binding.menuNavigation.itemIconTintList = null
        binding.menuNavigation.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.privacy_policy -> binding.navHostFragmentContentMain.findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToPrivacyPolicyFragment())
                R.id.profile -> binding.navHostFragmentContentMain.findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToSignInFragment())
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

    override fun openAnalysis(stockItem: StockItem) {
        binding.navHostFragmentContentMain.findNavController()
            .navigate(MainFragmentDirections.actionMainFragmentToAnalysisFragment(stockItem))
    }

}

interface MenuDrawer {
    fun openMenu()
    fun closeMenu()
}

interface TopFragmentHolder {
    fun openDisclaimer()
    fun openAnalysis(stockItem: StockItem)
}