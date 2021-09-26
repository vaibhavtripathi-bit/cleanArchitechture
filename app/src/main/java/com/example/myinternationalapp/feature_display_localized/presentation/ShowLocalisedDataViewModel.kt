package com.example.myinternationalapp.feature_display_localized.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myinternationalapp.R
import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.feature_display_localized.data.constant.LocalizedKeyConstant.Companion.HelloTextScreen
import com.example.myinternationalapp.feature_display_localized.domain.use_case.ShowLocalizedDataUseCase
import com.example.myinternationalapp.feature_display_localized.presentation.model.ShowLocalizedUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ShowLocalisedDataViewModel(
    private val localizedDataUseCase: ShowLocalizedDataUseCase
) : ViewModel() {

    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.LoadingState)
    val viewState: StateFlow<ViewState> = _viewState

    fun initializeData(context: Context) {
        viewModelScope.launch {
            localizedDataUseCase.getGetSelectedLocaleUseCase().collect {
                localizedDataUseCase.getLocalizedDataFromLocal(
                    screen = Screen.MainHelloTextScreen,
                    selectedLocale = it
                ).collect {
                    // update localized values of all model classes here.
                    updateViewState(
                        ViewState.ValueAvailableState(
                            ShowLocalizedUiModel(
                                it.getValueForKey(
                                    HelloTextScreen.hello_world
                                ) ?: context.resources.getString(R.string.hello_world)
                            )
                        )
                    )
                }
            }
        }
    }

    fun loadDataFromLocale(title: String) {
        val supportedLocale = SelectedLocale.getSupportedLocale(title)
        viewModelScope.launch {
            if (!localizedDataUseCase.localeAvailabilityUseCase(title)) {
                localizedDataUseCase.getLocalizedDataFromRemote(
                    screen = Screen.MainHelloTextScreen,
                    selectedLocale = supportedLocale
                )
            }
        }
    }

    private fun updateViewState(viewState: ViewState) {
        _viewState.value = viewState
    }

    sealed class ViewState {
        object LoadingState : ViewState()
        class ValueAvailableState(val uiModel: ShowLocalizedUiModel) : ViewState()
    }
}