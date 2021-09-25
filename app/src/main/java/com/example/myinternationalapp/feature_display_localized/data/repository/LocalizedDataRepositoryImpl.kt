package com.example.myinternationalapp.feature_display_localized.data.repository

import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalizedDataRepositoryImpl: LocalizedDataRepository {
    override fun oberveLocalizedData(supportedLocale: String): Flow<List<LocalizedData>> = flow {
        emit(listOf(
        ))
    }

    override fun fetchLocalizedDataFromRemote(supportedLocale: String): Flow<List<LocalizedData>> = flow {
        emit(listOf())
    }

    override suspend fun saveLocalizedData(localizedData: LocalizedData) {
        TODO("Not yet implemented")
    }

    override suspend fun updateLocalizedData(localizedData: LocalizedData): LocalizedData? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteLocalizedData(localizedData: LocalizedData) {
        TODO("Not yet implemented")
    }
}