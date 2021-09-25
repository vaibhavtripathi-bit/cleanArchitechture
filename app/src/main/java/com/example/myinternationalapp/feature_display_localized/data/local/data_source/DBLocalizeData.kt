package com.example.myinternationalapp.feature_display_localized.data.local.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DBLocalizeData(
    val screen: Int?,
    val module: Int?,
    val key: String,
    val value: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)