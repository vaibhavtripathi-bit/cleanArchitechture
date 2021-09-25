package com.example.myinternationalapp.feature_display_localized.domain.use_case

import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.flow.Flow

class GetLocalizedDataFromLocal(
    private val repository: LocalizedDataRepository
) {

    operator fun invoke(supportedLocale: String): Flow<List<LocalizedData>> {
        return repository.oberveLocalizedData(supportedLocale)
    }
}