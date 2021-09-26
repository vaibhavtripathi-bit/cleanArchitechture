package com.example.myinternationalapp.data

sealed class SelectedLocale(val name: String, val value: Int) {
    object ENGLISH : SelectedLocale(name = "ENGLISH", value = 1)
    object SPANISH : SelectedLocale(name = "SPANISH", value = 1)
    object GERMAN : SelectedLocale(name = "GERMAN", value = 1)
    object FRENCH : SelectedLocale(name = "FRENCH", value = 1)

    companion object {
        fun getSupportedLocale(title: String): SelectedLocale {
            return when (title) {
                ENGLISH.name -> {
                    ENGLISH
                }
                SPANISH.name -> {
                    SPANISH
                }
                GERMAN.name -> {
                    GERMAN
                }
                FRENCH.name -> {
                    FRENCH
                }
                else -> {
                    throw Exception("Unknown Localization")
                }
            }
        }
    }
}
