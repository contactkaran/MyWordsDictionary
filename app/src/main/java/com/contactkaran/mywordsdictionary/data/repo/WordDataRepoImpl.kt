package com.contactkaran.mywordsdictionary.data.repo

import com.contactkaran.mywordsdictionary.data.local.data_source.SavedWordsDao
import com.contactkaran.mywordsdictionary.data.remote.DictionaryApiService
import com.contactkaran.mywordsdictionary.domain.mappers.toWordData
import com.contactkaran.mywordsdictionary.domain.model.WordData
import com.contactkaran.mywordsdictionary.domain.repo.WordDataRepo
import com.contactkaran.mywordsdictionary.utils.DataStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordDataRepoImpl(
    private val dictionaryApi: DictionaryApiService, private val dao: SavedWordsDao
) : WordDataRepo {
    override fun getWordData(word: String): Flow<DataStatus<List<WordData>>> = flow {
        emit(DataStatus.Loading())
        try {
            val wordDatas = dictionaryApi.getWordData(word).map { it.toWordData() }

            wordDatas.forEach { wordDataItem ->
                wordDataItem.isSaved =
                    dao.isExistWord(wordDataItem.word, wordDataItem.phonetic, wordDataItem.meanings)
            }

            emit(DataStatus.Success(wordDatas))
        } catch (e: Exception) {
            emit(DataStatus.Error(e.message))
        }
    }
}