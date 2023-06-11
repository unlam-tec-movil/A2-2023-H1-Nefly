package ar.edu.unlam.mobile2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ar.edu.unlam.mobile2.detail.presentation.DetailScreen
import ar.edu.unlam.mobile2.home.presentation.HomeScreen
import ar.edu.unlam.mobile2.home.presentation.components.AppBar
import ar.edu.unlam.mobile2.ui.theme.MovieDbTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MovieDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "HOME") {
                        composable("HOME") {
                            HomeScreen(onMovieClick = {
                                navController.navigate("DETAIL/${it.id}")
                            })
                        }
                        composable(
                            "DETAIL/{movie_id}",
                            arguments = listOf(
                                navArgument("movie_id") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            DetailScreen(onBack = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }
}
