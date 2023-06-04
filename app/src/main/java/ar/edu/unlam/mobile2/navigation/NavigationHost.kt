package ar.edu.unlam.mobile2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.navigation.Destinations.*
import ar.edu.unlam.mobile2.ui.screen.Home
import ar.edu.unlam.mobile2.ui.screen.Movies
import ar.edu.unlam.mobile2.ui.screen.SplashScreen

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SplashScreen.route){
        composable(SplashScreen.route){
           SplashScreen(navController)
        }
        composable(MainScreen.route){
           Home(
               navegarPantalla2 = {
                   navController.navigate(MovieScreen.route)
               }
           )
        }
        composable(MovieScreen.route){
            Movies()
        }
        composable(MovieDetails.route){

        }
    }
}
