package com.contactkaran.mywordsdictionary.domain.utils

sealed class WordOrder {
    object Ascending: WordOrder()
    object Descending: WordOrder()
}