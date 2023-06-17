package ar.edu.unlam.mobile2.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ar.edu.unlam.mobile2.core.data.local.entity.LocalDateTimeConverter
import ar.edu.unlam.mobile2.core.data.local.entity.MovieEntity
import ar.edu.unlam.mobile2.core.data.local.entity.MovieFavouriteEntity

@Database(entities = [MovieEntity::class,MovieFavouriteEntity::class], version = 1, exportSchema = false)
@TypeConverters(LocalDateTimeConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract val dao: MovieDao
}
