package com.example.myinternationalapp.feature_display_localized.presentation.model

data class UiModel<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): UiModel<T> {
            return UiModel(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): UiModel<T> {
            return UiModel(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): UiModel<T> {
            return UiModel(Status.LOADING, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}