package com.contactkaran.mywordsdictionary.core


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.contactkaran.mywordsdictionary.ui.theme.MyWordsDictionaryTheme
import com.contactkaran.mywordsdictionary.utils.BottomBar
import com.contactkaran.mywordsdictionary.utils.BottomNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWordsDictionaryTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(scaffoldState = scaffoldState,
                    bottomBar = { BottomBar(navController = navController) },
                    content = { paddingValues ->
                        BottomNavGraph(
                            modifier = Modifier.padding(paddingValues),
                            navController = navController
                        )
                    })
            }
        }
    }
}