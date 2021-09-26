package com.example.myinternationalapp.di

import com.example.myinternationalapp.module.feature_display_localized.data.repository.LocalizedDataRepositoryMockImpl
import com.example.myinternationalapp.module.feature_display_localized.domain.repository.LocalizedDataRepository
import org.koin.dsl.module

val repositoryDependency = module {
    factory<LocalizedDataRepository> {
        LocalizedDataRepositoryMockImpl()
    }
}
