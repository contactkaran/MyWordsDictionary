package com.contactkaran.mywordsdictionary.domain.use_case

import com.contactkaran.mywordsdictionary.domain.repo.SavedWordsRepo

class AddIntoSaved (
    val repo: SavedWordsRepo
        )