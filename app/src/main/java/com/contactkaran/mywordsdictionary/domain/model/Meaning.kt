package com.contactkaran.mywordsdictionary.domain.model

data class Meaning(
    val definitions: List<Definition>?,
    val partOfSpeech: String?
)