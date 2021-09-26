package com.example.myinternationalapp.feature_display_localized.domain.model

import com.example.myinternationalapp.data.Screen
import com.example.myinternationalapp.data.SelectedLocale

data class LocalizedData(
    val screen: Screen,
    val selectedLocale: SelectedLocale,
    val localisedKeyValue: HashMap<String, String> = HashMap()
) {
    fun getValueForKey(key: String): String? {
        return localisedKeyValue.get(key)
    }
}