package ar.edu.unlam.mobile2.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    val idUser: Int
)
