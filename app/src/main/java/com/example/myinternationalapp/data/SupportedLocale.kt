package com.example.myinternationalapp.data

sealed class SupportedLocale(val name: String, val value: Int) {
    object ENGLISH : SupportedLocale(name = "ENGLISH", value = 1)
    object SPANISH : SupportedLocale(name = "SPANISH", value = 1)

    companion object {
        fun getSupportedLocale(title: String): SupportedLocale {
            return when (title) {
                ENGLISH.name -> {
                    ENGLISH
                }
                SPANISH.name -> {
                    SPANISH
                }
                else -> {
                    throw Exception("Unknown Localization")
                }
            }
        }
    }
}