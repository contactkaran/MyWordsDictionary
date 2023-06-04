package com.contactkaran.mywordsdictionary.presentation.saved_words

import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity
import com.contactkaran.mywordsdictionary.domain.utils.WordOrder

data class SavedWordsState(
    var wordDataEntityItems: List<WordDataEntity> = emptyList(),
    val filteredWordDataEntityItems: List<WordDataEntity> = emptyList(),
    val isEmpty: Boolean = false,
    val wordOrder: WordOrder = WordOrder.Descending
)