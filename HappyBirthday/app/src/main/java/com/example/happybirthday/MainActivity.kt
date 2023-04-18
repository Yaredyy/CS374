package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme





class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContent {
           HappyBirthdayTheme {
               Surface(color = MaterialTheme.colors.background) {
                   BirthdayGreetingWithImage( stringResource(R.string.happy_birthday_text),
                       stringResource(R.string.signature_text))
               }
           }
       }
   }
}


@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
   Column(
       modifier = modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Top,
       horizontalAlignment = Alignment.CenterHorizontally,
   ) {

       Text(
           text = message,
           fontSize = 36.sp,
           modifier = Modifier
               .padding(top = 16.dp)
       )

       Text(
           text = from,
           fontSize = 24.sp,
           modifier = Modifier
               .padding(top = 16.dp)
       )
   }
}


@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
   val image = painterResource(id = R.drawable.androidparty)
   // Create a box to overlap image and texts
   Box {
       Image(
           painter = image,
           contentDescription = null,
           contentScale = ContentScale.Crop
       )
       BirthdayGreetingWithText(message = message, from = from, modifier = modifier)
   }
}

@Preview(showBackground = false)
@Composable
private fun BirthdayCardPreview() {
   HappyBirthdayTheme {
       BirthdayGreetingWithImage( stringResource(R.string.happy_birthday_text),
           stringResource(R.string.signature_text))
   }


}

