package ar.edu.unlam.mobile2.home.presentation

import ar.edu.unlam.mobile2.core.domain.model.FilterType
import ar.edu.unlam.mobile2.core.domain.model.Movie

data class HomeState(
    val upcomingMovies: List<Movie> = emptyList(),
    val popularMovies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val selectedFilter: FilterType = FilterType.SPANISH,
    val filteredMovies: List<Movie> = emptyList()
)
