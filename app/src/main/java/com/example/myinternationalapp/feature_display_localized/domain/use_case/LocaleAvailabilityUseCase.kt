package com.example.myinternationalapp.feature_display_localized.domain.use_case

import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.flow.Flow

class LocaleAvailabilityUseCase(
    private val repository: LocalizedDataRepository
) {

    suspend operator fun invoke(supportedLocale: String): Boolean {
        return false
    }
}