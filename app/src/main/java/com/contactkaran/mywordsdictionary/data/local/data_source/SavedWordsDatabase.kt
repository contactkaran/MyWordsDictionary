package com.contactkaran.mywordsdictionary.data.local.data_source

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity

@Database(
    entities = [WordDataEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class SavedWordsDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "saved_words_db"
    }

    abstract val savedWordsDao: SavedWordsDao
}