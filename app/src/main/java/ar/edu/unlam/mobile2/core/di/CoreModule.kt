package ar.edu.unlam.mobile2.core.di

import android.app.Application
import androidx.room.Room
import ar.edu.unlam.mobile2.core.data.MovieRepositoryImpl
import ar.edu.unlam.mobile2.core.data.local.MovieDao
import ar.edu.unlam.mobile2.core.data.local.MovieDatabase
import ar.edu.unlam.mobile2.core.data.remote.MovieApi
import com.mk.moviedb.core.data.remote.interceptor.ApiKeyInterceptor
import ar.edu.unlam.mobile2.core.domain.repository.MovieRepository
import ar.edu.unlam.mobile2.core.domain.usecase.ReduceFilteredMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoreModule {
    @Provides
    @Singleton
    fun provideApi(): MovieApi {
        val client = OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor())
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()
        return Retrofit.Builder().baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).client(client).build().create()
    }

    @Singleton
    @Provides
    fun provideDatabase(application: Application): MovieDatabase {
        return Room.databaseBuilder(application, MovieDatabase::class.java, "movies_db").build()
    }

    @Singleton
    @Provides
    fun provideDatabaseDao(database: MovieDatabase): MovieDao {
        return database.dao
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: MovieApi,
        dao: MovieDao
    ): MovieRepository {
        return MovieRepositoryImpl(api, dao, ReduceFilteredMovies())
    }
}
