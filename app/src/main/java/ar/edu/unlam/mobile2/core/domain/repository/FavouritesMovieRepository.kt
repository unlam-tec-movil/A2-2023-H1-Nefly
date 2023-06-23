package ar.edu.unlam.mobile2.core.domain.repository

import ar.edu.unlam.mobile2.core.domain.model.Movie
import ar.edu.unlam.mobile2.core.domain.model.MovieDetail
import java.util.concurrent.Flow

interface FavouritesMovieRepository {

    suspend fun addFavouriteMovie(movieId: Int?, userId: Int)

    suspend fun deleteFavouriteMovie(movieId: Int, userId: Int)

    suspend fun getLikedMovies(userId:Int): List<Movie>


}