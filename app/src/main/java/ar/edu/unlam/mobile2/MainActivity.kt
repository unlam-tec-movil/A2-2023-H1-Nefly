package ar.edu.unlam.mobile2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ar.edu.unlam.mobile2.ui.MyMoviesApp
import ar.edu.unlam.mobile2.ui.theme.MyMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MyMoviesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MyMoviesApp()

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
                            }
                        )
                        }
                    }

                }
            }
        }
    }
}