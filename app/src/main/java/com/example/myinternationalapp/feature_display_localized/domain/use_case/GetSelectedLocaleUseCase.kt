package com.example.myinternationalapp.feature_display_localized.domain.use_case

import com.example.myinternationalapp.data.SupportedLocale
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository

class GetSelectedLocaleUseCase(
    private val repository: LocalizedDataRepository
) {

    suspend operator fun invoke(): SupportedLocale {
        return SupportedLocale.SPANISH
    }
}