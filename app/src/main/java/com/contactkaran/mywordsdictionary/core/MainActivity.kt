package com.contactkaran.mywordsdictionary.core


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.contactkaran.mywordsdictionary.presentation.AppBottomNavGraph
import com.contactkaran.mywordsdictionary.presentation.Destinations
import com.contactkaran.mywordsdictionary.ui.theme.MyWordsDictionaryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//TODO - inserting Splash
        installSplashScreen()





        setContent {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()

            MyWordsDictionaryTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = { DictionaryTopAppBar() },
                    bottomBar = { DictionaryBottomAppBar() },
                    content = { paddingValues ->
                        MainContent(paddingValues)
                        AppBottomNavGraph(
                            modifier = Modifier.padding(paddingValues),
                            navController = navController
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun MainContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Text(text = "What word do you want to search today?")


        }
    }
}


@Composable
fun DictionaryBottomAppBar() {
    BottomAppBar {
        BottomNavigation {
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search") },
                label = { Text(text = "Search") },
                selected = false,
                onClick = {
                    Destinations.WordDataScreen
                }
            )
            BottomNavigationItem(
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home") },
                label = { Text(text = "Home") },
                selected = true,
                onClick = {
                    Destinations.WordDataScreen
                }
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorites"
                    )
                },
                label = { Text(text = "Favorites") },
                selected = false,
                onClick = {
                Destinations.FavoriteWordScreen
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryTopAppBar() {
    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "My Words Dictionary",
                    modifier = Modifier,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }, navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {/* Handle day/night mode toggle click */ }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Day/Night Mode Toggle"
                )
                //TODO - click button to go to favorites                
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview(){
    MainContent(paddingValues = PaddingValues())
}