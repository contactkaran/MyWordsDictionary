package com.contactkaran.mywordsdictionary.data.remote.dto

data class PhoneticDto(
    val audio: String,
    val license: LicenceDto?,
    val sourceUrl: String?,
    val text: String?
)