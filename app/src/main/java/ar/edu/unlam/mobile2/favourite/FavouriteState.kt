package ar.edu.unlam.mobile2.favourite

import ar.edu.unlam.mobile2.core.domain.model.Movie

data class FavouriteState(
    val movies: List<Movie> = emptyList(),
    var userId: Int = 0
)
