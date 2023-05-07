package ar.edu.unlam.mobile2.navigation

sealed class Destinations(
    val route: String
){
    object MainScreen: Destinations("mainScreen")
    object MovieDetails: Destinations("movieDetails")
    object MovieScreen: Destinations("movieScreen")
}
