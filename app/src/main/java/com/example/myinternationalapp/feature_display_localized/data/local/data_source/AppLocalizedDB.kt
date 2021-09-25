package com.example.myinternationalapp.feature_display_localized.data.local.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myinternationalapp.feature_display_localized.data.constant.Constants
import org.koin.core.KoinComponent

@Database(
    entities = [LocalizedDao::class],
    version = 1,
    exportSchema = false
)
abstract class AppLocalizedDB : RoomDatabase(), KoinComponent {
    abstract fun searchDao(): LocalizedDao

    companion object {
        private val instance: AppLocalizedDB? = null
        fun getInstance(context: Context): AppLocalizedDB = instance ?: synchronized(this) {
            buildDataBase(context) as AppLocalizedDB
        }

        private fun buildDataBase(context: Context): RoomDatabase {
            return Room.databaseBuilder(context, AppLocalizedDB::class.java, Constants.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}