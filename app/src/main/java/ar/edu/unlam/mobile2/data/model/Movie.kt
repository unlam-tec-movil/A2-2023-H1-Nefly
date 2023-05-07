package ar.edu.unlam.mobile2.data.model

data class Movie
    (
    val adult: Boolean = false,
    val backdrop_path: String = "",
    val id: Int = -1,
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1,
    var movie_type: String = ""
)

data class MovieList(val results: List<Movie> = listOf())

