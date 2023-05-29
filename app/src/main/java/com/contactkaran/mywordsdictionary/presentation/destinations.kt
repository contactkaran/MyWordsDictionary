package com.contactkaran.mywordsdictionary.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    //aka SCREEN
    val route: String, val title: String, val icon: ImageVector
){
    object WordDataScreen: Destinations(
        "word_data_screen", "Home", Icons.Rounded.Home
    )

    object FavoriteWordScreen: Destinations(
        //AKA SAVED WORDS SCREEN
        "favorite_words_screen", "Favorited", Icons.Rounded.Bookmark
    )
}