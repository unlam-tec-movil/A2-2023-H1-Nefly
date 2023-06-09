package ar.edu.unlam.mobile2.core.data.remote.dto


import com.squareup.moshi.Json

data class BelongsToCollection(
    @field:Json(name = "backdrop_path")
    val backdropPath: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "poster_path")
    val posterPath: String
)