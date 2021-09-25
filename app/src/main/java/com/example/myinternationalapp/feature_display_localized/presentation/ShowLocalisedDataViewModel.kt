package com.example.myinternationalapp.feature_display_localized.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myinternationalapp.feature_display_localized.domain.model.LocalizedData
import com.example.myinternationalapp.feature_display_localized.domain.use_case.GetLocalizedDataFromLocal
import com.example.myinternationalapp.feature_display_localized.domain.use_case.GetLocalizedDataFromRemote
import com.example.myinternationalapp.feature_display_localized.domain.use_case.ShowLocalizedDataUseCase
import com.example.myinternationalapp.feature_display_localized.presentation.adapter.AppLocale
import com.example.myinternationalapp.feature_display_localized.presentation.model.Status
import com.example.myinternationalapp.feature_display_localized.presentation.model.UiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.util.Locale

class ShowLocalisedDataViewModel(
    private val localizedDataUseCase: ShowLocalizedDataUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiModel<LocalizedData>> = MutableStateFlow(UiModel(Status.LOADING, null, null))
    val uiState: StateFlow<UiModel<LocalizedData>> = _uiState

    fun loadDataFromLocale(title: String) {
        viewModelScope.launch {
            if(!localizedDataUseCase.localeAvailabilityUseCase(title)) {
                localizedDataUseCase.getLocalizedDataFromRemote(title).collect {
                    _uiState.asLiveData().value
                }
            }
        }

    }
}