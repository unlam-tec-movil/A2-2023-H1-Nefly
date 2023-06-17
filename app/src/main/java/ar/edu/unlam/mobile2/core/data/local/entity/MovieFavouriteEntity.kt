package ar.edu.unlam.mobile2.core.data.local.entity

import android.os.Build
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

@Entity(primaryKeys = ["id","idUser"])
data class MovieFavouriteEntity(
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "idUser")
    val idUser: Int,
    @ColumnInfo(name = "added_date")
    val addedDate: LocalDateTime
)

class LocalDateTimeConverter{

    @TypeConverter
    fun timeToString(time: LocalDateTime): String{
        return time.toString()
    }

    @TypeConverter
    fun stringToTime(string: String): LocalDateTime{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.parse(string)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
    }
}



