package ar.edu.unlam.mobile2.core.data.mapper

import ar.edu.unlam.mobile2.core.data.remote.MovieApi
import ar.edu.unlam.mobile2.core.data.remote.dto.MovieDetailResponse
import ar.edu.unlam.mobile2.core.domain.model.MovieDetail

fun MovieDetailResponse.toDomain(): MovieDetail {
    return MovieDetail(
        id = this.id,
        image = MovieApi.IMAGE_URL + this.posterPath,
        name = this.originalTitle,
        year = this.releaseDate.substring(0, 4).toInt(),
        language = this.originalLanguage,
        rating = String.format("%.1f", this.voteAverage).toDouble(),
        genres = this.genres.map { it.name },
        description = this.overview
    )
}
