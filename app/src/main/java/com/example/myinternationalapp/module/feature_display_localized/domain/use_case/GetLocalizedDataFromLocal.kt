package com.example.myinternationalapp.module.feature_display_localized.domain.use_case

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.module.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.module.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.flow.Flow

class GetLocalizedDataFromLocal(
    private val repository: LocalizedDataRepository
) {

    operator fun invoke(screen: Screen, selectedLocale: SelectedLocale): Flow<LocalizedData> {
        return repository.observerLocalizedData(screen, selectedLocale)
    }
}
