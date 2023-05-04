package ar.edu.unlam.mobile2.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.unlam.mobile2.R



private val message: List<MyMessage> = listOf(
    MyMessage("Nombre pelicula 1", "Descripcion asklajdjdsakjsdksjdjsdlksdjlksadsd"),
    MyMessage(
        "Nombre pelicula 2",
        "Descripcionsdsderrddddfdsdssddssaddslkjsjksdajhsjkdhsjkhsajkhsjkshdjksdhjksdhsadjkhds"
    ),
    MyMessage("Nombre pelicula 3", "Descripcion ssssd4s44sad4ea}s7}s78}sd78sd"),
    MyMessage(
        "Nombre pelicula 4",
        "Descripcion00s00s0.sa.0d00sd0w11wSDdasdsds44555+++++---888555454"
    ),
    MyMessage(
        "Nombre pelicula 5",
        "Descripcionsadsdas5da54sd45sd4545sd45sd45s4soiuoifdyhjadfkbhhjfdgfdasytfd"
    ),
    MyMessage(
        "Nombre pelicula 6",
        "Descripcionldkfdiouefoidhdkjgdjhfdsyrefgsdghrsdtyfytsdrtyrwe67w6e5346634ugjh43hjg3hj34gfgh3f334342"
    ),
    MyMessage(
        "Nombre pelicula 7",
        "DescripcionDescripcionldkfdiouefoidhdkjgdjhfdsyrefgsdghrsdtyfytsdrtyrwe67w6e5346634ugjh43hjg3hj34gfgh3f334342Descripcionldkfdiouefoidhdkjgdjhfdsyrefgsdghrsdtyfytsdrtyrwe67w6e5346634ugjh43hjg3hj34gfgh3f334342Descripcionldkfdiouefoidhdkjgdjhfdsyrefgsdghrsdtyfytsdrtyrwe67w6e5346634ugjh43hjg3hj34gfgh3f334342"
    ),
    MyMessage("Nombre pelicula 8", "Descripcionqwewqwwwwesdssssdsssddss"),
    MyMessage("Nombre pelicula 9", "Descripcion4545456s456a"),
    MyMessage(
        "Nombre pelicula 10",
        "Descripcion escripcion asklajdjdsakjsdksjdjsdlksdjlksadsd escripcion asklajdjdsakjsdksjdjsdlksdjlksadsd escripcion asklajdjdsakjsdksjdjsdlksdjlksadsd"
    ),
    MyMessage(
        "Nombre pelicula 11",
        "Descripcion escripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsd"
    ),
    MyMessage(
        "Nombre pelicula 12",
        "Descescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdripcion"
    ),
    MyMessage(
        "Nombre pelicula 13",
        "Descrescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdipcion"
    ),
    MyMessage(
        "Nombre pelicula 14",
        "Descripcionescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsd"
    ),
    MyMessage(
        "Nombre pelicula 15",
        "escripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdDescripcion"
    ),
    MyMessage(
        "Nombre pelicula 16",
        "escripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdescripcion asklajdjdsakjsdksjdjsdlksdjlksadsdDescripcion"
    ),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesScreen(user: String){
    Scaffold(
        topBar = { TopAppBar(user = user)}
    ){padding ->
        myMessages(padding = padding, messages = message)
    }

}

    @Composable
    fun myMessages(padding: PaddingValues, messages: List<MyMessage>) {
        LazyColumn(contentPadding = padding) {
            items(messages) { messages ->
                MyComponent(messages)
            }
        }
    }

    @Composable
    fun MyComponent(message: MyMessage) {
        Row(modifier = Modifier.padding(8.dp)) {
            MyImage()
            MyTexts(message)
        }
    }

    @Composable
    fun MyImage() {
        Column() {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .size(64.dp)

            )
        }
    }

    @Composable
    fun MyTexts(message: MyMessage) {
        var isexpanded by remember { mutableStateOf(false) }
        Column(
            Modifier
                .padding(8.dp)
                .clickable {
                    isexpanded = !isexpanded
                }
        )
        {
            message.body
            MyText(message.title)
            Spacer(modifier = Modifier.height(16.dp))
            MyText(message.body, if (isexpanded) Int.MAX_VALUE else 1)
        }

    }

    @Composable
    fun MyText(text: String, lines: Int = Int.MAX_VALUE) {
        Text(text, maxLines = lines)
    }

    data class MyMessage(val title: String, val body: String) {}

@Composable
fun TopAppBar(user: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.LightGray),
        verticalAlignment = Alignment.CenterVertically

    ){
        Text(modifier = Modifier.padding(start = 8.dp),
            text = user,
            fontSize = 25.sp
        )
    }
}
