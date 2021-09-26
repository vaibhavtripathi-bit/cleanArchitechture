package com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myinternationalapp.data.SelectedLocale

@Entity
data class DBSelectedLocale(
    @PrimaryKey
    val id: Int = 1,
    val locale: SelectedLocale = SelectedLocale.ENGLISH
)