package ar.edu.unlam.mobile2.favourite.presentation

import ar.edu.unlam.mobile2.core.domain.model.Movie

data class FavouriteState(
    var movies: List<Movie> = emptyList(),
    var userId: Int? = 0
) {
}
