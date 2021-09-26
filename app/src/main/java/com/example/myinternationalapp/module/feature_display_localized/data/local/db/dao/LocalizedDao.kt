package com.example.myinternationalapp.module.feature_display_localized.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity.DBLocalizeData
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity.DBSelectedLocale
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalizedDao {

    @Query("SELECT * FROM DBLocalizeData WHERE locale = :locale")
    fun getLocalizedDataForLocale(locale: Int): Flow<List<DBLocalizeData>>

    @Query("SELECT * FROM DBLocalizeData WHERE locale = :locale AND screen = :screen")
    fun getLocalizedDataForScreenAndLocale(screen: Int, locale: Int): Flow<List<DBLocalizeData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalizedData(note: DBLocalizeData)

    @Query("DELETE FROM DBLocalizeData WHERE locale = :locale AND screen = :screen")
    fun deleteLocalizedDataForScreenAndLocale(screen: Int, locale: Int)

    @Query("DELETE FROM DBLocalizeData WHERE locale = :locale")
    fun deleteLocalizedDataForLocale(locale: Int)

    @Query("SELECT * FROM DBSelectedLocale")
    fun getSelectedLocale(): Flow<List<DBSelectedLocale>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSelectedLocale(locale: DBSelectedLocale)

}