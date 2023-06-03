package ar.edu.unlam.mobile2.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.unlam.mobile2.R
import ar.edu.unlam.mobile2.navigation.Destinations
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){
    LaunchedEffect(key1 = true){
        delay(1000 )
        navController.popBackStack()
        navController.navigate(Destinations.MainScreen.route)
    }
    Splash()
}
@Composable
fun Splash(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center) {
        Image(painterResource(id = R.drawable.logomovie) ,
            contentDescription = "NEFLY")

        Text(text = "NEFLY",
        fontSize = 60.sp,
        fontWeight = FontWeight.Black)
    }
}
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(){
    Splash()
}