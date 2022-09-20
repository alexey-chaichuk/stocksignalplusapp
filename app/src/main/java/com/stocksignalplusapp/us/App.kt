package com.stocksignalplusapp.us

import android.app.Application
import com.stocksignalplusapp.us.di.appModule
import com.stocksignalplusapp.us.di.configsModule
import com.stocksignalplusapp.us.di.finnHubModule
import com.stocksignalplusapp.us.di.networkModule
import com.yandex.metrica.ReporterConfig
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber


class App: Application() {

    override fun onCreate() {
        super.onCreate()


        Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@App)
            androidLogger(level = Level.DEBUG)
            modules(listOf(
                appModule,
                configsModule,
                finnHubModule,
                networkModule
            ))
        }

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

        /*val firebaseOptions = FirebaseOptions.Builder()
            .setProjectId(BuildConfig.MY_FIREBASE_PROJECT_ID)
            .setStorageBucket(BuildConfig.MY_FIREBASE_STORAGE_BUCKET)
            .setApplicationId(BuildConfig.MY_FIREBASE_APP_ID)
            .setApiKey(BuildConfig.MY_FIREBASE_API_KEY)
            .build()
        FirebaseApp.initializeApp(this, firebaseOptions)
        Timber.d("FirebaseApp initialized")*/
    }
}