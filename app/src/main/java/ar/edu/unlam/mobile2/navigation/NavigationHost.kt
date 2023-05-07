package ar.edu.unlam.mobile2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ar.edu.unlam.mobile2.navigation.Destinations.*
import ar.edu.unlam.mobile2.ui.screen.Pantalla1
import ar.edu.unlam.mobile2.ui.screen.Pantalla2

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainScreen.route){
        composable(MainScreen.route){
           Pantalla1(
               navegarPantalla2 = {
                   navController.navigate(MovieScreen.route)
               }
           )
        }
        composable(MovieScreen.route){
            Pantalla2()
        }
        composable(MovieDetails.route){

        }
    }
}
