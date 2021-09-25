package com.example.myinternationalapp.di

import com.example.myinternationalapp.feature_display_localized.data.repository.LocalizedDataRepositoryImpl
import com.example.myinternationalapp.feature_display_localized.domain.repository.LocalizedDataRepository
import org.koin.dsl.module

val repositoryDependency = module {
    factory<LocalizedDataRepository> {
        LocalizedDataRepositoryImpl()
    }
}
