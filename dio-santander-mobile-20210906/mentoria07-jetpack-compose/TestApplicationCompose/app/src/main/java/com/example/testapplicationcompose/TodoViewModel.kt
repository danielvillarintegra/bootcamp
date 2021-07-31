package com.example.testapplicationcompose

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {

    val todoItems = mutableStateListOf<TodoItem>()

    val selectedItems = mutableStateListOf<TodoItem>()

    fun addItem(novoItem: TodoItem) {
        todoItems.add(novoItem)
    }

    fun toggleItem(toggledItem: TodoItem) {
        val foundItem = selectedItems.find { it == toggledItem }
        if (foundItem != null) {
            selectedItems.remove(toggledItem)
        } else {
            selectedItems.add(toggledItem)
        }
    }

    fun deletedSelected() {
        todoItems.removeAll(selectedItems)
        selectedItems.clear()
    }

}
