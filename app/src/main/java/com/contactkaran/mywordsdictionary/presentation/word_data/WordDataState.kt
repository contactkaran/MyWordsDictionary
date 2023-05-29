package com.contactkaran.mywordsdictionary.presentation.word_data

import com.contactkaran.mywordsdictionary.domain.model.WordData

data class WordDataState(
    val wordDataItems: List<WordData> = emptyList(),
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)