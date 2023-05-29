package com.contactkaran.mywordsdictionary.domain.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.contactkaran.mywordsdictionary.domain.model.Meaning
import java.util.Date

@Entity
data class WordDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>,
    val sourceURLs: List<String>?,
    val date: Date?
)