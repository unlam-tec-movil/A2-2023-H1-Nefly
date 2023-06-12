package ar.edu.unlam.mobile2.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class MovieFavouriteEntity(
    @PrimaryKey
    val id: Int,
    @PrimaryKey
    val idUser: Int,
    @ColumnInfo(name = "added_date")
    val addedDate: Date
)
