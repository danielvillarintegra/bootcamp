package com.example.testapplicationcompose

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {

    val todoItems = mutableStateListOf<TodoItem>()

    val selectedItems = mutableStateListOf<TodoItem>()

    fun addItem(novoItem: TodoItem) {
        todoItems.add(novoItem)
    }

    fun toggleItem(togledItem: TodoItem) {
        val foundItem = selectedItems.find { it == toggleItem }
        if (foundItem != null) {
            selectedItems.remove(toggleItem())
        } else {
            selectedItems.add(toggleItem())
        }
    }

    fun deletedSelected() {
        todoItems.removeAll(selectedItems)
        selectedItems.clear()
    }

}
