package com.contactkaran.mywordsdictionary.presentation.saved_words

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.contactkaran.mywordsdictionary.domain.model.entity.WordDataEntity
import com.contactkaran.mywordsdictionary.domain.utils.WordOrder
import com.contactkaran.mywordsdictionary.presentation.saved_words.components.OrderRadioButtons
import com.contactkaran.mywordsdictionary.ui.theme.SpaceSize

@Composable
fun SavedWordsScreen(viewModel: SavedWordsViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState().value
    val wordQuery = remember {
        mutableStateOf("")
    }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceSize.ExtraLarge)
        ) {
            SearchBar(wordQuery, viewModel, state.wordOrder)
            Spacer(modifier = Modifier.height(SpaceSize.Normal))
            OrderRadioButtons(wordOrder = state.wordOrder, onOrderChange = { wordOrder ->
                viewModel.getWords(wordOrder, wordQuery.value)
            })
            SavedWordList(viewModel, state.filteredWordDataEntityItems)
        }
        when {
            state.isEmpty -> Text(
                text = "There is nothing here :(", modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun SearchBar(
    wordQuery: MutableState<String>, viewModel: SavedWordsViewModel, wordOrder: WordOrder
) {
    OutlinedTextField(modifier = Modifier.fillMaxWidth(),
        value = wordQuery.value,
        onValueChange = { text ->
            viewModel.getWords(wordOrder, text)
            wordQuery.value = text
        },
        maxLines = 1,
        placeholder = { Text("Search in saved words") })
}

@Composable
fun SavedWordList(viewModel: SavedWordsViewModel, wordDataEntityItems: List<WordDataEntity>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(wordDataEntityItems.size) { i ->
            SavedWordsItem(wordDataEntityItems[i], onBookmarkClicked = { clickedWord ->
                clickedWord.let { wordDataEntity ->
                    viewModel.removeWord(wordDataEntity)
                }
            })
        }
    }
}

