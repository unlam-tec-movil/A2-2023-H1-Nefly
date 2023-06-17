package ar.edu.unlam.mobile2.core.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ar.edu.unlam.mobile2.core.data.local.entity.MovieEntity
import ar.edu.unlam.mobile2.core.data.local.entity.MovieFavouriteEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Query(
        """
        SELECT * FROM MovieEntity
        """
    )
    suspend fun getMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavouriteMovie(movie: MovieFavouriteEntity)

    @Query("""
        DELETE FROM MovieFavouriteEntity WHERE idUser = :idUser AND id = :movieId
        """)
    suspend fun deleteFavouriteMovie(movieId: Int, idUser: Int)

    @Query(
        """
        SELECT MOVIE.id, MOVIE.poster, MOVIE.type FROM MovieFavouriteEntity MOVIE_FAVOURITE JOIN MovieEntity MOVIE ON MOVIE_FAVOURITE.id = MOVIE.id WHERE MOVIE_FAVOURITE.idUser = :idUser ORDER BY MOVIE_FAVOURITE.added_date DESC
        """
    )
    suspend fun getLikedMovies(idUser: Int): List<MovieEntity>
}
