package com.example.myinternationalapp.module.feature_display_localized.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myinternationalapp.module.feature_display_localized.data.constant.Constants
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.dao.LocalizedDao
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity.DBLocalizeData
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity.DBSelectedLocale
import com.example.myinternationalapp.module.feature_display_localized.data.local.db.entity.convertter.EntityTypeConverter
import org.koin.core.KoinComponent

@TypeConverters(EntityTypeConverter::class)
@Database(
    entities = [DBLocalizeData::class, DBSelectedLocale::class],
    version = 1,
    exportSchema = false
)
abstract class AppLocalizedDB : RoomDatabase(), KoinComponent {
    abstract fun localizedDao(): LocalizedDao

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
