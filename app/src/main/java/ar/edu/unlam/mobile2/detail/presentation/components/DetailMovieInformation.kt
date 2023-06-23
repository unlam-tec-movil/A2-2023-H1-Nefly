package ar.edu.unlam.mobile2.detail.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile2.core.domain.model.MovieDetail
import ar.edu.unlam.mobile2.R

@Composable
fun DetailMovieInformation(
    movie: MovieDetail,
    modifier: Modifier = Modifier,
    isFavourite: Boolean = false,
    onFavouriteClick:() -> Unit
) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = movie.name,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            DetailDescriptor(
                text = movie.year.toString(),
                backgroundColor = Color.LightGray
            )
            Spacer(modifier = Modifier.width(8.dp))
            DetailDescriptor(text = movie.language, backgroundColor = Color.LightGray)
            Spacer(modifier = Modifier.width(8.dp))
            DetailDescriptor(
                text = movie.rating.toString(),
                backgroundColor = Color.Yellow,
                image = Icons.Default.Star
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        var formattedGenres = ""
        movie.genres.forEachIndexed { index, genre ->
            formattedGenres += genre
            if (index + 1 < movie.genres.size) {
                formattedGenres += " • "
            }
        }
        Text(text = formattedGenres, color = Color.White)
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(0.4.dp, Color.White, RoundedCornerShape(12.dp))
                .padding(vertical = 16.dp)
                .clickable(onClick = onFavouriteClick),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if(isFavourite) stringResource(id = R.string.unmarkAsFavourite) else stringResource(R.string.markAsFavourite),
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "MOVIE PLOT",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = movie.description,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
