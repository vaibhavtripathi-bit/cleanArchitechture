package com.example.myinternationalapp.module.feature_display_localized.data.repository

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.dao.LocalizedDao
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity.DBLocalizeData
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity.DBSelectedLocale
import com.example.myinternationalapp.module.feature_display_localized.data.network.apiservices.LocaleApiService
import com.example.myinternationalapp.module.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.module.feature_display_localized.domain.repository.LocalizedDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.KoinComponent
import org.koin.core.inject

class LocalizedDataRepositoryImpl : LocalizedDataRepository, KoinComponent {

    private val localizedDao by inject<LocalizedDao>()
    private val localeApiService by inject<LocaleApiService>()
    //TODO: Context(Dispatchers.IO) need to be part of constructor or injectable

    override fun observerLocalizedData(screen: Screen, selectedLocale: SelectedLocale): Flow<LocalizedData> = flow {
        val localizedData = getLocalizedData(selectedLocale)
        emit(
            LocalizedData(
                screen = Screen.MainHelloTextScreen,
                selectedLocale = selectedLocale,
                localisedKeyValue = localizedData
            )
        )
    }.cancellable()
        .flowOn(Dispatchers.IO)

    private fun getLocalizedData(selectedLocale: SelectedLocale): HashMap<String, String> {
        val localizedData = HashMap<String, String>().apply {
            when (selectedLocale) {
                SelectedLocale.ENGLISH -> {
                    put("hello_world", "Hello World")
                    put("other_world", "Other World")
                }
                SelectedLocale.SPANISH -> {
                    put("hello_world", "Hola Mundo")
                    put("other_world", "Otro mundo")
                }
                SelectedLocale.GERMAN -> {
                    put("hello_world", "Hallo Welt")
                    put("other_world", "Andere Welt")
                }
                SelectedLocale.FRENCH -> {
                    put("hello_world", "Bonjour le monde")
                    put("other_world", "Autre monde")
                }
            }
        }
        return localizedData
    }

    override suspend fun fetchLocalizedDataFromRemote(screen: Screen, selectedLocale: SelectedLocale): LocalizedData {
        val localeValue = when (selectedLocale) {
            SelectedLocale.ENGLISH -> {
                SelectedLocale.ENGLISH.value
            }
            SelectedLocale.SPANISH -> {
                SelectedLocale.SPANISH.value
            }
            SelectedLocale.GERMAN -> {
                SelectedLocale.GERMAN.value
            }
            SelectedLocale.FRENCH -> {
                SelectedLocale.FRENCH.value
            }
        }

        val localisedKeyValue = LocalizedData(
            screen = Screen.MainHelloTextScreen,
            selectedLocale = SelectedLocale.ENGLISH,
            localisedKeyValue = HashMap()
        )
        val localisation = DBLocalizeData(
            screen = 1,
            locale = localeValue,
            localisation = "Ignore, since we are using mockk data"
        )
        localizedDao.insertLocalizedData(localisation)

        localizedDao.insertSelectedLocale(
            DBSelectedLocale(
                locale = selectedLocale
            )
        )
        return localisedKeyValue
    }

    override fun getSupportedLocale(): Flow<SelectedLocale> = flow {
        localizedDao.getSelectedLocale().collect { selectedLocale ->
            if (selectedLocale.isNotEmpty()) {
                emit(SelectedLocale.getSupportedLocale(selectedLocale.first().locale.name))
            } else {
                emit(SelectedLocale.ENGLISH)
            }
        }
    }.distinctUntilChanged().cancellable()
        .flowOn(Dispatchers.IO)
}