package ar.edu.unlam.mobile2.core.domain.model


data class MovieList(
    val upcoming: List<Movie>,
    val trending: List<Movie>,
    val filtered: List<Movie>
)
