package com.example.myinternationalapp.feature_display_localized.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
//TODO : Make localisation as hashmap and modify the EntityTypeConverter to support this change.
@Entity
class DBLocalizeData(
    @PrimaryKey(autoGenerate = true)
    val locale: Int,
    val screen: Int,
    val localisation: String
)