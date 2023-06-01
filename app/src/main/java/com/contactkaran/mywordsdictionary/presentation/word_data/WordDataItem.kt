package com.contactkaran.mywordsdictionary.presentation.word_data

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.BookmarkAdded
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.contactkaran.mywordsdictionary.domain.model.Definition
import com.contactkaran.mywordsdictionary.domain.model.Meaning
import com.contactkaran.mywordsdictionary.domain.model.WordData

@Composable
fun WordDataItem(wordData: WordData, onBookmarkClicked: (WordData) -> Unit){
    Column() {
        DisplayWord(wordData, onBookmarkClicked)
        DisplayPhonetic(wordData.phonetic)
        DisplayMeanings(wordData.meanings)
        DisplaySourceUrls(wordData.sourceUrls)
    }
}

@Composable
fun DisplaySourceUrls(sourceUrls: List<String>?) {

    Text(text = "Source: ", fontStyle = FontStyle.Italic)
    sourceUrls?.forEach { sourceUrl ->
        Text(modifier = Modifier,
            text = "$sourceUrls")
    }
}

@Composable
fun DisplayMeanings(meanings: List<Meaning>?) {
    meanings?.forEach { meaning ->
        DisplayPartOfSpeech(meaning.partOfSpeech)
        DisplayDefinitions(meaning.definitions)
    }
}

@Composable
fun DisplayDefinitions(definitions: List<Definition>?) {
    definitions?.forEachIndexed { index, definition ->
        DisplayDefinition(index, definition)
    }
}

@Composable
fun DisplayDefinition(index: Int, definition: Definition?) {
    Text(text = "${index + 1}. ${definition?.definition ?: ""}")
    Spacer(modifier = Modifier)
    Text(text = "Example: ${definition?.example ?: ""}")
    Spacer(modifier = Modifier)
}

@Composable
fun DisplayPartOfSpeech(partOfSpeech: String?) {
    Text(text = partOfSpeech ?: "", fontStyle = FontStyle.Normal)
}

@Composable
fun DisplayPhonetic(phonetic: String?) {
    Text(text = phonetic ?: "")
    Spacer(modifier = Modifier)
}

@Composable
fun DisplayWord(wordData: WordData, onBookmarkClicked: (WordData) -> Unit) {
    var isSaved by remember{
        mutableStateOf(wordData.isSaved)
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(text = wordData.word, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.fillMaxWidth())
        Icon(
            imageVector = if(isSaved) Icons.Rounded.BookmarkAdded else Icons.Rounded.BookmarkBorder,
            contentDescription = "Favorite",
            modifier = Modifier
                .clickable {
                    isSaved = !isSaved
                    wordData.isSaved = !wordData.isSaved
                    onBookmarkClicked(wordData)
                }
                .align(Alignment.CenterVertically))
    }
}
