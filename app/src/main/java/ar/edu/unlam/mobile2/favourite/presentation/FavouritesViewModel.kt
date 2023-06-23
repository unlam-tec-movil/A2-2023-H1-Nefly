package ar.edu.unlam.mobile2.favourite.presentation

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile2.core.domain.model.Movie
import ar.edu.unlam.mobile2.core.domain.repository.FavouritesMovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val repository: FavouritesMovieRepository,
    savedStateHandle: SavedStateHandle
    ): ViewModel(){
    private val _uiState = MutableStateFlow(FavouriteState())
    val uiState = _uiState.asStateFlow()

    init{
        viewModelScope.launch{
            var userId = savedStateHandle.get<Int>("user_id")
            _uiState.update {_uiState.value.copy(userId = userId) }
            updateMovieList()
        }

    }


    /*fun deleteMovie(movie: Movie){
        viewModelScope.launch {
            supervisorScope {
                repository.deleteFavouriteMovie(movieId = movie.id, userId = _uiState.value.userId!!)
                updateMovieList()
            }
        }

    }
*/
    private suspend fun updateMovieList(){
        val likedMovies: List<Movie> = repository.getLikedMovies(uiState.value.userId?:0)
        _uiState.update { _uiState.value.copy(movies = likedMovies) }
    }
}