package com.contactkaran.mywordsdictionary.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.contactkaran.mywordsdictionary.domain.use_case.AddIntoSaved
import com.contactkaran.mywordsdictionary.domain.GetWordData
import com.contactkaran.mywordsdictionary.domain.use_case.IsExistWord
import com.contactkaran.mywordsdictionary.domain.use_case.RemoveFromSaved
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordDataViewModel @Inject constructor(
    private val getWordData: GetWordData,
    private val addIntoSaved: AddIntoSaved,
    private val removeFromSaved: RemoveFromSaved,
    private val isExistWord: IsExistWord
    ): ViewModel(){

    private val _wordQuery = mutableStateOf("")
    val wordQuery: State<String> = _wordQuery


    }