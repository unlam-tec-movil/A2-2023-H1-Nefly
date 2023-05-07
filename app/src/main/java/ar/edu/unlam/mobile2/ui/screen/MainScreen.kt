package ar.edu.unlam.mobile2.ui.screen

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.unlam.mobile2.R

@Composable
fun Pantalla1(navegarPantalla2:()-> Unit
) {


    Column {
        val borderWidth = 4.dp
        Image(
            painter = painterResource(id = R.drawable.logomovie),
            contentDescription = stringResource(id = R.string.logo),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )

        Text(
            text = "NEFLY",
            fontSize = 60.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )



        Image(
            painter = painterResource(id = R.drawable.usuario1),
            contentDescription = stringResource(id = R.string.usuario_uno),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .border(
                    BorderStroke(borderWidth, Color.Green),
                    CircleShape
                )

                .padding(borderWidth)
                .clip(CircleShape)
                .clickable {
                    navegarPantalla2()
                }


        )
        Text(
            text = "Usuario1",
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.usuario2),
            contentDescription = stringResource(id = R.string.usuario_dos),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .border(
                    BorderStroke(borderWidth, Color.Yellow),
                    CircleShape
                )

                .padding(borderWidth)
                .clip(CircleShape)
                .clickable {
                    navegarPantalla2()
                }


        )
        Text(
            text = "Usuario2",
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(id = R.drawable.usuario3),
            contentDescription = stringResource(id = R.string.usuario_tres),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .border(
                    BorderStroke(borderWidth, Color.Blue),
                    CircleShape
                )

                .padding(borderWidth)
                .clip(CircleShape)
                .clickable {
                    navegarPantalla2()
                }


        )
        Text(
            text = "Usuario3",
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }

}


//@Preview(showBackground = true)
//@Composable
    //fun Test() {
    //Pantalla1()
//}
