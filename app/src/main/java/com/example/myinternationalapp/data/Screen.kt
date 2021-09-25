package com.example.myinternationalapp.data

sealed class Screen(val value: String) {
    object MainHelloTextScreen: Screen("hello_text_screen")
}
