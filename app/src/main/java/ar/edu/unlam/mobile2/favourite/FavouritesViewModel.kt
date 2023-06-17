package ar.edu.unlam.mobile2.favourite

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.core.domain.model.Movie
import ar.edu.unlam.mobile2.core.domain.repository.FavouritesMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.util.concurrent.Flow
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val repository: FavouritesMovieRepository): ViewModel(){
    private var _uiState by mutableStateOf(FavouriteState())
    val uiState = _uiState


    fun deleteMovie(movie: Movie){
        viewModelScope.launch {
            supervisorScope {
                repository.deleteFavouriteMovie(movieId = movie.id, userId = _uiState.userId)
                updateMovieList()
            }
        }

    }

    private suspend fun updateMovieList(){
        val likedMovies: List<Movie> = repository.getLikedMovies(_uiState.userId)
        _uiState = _uiState.copy(movies = likedMovies)
    }
}