package com.example.myinternationalapp.feature_display_localized.domain.model

import com.example.myinternationalapp.feature_display_localized.utils.SupportedLocale

data class LocalizedData(
    val screen: Int?,
    val supportedLocale: SupportedLocale,
    val key: String,
    val value: String
)