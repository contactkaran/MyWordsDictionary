package com.contactkaran.mywordsdictionary.presentation.word_data

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.contactkaran.mywordsdictionary.domain.model.WordData


@Composable
fun WordDataScreen(viewModel: WordDataViewModel = hiltViewModel()){
    val state = viewModel.state.collectAsState().value
    Box(modifier = Modifier) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)) {
            SearchBar(viewModel)
            Spacer(modifier = Modifier)
            WordDataList(viewModel, state.wordDataItems)

        }
    }
}
@Composable
fun SearchBar(viewModel: WordDataViewModel) = with(viewModel) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = wordQuery.value,
            onValueChange = { wordQuery ->
                fetchWordData(wordQuery)},
            maxLines = 1,
            placeholder = { Text(text = "Word search")})
    }
@Composable
fun WordDataList(viewModel: WordDataViewModel, wordDataItems: List<WordData>) {
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(wordDataItems.size) {item ->
            WordDataItem(wordData = wordDataItems[item], onBookmarkClicked = {clickedWord ->
                clickedWord.let { wordData ->
                    viewModel.saveOrRemoveWordData(wordData)
                }
            })
        }
    }
}