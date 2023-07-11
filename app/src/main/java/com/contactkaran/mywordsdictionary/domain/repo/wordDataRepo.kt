package com.contactkaran.mywordsdictionary.domain.repo

import com.contactkaran.mywordsdictionary.domain.model.WordData
import com.contactkaran.mywordsdictionary.utils.DataStatus
import kotlinx.coroutines.flow.Flow


interface WordDataRepo {

    fun getWordData(word: String): Flow<DataStatus<List<WordData>>>

}