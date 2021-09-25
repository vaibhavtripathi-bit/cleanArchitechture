package com.example.myinternationalapp.feature_display_localized.data.repository

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SupportedLocale
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalizedDataRepositoryImpl : LocalizedDataRepository {
    override fun observerLocalizedData(screen: Screen, supportedLocale: SupportedLocale): Flow<LocalizedData> = flow {
        val localizedData = HashMap<String, String>().apply {
            when (supportedLocale) {
                SupportedLocale.ENGLISH -> {
                    put("Hello World", "My ENGLISH Text")
                }
                SupportedLocale.SPANISH -> {
                    put("Hello World", "My SPANISH Text")
                }
            }
        }
        emit(
            LocalizedData(
                screen = Screen.MainHelloTextScreen,
                supportedLocale = SupportedLocale.ENGLISH,
                localisedKeyValue = localizedData
            )
        )
    }

    override suspend fun fetchLocalizedDataFromRemote(screen: Screen, supportedLocale: SupportedLocale): LocalizedData {
        val localisedKeyValue = LocalizedData(
            screen = Screen.MainHelloTextScreen,
            supportedLocale = SupportedLocale.ENGLISH,
            localisedKeyValue = HashMap()
        )
        // save to DB
        return localisedKeyValue
    }

//    override suspend fun saveLocalizedData(localizedData: LocalizedData) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun updateLocalizedData(localizedData: LocalizedData): LocalizedData? {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun deleteLocalizedData(localizedData: LocalizedData) {
//        TODO("Not yet implemented")
//    }
}