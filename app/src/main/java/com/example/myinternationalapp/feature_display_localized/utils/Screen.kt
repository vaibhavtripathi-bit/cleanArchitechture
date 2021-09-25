package com.example.myinternationalapp.feature_display_localized.utils

sealed class Screen(val value: String) {
    object MainHelloTextScreen: Screen("hello_text_screen")
}
