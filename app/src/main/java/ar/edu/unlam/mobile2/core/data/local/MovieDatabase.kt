package ar.edu.unlam.mobile2.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.unlam.mobile2.core.data.local.MovieDao
import ar.edu.unlam.mobile2.core.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract val dao: MovieDao
}
