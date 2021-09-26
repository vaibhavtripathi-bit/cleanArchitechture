package com.example.myinternationalapp.module.feature_display_localized.domain.use_case

import com.example.myinternationalapp.module.feature_display_localized.domain.repository.LocalizedDataRepository

class LocaleAvailabilityUseCase(
    private val repository: LocalizedDataRepository
) {

    suspend operator fun invoke(supportedLocale: String): Boolean {
        return false
    }
}