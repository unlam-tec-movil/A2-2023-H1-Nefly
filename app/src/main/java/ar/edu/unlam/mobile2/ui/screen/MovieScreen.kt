package ar.edu.unlam.mobile2.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Movies(){
    Column() {
        Text(  text = "Upcoming Movies",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Black,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(10.dp)
                .width(2000.dp),
            textAlign = TextAlign.Start,
            maxLines = 5,
            lineHeight = 50.sp )
    }







//@Preview(showBackground = true)
//@Composable
//fun Test(){
//    Movies()
}

