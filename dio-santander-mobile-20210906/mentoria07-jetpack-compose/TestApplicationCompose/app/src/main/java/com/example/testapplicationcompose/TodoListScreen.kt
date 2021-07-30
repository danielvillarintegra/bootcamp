package com.example.testapplicationcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TodoRow(
    todoItem : TodoItem = TodoItem("Item de todo"),
    selected: Boolean = false
) {
    Row() {
        Text(text = "Item de todo")
        Checkbox(checked = true, onCheckedChange = {})

    }
}