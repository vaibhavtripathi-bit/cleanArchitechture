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
    override fun observerLocalizedData(screen: Screen, selectedLocale: SelectedLocale): Flow<LocalizedData> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchLocalizedDataFromRemote(screen: Screen, selectedLocale: SelectedLocale): LocalizedData {
        TODO("Not yet implemented")
    }

    override fun getSupportedLocale(): Flow<SelectedLocale> {
        TODO("Not yet implemented")
    }
}
