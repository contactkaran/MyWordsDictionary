package com.contactkaran.mywordsdictionary.domain.use_case

import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity
import com.contactkaran.mywordsdictionary.domain.repo.SavedWordsRepo
import com.contactkaran.mywordsdictionary.domain.utils.WordOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSavedWords (
    val repo: SavedWordsRepo
        ){
    operator fun invoke(
        wordOrder: WordOrder = WordOrder.Descending
    ): Flow<List<WordDataEntity>>{
        return repo.getSavedWords().map { wordEntities ->
            when (wordOrder) {
                is WordOrder.Ascending -> wordEntities.sortedBy { it.date }
                is WordOrder.Descending -> wordEntities.sortedByDescending { it.date }
            }
        }
    }
}