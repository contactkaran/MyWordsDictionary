package com.contactkaran.mywordsdictionary.domain.use_case

import com.contactkaran.mywordsdictionary.domain.model.WordData
import com.contactkaran.mywordsdictionary.domain.repo.WordDataRepo
import com.contactkaran.mywordsdictionary.utils.DataStatus
import kotlinx.coroutines.flow.Flow

class GetWordData(
    private val repo: WordDataRepo
){
    operator fun invoke(word: String): Flow<DataStatus<List<WordData>>>? {
        if(word.isNotBlank()) return repo.getWordData(word.trim())
        return null
    }
}