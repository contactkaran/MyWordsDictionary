package com.contactkaran.mywordsdictionary.domain.model

data class WordData(
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>?,
    val sourceURLs: List<String>?,
    var isSaved: Boolean = false
)