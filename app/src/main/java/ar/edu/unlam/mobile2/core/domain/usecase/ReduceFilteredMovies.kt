package ar.edu.unlam.mobile2.core.domain.usecase

import ar.edu.unlam.mobile2.core.domain.model.Movie

class ReduceFilteredMovies {
    operator fun invoke(movies: List<Movie>): List<Movie> {
        val maxFilters = if (movies.size < 6) movies.size else 6
        return movies.subList(0, maxFilters)
    }
}
