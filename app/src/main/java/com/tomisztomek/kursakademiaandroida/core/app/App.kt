package com.tomisztomek.kursakademiaandroida.core.app

import android.app.Application
import com.tomisztomek.kursakademiaandroida.core.di.koinInjecton
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@App)
            modules(koinInjecton)
        }
    }
}