package com.example.myinternationalapp.feature_display_localized.domain.use_case

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SupportedLocale
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.flow.Flow

class GetLocalizedDataFromRemote(
    private val repository: LocalizedDataRepository
) {

    suspend operator fun invoke(screen: Screen, supportedLocale: SupportedLocale): LocalizedData {
        return repository.fetchLocalizedDataFromRemote(screen, supportedLocale)
    }
}