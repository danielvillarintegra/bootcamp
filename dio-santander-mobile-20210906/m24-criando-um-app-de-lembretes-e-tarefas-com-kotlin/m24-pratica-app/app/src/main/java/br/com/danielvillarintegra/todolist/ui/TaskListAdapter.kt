package br.com.danielvillarintegra.todolist.ui


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.danielvillarintegra.todolist.databinding.ItemTaskBinding
import br.com.danielvillarintegra.todolist.model.Task

class TaskListAdapter : ListAdapter<Task, TaskListAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class TaskViewHolder (
        private val binding: ItemTaskBinding
        ) : RecyclerView.ViewHolder(binding.root) {

    }


}