package com.example.myinternationalapp.di

import com.example.myinternationalapp.feature_display_localized.domain.use_case.GetLocalizedDataFromLocal
import com.example.myinternationalapp.feature_display_localized.domain.use_case.GetLocalizedDataFromRemote
import com.example.myinternationalapp.feature_display_localized.domain.use_case.LocaleAvailabilityUseCase
import com.example.myinternationalapp.feature_display_localized.domain.use_case.ShowLocalizedDataUseCase
import org.koin.dsl.module

val useCases = module {
    single {
        GetLocalizedDataFromLocal(get())
    }

    single {
        GetLocalizedDataFromRemote(get())
    }

    single {
        LocaleAvailabilityUseCase(get())
    }

    single {
        ShowLocalizedDataUseCase(get(), get(), get())
    }
}
