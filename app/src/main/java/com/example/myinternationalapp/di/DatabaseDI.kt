package com.example.myinternationalapp.di

import com.example.myinternationalapp.module.feature_display_localized.data.local.db.AppLocalizedDB
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val roomModule = module {
    single { AppLocalizedDB.getInstance(androidContext()) }
    single { get<AppLocalizedDB>().localizedDao() }
}
