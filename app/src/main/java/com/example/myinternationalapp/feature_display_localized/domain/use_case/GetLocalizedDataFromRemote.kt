package com.example.myinternationalapp.feature_display_localized.domain.use_case

import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository
import com.example.myinternationalapp.feature_display_localized.utils.SupportedLocale
import kotlinx.coroutines.flow.Flow

class GetLocalizedDataFromRemote(
    private val repository: LocalizedDataRepository
) {

    operator fun invoke(supportedLocale: String): Flow<List<LocalizedData>> {
        return repository.fetchLocalizedDataFromRemote(supportedLocale)
    }
}