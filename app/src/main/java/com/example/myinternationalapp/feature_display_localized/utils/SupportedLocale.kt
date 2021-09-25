package com.example.myinternationalapp.feature_display_localized.utils

sealed class SupportedLocale(value: Int) {
    object ENGLISH: SupportedLocale(1)
    object SPANISH: SupportedLocale(2)
}