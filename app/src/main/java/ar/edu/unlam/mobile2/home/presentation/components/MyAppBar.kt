package ar.edu.unlam.mobile2.home.presentation.components


import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AppBar(){
        TopAppBar(
            title = { Text(text = "Nefly")}, backgroundColor = Color.Black, contentColor = Color.White,
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite" )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Exit" )
                }
            }
        )
            

    }


@Preview(showBackground = true)
@Composable
fun PruebaAppBar(){
    AppBar()
}
