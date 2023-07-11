package com.contactkaran.mywordsdictionary.presentation.saved_words

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.contactkaran.mywordsdictionary.domain.model.Definition
import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity

@Composable
fun SavedWordsItem(wordDataEntity: WordDataEntity, onBookmarkClicked: (WordDataEntity) -> Unit) {
    Column {
        DisplayWord(wordDataEntity, onBookmarkClicked)
        DisplayPhonetic(wordDataEntity.phonetic)
        DisplayMeanings(wordDataEntity.meanings)
        DisplaySourceUrls(wordDataEntity.sourceUrls)
    }
}

@Composable
private fun DisplayWord(
    wordDataEntity: WordDataEntity, onBookmarkClicked: (WordDataEntity) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = wordDataEntity.word,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.ExtraBold
        )
//        Spacer(modifier = Modifier.width(3.dp)
        Text(text = "")
        Icon(imageVector = Icons.Default.Bookmark,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable {
                    onBookmarkClicked(wordDataEntity)
                })
    }
}


@Composable
private fun DisplayPhonetic(phonetic: String?) {
    Text(text = phonetic ?: "")
    Text(text = "")
}

@Composable
private fun DisplayMeanings(meanings: List<Meaning>?) {
    meanings?.forEach { meaning ->
        DisplayPartOfSpeech(meaning.partOfSpeech)
        DisplayDefinitions(meaning.definitions)
    }
}

@Composable
private fun DisplayPartOfSpeech(partOfSpeech: String?) {
    Text(text = partOfSpeech ?: "", fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
}

@Composable
private fun DisplayDefinitions(definitions: List<Definition>?) {
    definitions?.forEachIndexed { index, definition ->
        DisplayDefinition(index, definition)
    }
}

@Composable
private fun DisplayDefinition(index: Int, definition: Definition?) {
    Text(text = "${index + 1}. ${definition?.definition ?: ""}")
    Text(text = "")
    Text(text = "Example: ${definition?.example ?: ""}")
    Text(text = "")
}

@Composable
fun DisplaySourceUrls(sourceUrls: List<String>?) {

    androidx.compose.material3.Text(text = "Source: ", fontStyle = FontStyle.Italic)
    sourceUrls?.forEach { sourceUrl ->
        androidx.compose.material3.Text(
            modifier = Modifier,
            text = "$sourceUrls"
        )
    }
}