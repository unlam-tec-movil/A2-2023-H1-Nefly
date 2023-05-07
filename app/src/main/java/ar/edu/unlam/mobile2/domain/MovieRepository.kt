package ar.edu.unlam.mobile2.domain

import ar.edu.unlam.mobile2.data.model.MovieList

interface MovieRepository {

    suspend fun getUpcomingMovies(): MovieList
    suspend fun getTopRatedMovies(): MovieList
    suspend fun getPopularMovies(): MovieList
    suspend fun getNowPlaying(): MovieList
}