package com.example.testapplicationcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.testapplicationcompose.ui.theme.TestApplicationComposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    private val todoViewModel by viewModels<TodoViewModel> ()

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainsScreen(todoViewModel)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun MainsScreen(todoViewModel:TodoViewModel) {
    TodoListScreen(
        todoViewModel.todoItems,
        todoViewModel.selectedItems,
        todoViewModel::addItem,
        todoViewModel::toggleItem,
        todoViewModel::deletedSelected
    )}



