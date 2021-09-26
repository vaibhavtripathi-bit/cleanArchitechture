package com.example.myinternationalapp.feature_display_localized.domain.repository

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.feature_display_localized.data.local.db.entity.DBSelectedLocale
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import kotlinx.coroutines.flow.Flow

interface LocalizedDataRepository {
    fun observerLocalizedData(screen: Screen, selectedLocale: SelectedLocale): Flow<LocalizedData>

    suspend fun fetchLocalizedDataFromRemote(screen: Screen, selectedLocale: SelectedLocale): LocalizedData

    fun getSupportedLocale(): Flow<SelectedLocale>

//    suspend fun saveLocalizedData(localizedData: LocalizedData)
//
//    suspend fun updateLocalizedData(localizedData: LocalizedData): LocalizedData?
//
//    suspend fun deleteLocalizedData(localizedData: LocalizedData)
}