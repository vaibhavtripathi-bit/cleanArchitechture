package com.example.myinternationalapp.feature_display_localized.domain.use_case

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository

class GetLocalizedDataFromRemote(
    private val repository: LocalizedDataRepository
) {

    suspend operator fun invoke(screen: Screen, selectedLocale: SelectedLocale): LocalizedData {
        return repository.fetchLocalizedDataFromRemote(screen, selectedLocale)
    }
}