package com.example.myinternationalapp.feature_display_localized.data.local.db.entity.convertter

import androidx.room.TypeConverter
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.feature_display_localized.data.local.db.entity.DBLocalizeData
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken

object EntityTypeConverter {
    @TypeConverter
    fun fromDBLocalizeData(localizedData: DBLocalizeData?): String? {
        localizedData?.let {
            return Gson().toJson(localizedData, DBLocalizeData::class.java)
        }
        return null
    }

    @TypeConverter
    fun toDBLocalizeData(jsonString: String?): DBLocalizeData? {
        jsonString?.let {
            return Gson().fromJson(jsonString, DBLocalizeData::class.java)
        }
        return null
    }

    @TypeConverter
    fun fromSelectedLocale(localizedData: SelectedLocale): String {
        return localizedData.name
    }

    @TypeConverter
    fun toSelectedLocale(selectedLocale: String?): SelectedLocale {
        selectedLocale?.let {
            return SelectedLocale.getSupportedLocale(selectedLocale)
        }
        return SelectedLocale.ENGLISH
    }

    @TypeConverter
    fun toHashMap(value: JsonElement): Map<String, String> =
        Gson().fromJson(value, object : TypeToken<Map<String, String>>() {}.type)

    @TypeConverter
    fun fromHashMap(value: Map<String, String>): String =
        Gson().toJson(value)

}