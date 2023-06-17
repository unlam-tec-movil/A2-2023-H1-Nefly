package ar.edu.unlam.mobile2.core.data.local

import android.os.Build
import androidx.annotation.RequiresApi
import ar.edu.unlam.mobile2.core.data.local.entity.MovieEntity
import ar.edu.unlam.mobile2.core.data.local.entity.MovieFavouriteEntity
import ar.edu.unlam.mobile2.core.data.local.entity.MovieType
import ar.edu.unlam.mobile2.core.data.mapper.toDomain
import ar.edu.unlam.mobile2.core.domain.model.FilterType
import ar.edu.unlam.mobile2.core.domain.model.Movie
import ar.edu.unlam.mobile2.core.domain.model.MovieDetail
import ar.edu.unlam.mobile2.core.domain.model.MovieList
import ar.edu.unlam.mobile2.core.domain.repository.FavouritesMovieRepository
import ar.edu.unlam.mobile2.core.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime
import javax.inject.Inject

class FavouritesMovieRepositoryImpl (
    private val dao: MovieDao,
): FavouritesMovieRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun addFavouriteMovie(movieId: Int, userId: Int) {
        dao.insertFavouriteMovie(MovieFavouriteEntity(id = movieId, idUser = userId, addedDate = LocalDateTime.now()))
    }

    override suspend fun deleteFavouriteMovie(movieId: Int, userId: Int) {
       dao.deleteFavouriteMovie(movieId,userId)
    }

    override suspend fun getLikedMovies(userId: Int): List<Movie> {
        val likedMovies = dao.getLikedMovies(userId)
        return mapMovies(likedMovies)
    }

    private fun mapMovies(movies: List<MovieEntity>): List<Movie> {
        return movies.map { it.toDomain() }
    }




}
