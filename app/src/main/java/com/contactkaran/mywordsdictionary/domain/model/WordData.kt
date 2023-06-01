package com.contactkaran.mywordsdictionary.domain.model

data class WordData(
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>?,
    val sourceUrls: List<String>?,
    var isSaved: Boolean = false
)