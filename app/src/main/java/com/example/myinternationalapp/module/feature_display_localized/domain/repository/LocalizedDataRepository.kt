package com.example.myinternationalapp.module.feature_display_localized.domain.repository

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.module.feature_display_localized.domain.model.LocalizedData
import kotlinx.coroutines.flow.Flow

interface LocalizedDataRepository {
    fun observerLocalizedData(screen: Screen, selectedLocale: SelectedLocale): Flow<LocalizedData>

    suspend fun fetchLocalizedDataFromRemote(screen: Screen, selectedLocale: SelectedLocale): LocalizedData

    fun getSupportedLocale(): Flow<SelectedLocale>
}