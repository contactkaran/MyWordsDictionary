package com.contactkaran.mywordsdictionary.data.local.repo

import com.contactkaran.mywordsdictionary.data.local.data_source.SavedWordsDao
import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity
import com.contactkaran.mywordsdictionary.domain.repo.SavedWordsRepo
import kotlinx.coroutines.flow.Flow

class SavedWordsRepoImpl(private val dao: SavedWordsDao) : SavedWordsRepo {

    override fun getSavedWords(): Flow<List<WordDataEntity>> {
        return dao.getSavedWords()
    }

    override suspend fun insertIntoSaved(wordDataEntity: WordDataEntity) {
        return dao.insertIntoSaved(wordDataEntity)
    }

    override suspend fun deleteFromSaved(
        word: String?, phonetic: String?, meanings: List<Meaning>?
    ) {
        return dao.deleteFromSaved(word, phonetic, meanings)
    }

    override suspend fun isExistWord(
        word: String?, phonetic: String?, meanings: List<Meaning>?
    ): Boolean {
        return dao.isExistWord(word, phonetic, meanings)
    }

}