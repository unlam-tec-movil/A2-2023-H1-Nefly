package ar.edu.unlam.mobile2.favourite.presentation
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.core.domain.model.Movie
import ar.edu.unlam.mobile2.favourite.components.FavouriteMoviePoster
import ar.edu.unlam.mobile2.home.presentation.components.MoviePosterSize

@Composable
fun FavoritesScreen(
    onBack: () -> Unit,
    onMovieClick: (Movie) -> Unit,
    viewModel: FavouritesViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.favoritos)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (isSystemInDarkTheme()) Color.Black else Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
               if(state.movies.isNotEmpty()){
                    Text(text = stringResource(R.string.favourite_content))
                   LazyVerticalGrid(
                       horizontalArrangement = Arrangement.spacedBy(5.dp),
                       contentPadding = PaddingValues(horizontal = 5.dp),
                       columns = GridCells.Fixed(3)
                   ) {
                       items(state.movies) { movie ->
                           FavouriteMoviePoster(imageUrl = movie.poster, posterSize = MoviePosterSize.SMALL){
                               onMovieClick(movie)
                           }
                       }
                   }

                }else{
                    Text(text = stringResource(R.string.favorite_empty),modifier = Modifier.padding(top = 12.dp), color = if(isSystemInDarkTheme())Color.White else Color.Black, fontSize = 22.sp)
                }


            }
        }
    )
}

@Preview
@Composable
fun PreviewFavoritesScreen() {
    FavoritesScreen(onMovieClick = {}, onBack = {})
}