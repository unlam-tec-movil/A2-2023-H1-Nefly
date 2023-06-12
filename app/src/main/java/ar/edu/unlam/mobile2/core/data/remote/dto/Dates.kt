package ar.edu.unlam.mobile2.core.data.remote.dto


import com.squareup.moshi.Json

data class Dates(
    @field:Json(name = "maximum")
    val maximum: String,
    @field:Json(name = "minimum")
    val minimum: String
)