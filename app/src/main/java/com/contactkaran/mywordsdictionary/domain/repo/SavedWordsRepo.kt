package com.contactkaran.mywordsdictionary.domain.repo

import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity
import kotlinx.coroutines.flow.Flow

interface SavedWordsRepo {
    fun getSavedWords(): Flow<List<WordDataEntity>>

    suspend fun insertIntoSaved(WordDataEntity: WordDataEntity)

    suspend fun deleteFromSaved(word: String?, phonetic: String?, meaning: List<Meaning>?)

    suspend fun isExistWord(word: String?, phonetic: String?, meaning: List<Meaning>?): Boolean
}