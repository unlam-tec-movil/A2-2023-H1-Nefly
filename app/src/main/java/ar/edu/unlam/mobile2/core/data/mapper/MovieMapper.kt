package ar.edu.unlam.mobile2.core.data.mapper

import ar.edu.unlam.mobile2.core.data.local.entity.MovieEntity
import ar.edu.unlam.mobile2.core.data.local.entity.MovieType
import ar.edu.unlam.mobile2.core.data.remote.MovieApi
import ar.edu.unlam.mobile2.core.data.remote.dto.MovieResult
import ar.edu.unlam.mobile2.core.domain.model.Movie

fun MovieResult.toDomain(): Movie {
    return Movie(
        id = this.id,
        poster = MovieApi.IMAGE_URL + this.posterPath
    )
}

fun Movie.toEntity(type: MovieType): MovieEntity {
    return MovieEntity(
        id = this.id,
        poster = this.poster,
        type = type
    )
}

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = this.id,
        poster = this.poster
    )
}
