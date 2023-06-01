package com.contactkaran.mywordsdictionary.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.contactkaran.mywordsdictionary.presentation.saved_words.SavedWordsScreen
import com.contactkaran.mywordsdictionary.presentation.word_data.WordDataScreen

@Composable
fun AppBottomNavGraph(navController: NavHostController, modifier: Modifier){
    NavHost(modifier = Modifier,
        navController = navController,
        startDestination = Destinations.WordDataScreen.route){
        composable(route = Destinations.WordDataScreen.route){
            WordDataScreen()
        }
        composable(route = Destinations.FavoriteWordScreen.route){
            SavedWordsScreen()
        }
    }
}

