package com.contactkaran.mywordsdictionary.data.remote.dto

data class WordDataDto(
    val word: String,
    val phonetics: List<PhoneticDto>?,
    val meanings: List<MeaningDto>?,
    val licence: LicenceDto?,
    val sourceUrls: List<String>?
)