package com.example.yaredsbusinesscard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.yaredsbusinesscard.ui.theme.YaredsBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Starter()
        }
    }
}




@Composable
fun Starter() {
    YaredsBusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Cyan
        ) {
            Screen()
        }
    }
}


@Composable
fun Screen(){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        PandN(image = R.drawable.yared, "Yared Yohannes", "Android Software Engineer")
        Spacer(modifier = Modifier.height(75.dp))
        Contact("yaredyyehualashet@gmail.com","+1(347)935-2598","https://github.com/Yaredyy")
    }
}


@Composable
fun PandN(image: Int, name: String, title: String) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = image), contentDescription = null, modifier = Modifier.heightIn(max=250.dp))
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = name, fontSize = 40.sp)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = title, fontSize = 30.sp)
    }
}


@Composable
fun Contact(email: String, pnum: String, link: String){
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        mail(id=R.drawable.mail,text=email)
        Spacer(modifier = Modifier.height(15.dp))
        phone(id=R.drawable.phone,text=pnum)
        Spacer(modifier = Modifier.height(15.dp))
        git(id=R.drawable.git,text=link)
    }
}


@Composable
fun mail(id :Int ,text:String){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = id), contentDescription = null, modifier = Modifier.height(50.dp))
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text, fontSize = 20.sp)
    }
}


@Composable
fun phone(id :Int ,text:String){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = id), contentDescription = null, modifier = Modifier.height(50.dp))
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text, fontSize = 20.sp)
    }
}



@Composable
fun git(id :Int ,text:String){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = id), contentDescription = null, modifier = Modifier.height(50.dp))
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text, fontSize = 20.sp)
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Starter()
}

