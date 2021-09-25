package com.example.myinternationalapp.di

import com.example.myinternationalapp.feature_display_localized.presentation.ShowLocalisedDataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelDependency = module {
    viewModel {
        ShowLocalisedDataViewModel(
            localizedDataUseCase = get()
        )
    }
}
