package com.contactkaran.mywordsdictionary.domain.use_case

import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.repo.SavedWordsRepo

class RemoveFromSaved(
    val repo: SavedWordsRepo
) {
    suspend operator fun invoke(word: String?, phonetic: String?, meanings: List<Meaning>?) {
        repo.deleteFromSaved(word, phonetic, meanings)
    }
}