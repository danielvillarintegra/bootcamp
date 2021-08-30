package br.com.danielvillarintegra.todolist.model

data class Task(
    val title: String,
    val hour: String,
    val date: String,
    val id: Int = 0
)
