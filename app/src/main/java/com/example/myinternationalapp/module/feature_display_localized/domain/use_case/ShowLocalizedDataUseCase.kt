package com.example.myinternationalapp.module.feature_display_localized.domain.use_case

data class ShowLocalizedDataUseCase(
    val getLocalizedDataFromLocal: GetLocalizedDataFromLocal,
    val getLocalizedDataFromRemote: GetLocalizedDataFromRemote,
    val getGetSelectedLocaleUseCase: GetSelectedLocaleUseCase,
    val localeAvailabilityUseCase: LocaleAvailabilityUseCase
)