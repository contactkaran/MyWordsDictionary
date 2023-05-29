package com.contactkaran.mywordsdictionary.domain.use_case

import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity
import com.contactkaran.mywordsdictionary.domain.repo.SavedWordsRepo

class AddIntoSaved(
    val repo: SavedWordsRepo
) {

    suspend operator fun invoke(wordDataEntity: WordDataEntity) {
        repo.insertIntoSaved(wordDataEntity)
    }
}