package com.example.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.example.ui.theme.ExampleTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleTheme {
                SayHelloScreen()
            }
        }
    }
}

@Composable
fun SayHelloScreen(){
    var userName by remember { mutableStateOf("CI/CD") }
    var isDisplayText by remember { mutableStateOf(false) }

    Column {

        TextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = userName, onValueChange = { userName = it },
            label = {
                Text(text = stringResource(id = R.string.write_your_name))
            }
        )


        Button(
            onClick ={
                     isDisplayText = true
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "Say Hello", style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White
                )
            )

        }

     //   if (isDisplayText){
            Greeting(name = userName)
       // }


    }
}


@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.fillMaxSize().padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExampleTheme {
        SayHelloScreen()
    }
}
