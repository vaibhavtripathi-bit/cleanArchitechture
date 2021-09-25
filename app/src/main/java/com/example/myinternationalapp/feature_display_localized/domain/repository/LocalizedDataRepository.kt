package com.example.myinternationalapp.feature_display_localized.domain.repository

import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import kotlinx.coroutines.flow.Flow

interface LocalizedDataRepository {
    fun oberveLocalizedData(supportedLocale: String): Flow<List<LocalizedData>>

    fun fetchLocalizedDataFromRemote(supportedLocale: String): Flow<List<LocalizedData>>

    suspend fun saveLocalizedData(localizedData: LocalizedData)

    suspend fun updateLocalizedData(localizedData: LocalizedData): LocalizedData?

    suspend fun deleteLocalizedData(localizedData: LocalizedData)
}