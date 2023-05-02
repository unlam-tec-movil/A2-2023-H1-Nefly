package ar.edu.unlam.mobile2.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.ui.AppBarConfiguration
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : /*AppCompatActivity()*/ ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate")

        mainViewModel.kittyUrl.observe(
            this,
            Observer<String> { _ ->
                run {
                    CoroutineScope(Dispatchers.Main).launch {
                        Log.i("MainActivity", "Observer")
                        setContent {
                            val navController = rememberNavController()
                            NavHost(navController = navController, startDestination = "bienvenida"){
                                composable(route = "bienvenida"){
                                    bienvenida(navController)
                                }
                                composable(
                                    route = "movies/{user}",
                                    arguments = listOf(
                                        navArgument("user"){type = NavType.StringType }
                                    )
                                ){
                                    val username = it.arguments?.getString("user")
                                    requireNotNull(username,{"No puede ser nulo porque seleccionar usuario es obligatorio"})
                                    MoviesScreen(username)
                                }
                            }
                        }
                    }
                }
            },
        )
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
    }

    @Composable
    fun bienvenida(navController: NavController) {

        val onClick = {userSelected: String -> navController.navigate(route = "movies/${userSelected}")}


        Column {

            Text(
                text = "Nefly",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Black,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .width(2000.dp),
                textAlign = TextAlign.Center,
                maxLines = 5,
                lineHeight = 50.sp
            )

            Text(
                text = "Seleccione Usuario",
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Thin,
                color = Color.Green,
                fontSize = 40.sp,
                modifier = Modifier
                    .padding(40.dp)
                    .width(2000.dp),
                textAlign = TextAlign.Center,
                maxLines = 5,
                lineHeight = 50.sp
            )

            val borderWidth = 4.dp
            Image(
                painter = painterResource(id = R.drawable.usuario1),
                contentDescription = stringResource(id = R.string.usuario_uno),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .padding(10.dp)
                    .align(alignment = CenterHorizontally)
                    .border(
                        BorderStroke(borderWidth, Color.Yellow),
                        CircleShape
                    )

                    .padding(borderWidth)
                    .clip(CircleShape)
                    .clickable {onClick("Usuario 1")}

            )
            Text(
                text = "Usuario1",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.usuario2),
                contentDescription = stringResource(id = R.string.usuario_dos),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .padding(10.dp)
                    .align(alignment = CenterHorizontally)
                    .border(
                        BorderStroke(borderWidth, Color.Yellow),
                        CircleShape
                    )

                    .padding(borderWidth)
                    .clip(CircleShape)
                    .clickable{onClick("Usuario 2")}


            )
            Text(
                text = "Usuario2",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = R.drawable.usuario3),
                contentDescription = stringResource(id = R.string.usuario_tres),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .padding(10.dp)
                    .align(alignment = CenterHorizontally)
                    .border(
                        BorderStroke(borderWidth, Color.Yellow),
                        CircleShape
                    )

                    .padding(borderWidth)
                    .clip(CircleShape)
                    .clickable{onClick("Usuario 3")}


            )
            Text(
                text = "Usuario3",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

        }


    }

    @Preview(showBackground = true)
    @Composable
    fun vistaPantalla(){
        var navController = rememberNavController()
        bienvenida(navController)
    }


}
