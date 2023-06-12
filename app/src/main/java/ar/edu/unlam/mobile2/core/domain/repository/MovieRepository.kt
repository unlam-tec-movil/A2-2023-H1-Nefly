package ar.edu.unlam.mobile2.core.domain.repository

import ar.edu.unlam.mobile2.core.domain.model.FilterType
import ar.edu.unlam.mobile2.core.domain.model.MovieDetail
import ar.edu.unlam.mobile2.core.domain.model.MovieList
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getAllMovies(filterType: FilterType, isFilteredOnly: Boolean): Flow<MovieList>
    suspend fun getMovieById(id: Int): Result<MovieDetail>
}
