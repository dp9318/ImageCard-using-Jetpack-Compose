package com.dp.imagecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id= R.drawable.cat_new_res)
            val painter2 = painterResource(id= R.drawable.cat)
            val description = "Cat on the grass!"
            val title = "Cat is sitting on the grass"
            val title2 = "Cat is standing on sofa"
            Column (modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(5.dp) ){
                Box{
                    ImageCard(painter = painter, contentDescription = description, title = title)

                }
                Box {
                    ImageCard(painter = painter2, contentDescription = description, title = title2)

                }
            }



        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String
){
    Card (
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box (modifier = Modifier.height(200.dp)) {
            Image(painter = painter ,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

