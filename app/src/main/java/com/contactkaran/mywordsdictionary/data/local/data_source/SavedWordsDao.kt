package com.contactkaran.mywordsdictionary.data.local.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedWordsDao {

    @Query("SELECT * FROM WordDataEntity")
    fun getSavedWords(): Flow<List<WordDataEntity>>

    @Query("SELECT EXISTS (SELECT * FROM WordDataEntity WHERE word =:word and phonetic=:phonetic AND meanings=:meanings)")
    suspend fun isExistWord(word: String?, phonetic: String?, meanings: List<Meaning>?): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIntoSaved(wordDataEntity: WordDataEntity)

    @Query("DELETE FROM WordDataEntity WHERE word=:word AND phonetic=:phonetic AND meanings=:meanings")
    suspend fun deleteFromSaved(word: String?, phonetic: String?, meanings: List<Meaning>?)

}