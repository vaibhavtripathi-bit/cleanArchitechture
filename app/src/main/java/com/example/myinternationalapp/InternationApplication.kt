package com.example.myinternationalapp

import android.app.Application
import com.example.myinternationalapp.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class InternationApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@InternationApplication)
            modules(provideDependency())
        }
    }

    //List of Koin dependencies
    private fun provideDependency() = appComponent
}