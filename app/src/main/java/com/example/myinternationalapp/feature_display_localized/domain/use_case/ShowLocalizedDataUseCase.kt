package com.example.myinternationalapp.feature_display_localized.domain.use_case

data class ShowLocalizedDataUseCase(
    val getLocalizedDataFromLocal: GetLocalizedDataFromLocal,
    val getLocalizedDataFromRemote: GetLocalizedDataFromRemote,
    val localeAvailabilityUseCase: LocaleAvailabilityUseCase
)