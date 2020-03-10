package com.example.jetpacklearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun NewsStory() {
    val image = +imageResource(R.drawable.header)

    Column(
        modifier = Spacing(16.dp)
    ) {
        DrawImage(image)
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}


@Composable
fun MyApp(){
    MaterialTheme {
        FlexColumn{
            inflexible {
                MyAppBar(appBarTitle = "Jetpack Compose")
            }
            expanded(flex = 1f){
                VerticalScroller {
                    Column {
                        for (i in 1..5){
                            MyBody()
                        }
                    }
                }

            }
        }
    }
}


@Composable
fun MyAppBar(appBarTitle: String){
    TopAppBar(title = {
        Text(text = appBarTitle,style = TextStyle(color = Color.White))
    },color = Color.Magenta)
}

@Composable
fun MyBody(){
    Padding(padding = 16.dp) {
        Card(shape = RoundedCornerShape(size = 10.dp)) {
            val image = +imageResource(R.drawable.header)
            Column(modifier = Spacing(16.dp)) {
                Container(expanded = true,height = 200.dp) {
                    Clip(shape = RoundedCornerShape(size = 10.dp)) {
                            DrawImage(image = image)
                        }
                    }
                    HeightSpacer(height = 10.dp)

                    Text(text = "Welcome to JetPack compose")
                    Text(text = "Android Studio Canary")
                    Text(text = "Canary 4.1")
                }
            }
        }

    }
}