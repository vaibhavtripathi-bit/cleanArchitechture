package com.example.myinternationalapp.module.feature_display_localized.presentation.adapter

sealed class AppLocale {
    class Title(
        val title: String
    ) : AppLocale()
}
