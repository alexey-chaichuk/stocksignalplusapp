package com.stocksignalplusapp.us

import android.R
import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
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
        Timber.d("YandexMetric initialized")

        val firebaseOptions = FirebaseOptions.Builder()
            .setProjectId(BuildConfig.MY_FIREBASE_PROJECT_ID)
            .setStorageBucket(BuildConfig.MY_FIREBASE_STORAGE_BUCKET)
            .setApplicationId(BuildConfig.MY_FIREBASE_APP_ID)
            .setApiKey(BuildConfig.MY_FIREBASE_API_KEY)
            .build()
        FirebaseApp.initializeApp(this, firebaseOptions)
        Timber.d("FirebaseApp initialized")
    }
}