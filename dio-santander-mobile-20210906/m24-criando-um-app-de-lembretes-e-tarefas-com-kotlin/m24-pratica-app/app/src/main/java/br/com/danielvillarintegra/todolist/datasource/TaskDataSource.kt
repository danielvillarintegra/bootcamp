package br.com.danielvillarintegra.todolist.datasource

import br.com.danielvillarintegra.todolist.model.Task

object TaskDataSource {
    private val list = arrayListOf<Task>()

    fun getList() = list

    fun insertTask( task: Task) {
        list.add(task.copy(id = list.size + 1))

    }
}