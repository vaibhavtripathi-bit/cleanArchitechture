package com.example.myinternationalapp.feature_display_localized.domain.repository

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SupportedLocale
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import kotlinx.coroutines.flow.Flow

interface LocalizedDataRepository {
    fun observerLocalizedData(screen: Screen, supportedLocale: SupportedLocale): Flow<LocalizedData>

    suspend fun fetchLocalizedDataFromRemote(screen: Screen, supportedLocale: SupportedLocale): LocalizedData

//    suspend fun saveLocalizedData(localizedData: LocalizedData)
//
//    suspend fun updateLocalizedData(localizedData: LocalizedData): LocalizedData?
//
//    suspend fun deleteLocalizedData(localizedData: LocalizedData)
}