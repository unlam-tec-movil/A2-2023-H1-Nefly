package ar.edu.unlam.mobile2.detail.presentation

import ar.edu.unlam.mobile2.core.domain.model.MovieDetail

data class DetailState(
    val movie: MovieDetail? = null,
    val isLoading: Boolean = false,
    val isFavourite: Boolean = false,
    val userId: Int = 0
)
