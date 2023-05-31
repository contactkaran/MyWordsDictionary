package com.contactkaran.mywordsdictionary.domain.mappers

import com.contactkaran.mywordsdictionary.data.remote.dto.DefinitionDto
import com.contactkaran.mywordsdictionary.data.remote.dto.MeaningDto
import com.contactkaran.mywordsdictionary.data.remote.dto.WordDataDto
import com.contactkaran.mywordsdictionary.domain.model.Definition
import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.model.WordData
import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity


fun DefinitionDto.toDefinition(): Definition {
    return Definition(
        antonyms = antonyms, definition = definition, example = example, synonyms = synonyms
    )
}

fun MeaningDto.toMeaning(): Meaning {
    return Meaning(
        definitions = definitions?.map {
            it.toDefinition()
        }, partOfSpeech = partOfSpeech
    )
}

fun WordDataDto.toWordData(): WordData {
    return WordData(word = word,
        phonetic = phonetics?.mapNotNull {
            it.text
        }?.toSet()?.joinToString(", ")?.replace("/", ""),
        sourceUrls = sourceUrls,
        meanings = meanings?.map { it.toMeaning() })
}


fun WordData.toWordDataEntity(): WordDataEntity{

}