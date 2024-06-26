package com.example.myinternationalapp.module.feature_display_localized.domain.use_case

import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.module.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.flow.Flow

class GetSelectedLocaleUseCase(
    private val repository: LocalizedDataRepository
) {

    operator fun invoke(): Flow<SelectedLocale> {
        return repository.getSupportedLocale()
    }
}
