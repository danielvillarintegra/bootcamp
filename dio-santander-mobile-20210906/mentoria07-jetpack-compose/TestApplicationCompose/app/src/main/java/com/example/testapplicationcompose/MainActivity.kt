package com.example.testapplicationcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapplicationcompose.ui.theme.TestApplicationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainsScreen("Daniel")
                }
            }
        }
    }
}

@Composable
fun MainsScreen(name: String) {
    Column {
        Text(text = "Olá $name!")
        Text(
            text = "Texto embaixo!",
            Modifier
                .padding(8.dp)
                .background(color = Cyan)
                .padding(12.dp)

        )
        Button(onClick = { }) {
            Text(text = "Texto do botão")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestApplicationComposeTheme {
        MainsScreen("Android")
    }
}
