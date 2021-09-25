package com.example.myinternationalapp.di

import com.example.myinternationalapp.feature_display_localized.domain.use_case.GetLocalizedDataFromLocal
import com.example.myinternationalapp.feature_display_localized.domain.use_case.GetLocalizedDataFromRemote
import com.example.myinternationalapp.feature_display_localized.domain.use_case.LocaleAvailabilityUseCase
import com.example.myinternationalapp.feature_display_localized.domain.use_case.GetSelectedLocaleUseCase
import com.example.myinternationalapp.feature_display_localized.domain.use_case.ShowLocalizedDataUseCase
import org.koin.dsl.module

val useCases = module {
    factory {
        GetLocalizedDataFromLocal(get())
    }

    factory {
        GetLocalizedDataFromRemote(get())
    }

    factory {
        LocaleAvailabilityUseCase(get())
    }

    factory {
        GetSelectedLocaleUseCase(get())
    }

    factory {
        ShowLocalizedDataUseCase(get(), get(), get(), get())
    }
}
