package com.example.myinternationalapp.feature_display_localized.data.local.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalizedDao {

    @Query("SELECT * FROM DBLocalizeData")
    fun getNotes(): Flow<List<DBLocalizeData>>

    @Query("SELECT * FROM DBLocalizeData WHERE id = :id")
    suspend fun getNoteById(id: Int): DBLocalizeData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: DBLocalizeData)

    @Delete
    suspend fun deleteNote(note: DBLocalizeData)

}