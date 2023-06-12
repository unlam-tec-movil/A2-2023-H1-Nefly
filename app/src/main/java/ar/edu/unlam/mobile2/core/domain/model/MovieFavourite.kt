package ar.edu.unlam.mobile2.core.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class MovieFavourite(
    val id: Int,
    val idUser: Int,
    val addedDate: Date
)
