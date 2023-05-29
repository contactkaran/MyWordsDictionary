package com.contactkaran.mywordsdictionary.domain.use_case

import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.repo.SavedWordsRepo

class IsExistWord(
    val repo: SavedWordsRepo
) {
    suspend operator fun invoke(
        word: String?, phonetic: String?, meanings: List<Meaning>?
    ): Boolean {
        return repo.isExistWord(word, phonetic, meanings)
    }
}