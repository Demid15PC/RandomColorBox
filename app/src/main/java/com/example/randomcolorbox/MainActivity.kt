package com.example.randomcolorbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorBox()
        }
    }
}

@Composable
fun ColorBox() {
    val color = remember {
        mutableStateOf(Color.White)
    }
    var textus = "Click me"


    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.img),
        contentDescription = "background",
        contentScale = ContentScale.FillBounds
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(0.2f),
            elevation = 10.dp,
            shape = RoundedCornerShape(15.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color.value)
                    .clickable {
                        color.value = Color(
                            Random.nextFloat(),
                            Random.nextFloat(),
                            Random.nextFloat(),
                            1f
                        )
                        textus = ""
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = textus,
                    color = Color.Black,
                    fontSize = 20.sp
                )   
            }
        }
    }
}