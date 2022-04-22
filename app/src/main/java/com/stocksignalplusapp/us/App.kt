package com.stocksignalplusapp.us

import android.app.Application
import com.yandex.metrica.ReporterConfig
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber


@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        val configYandexMetric = YandexMetricaConfig.newConfigBuilder(BuildConfig.APP_METRICA_API_KEY)
            .withLogs()
            .build()
        val configReporterYandexMetric = ReporterConfig.newConfigBuilder(BuildConfig.APP_METRICA_API_KEY_REPORTER)
            .withLogs()
            .build()
        YandexMetrica.activate(applicationContext, configYandexMetric)
        YandexMetrica.activateReporter(applicationContext, configReporterYandexMetric)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}