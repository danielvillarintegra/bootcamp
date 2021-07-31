package com.example.testapplicationcompose

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.ExperimentalComposeUiApi as ExperimentalComposeUiApi


@ExperimentalComposeUiApi
@Composable
fun TodoListScreen(
    items : List<TodoItem> ,
    selectedItem: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onToggleItem: (TodoItem) -> Unit,
    onDeletedItems: () -> Unit,

) {
    Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = "Applicativo compose ToDo")} ,
                actions = {
                    IconButton(
                        onClick = { onDeletedItems },
                        Modifier.padding(horizontal = 8.dp)
                    ) {
                        Icon(
                            Icons.Rounded.Delete,
                            contentDescription = "Remover ítem")
                    }
                })
            }) {
        Column(Modifier.fillMaxSize()) {
            LazyColumn(Modifier
                .fillMaxWidth()
                .weight(1.0f)) {

            }
        TodoFieldAndButton("Texto fixo", {} , {})
        }


            }

}


@Composable
fun TodoRow(
    todoItem: TodoItem,
    selected: Boolean,
    doToggle: (TodoItem) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {


        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1.0f),
                text = todoItem.text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = if (selected) {
                    MaterialTheme.typography.h6
                        .copy(textDecoration = TextDecoration.LineThrough)
                } else {
                    MaterialTheme.typography.h6

                })

            Checkbox(
                modifier = Modifier.padding(horizontal = 8.dp),
                checked = selected,
                onCheckedChange = { doToggle(todoItem) }
            )
        }
        Divider()
    }

}


@ExperimentalComposeUiApi
@Composable
fun TodoFieldAndButton(
    text: String,
    onTextChange: (String) -> Unit,
    onAddItem: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Divider(Modifier.fillMaxWidth())
    Row(Modifier.fillMaxWidth()) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            singleLine = true,
            maxLines = 1,
            textStyle = MaterialTheme.typography.h6,
            
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                onAddItem()
                keyboardController?.hide()
        }),
        modifier = Modifier.weight(1.0f))

        IconButton(
            onClick = onAddItem,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterVertically)
        ){
        Icon(Icons.Rounded.Send, contentDescription = "Adicionar item")
        }
            
    }
}


@Preview (showBackground = true)
@Composable
fun PreviewTodoRow() {
    TodoRow(TodoItem("Preview of Todo Item"), true, {})
}

@kotlin.OptIn(ExperimentalComposeUiApi::class)
@Preview (showBackground = true)
@Composable
fun PreviewTodoFieldAndButton() {
    TodoFieldAndButton("Editando o texto", {}, {})

}

@ExperimentalComposeUiApi
@Preview
@Composable
fun PreviewTodoListScreen() {
    TodoListScreen(listOf(), listOf(), {}, {}, {})
}
