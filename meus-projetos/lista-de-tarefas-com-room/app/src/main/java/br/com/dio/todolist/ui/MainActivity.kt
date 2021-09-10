package br.com.dio.todolist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import br.com.dio.todolist.TasksApplication
import br.com.dio.todolist.database.TaskDao
import br.com.dio.todolist.database.TaskRepository
import br.com.dio.todolist.databinding.ActivityMainBinding
import br.com.dio.todolist.model.TaskViewModel
import br.com.dio.todolist.model.TaskViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val taskViewModel: TaskViewModel by viewModels {
        TaskViewModelFactory((application as TasksApplication).repository)
    }
    private val adapter by lazy { TaskListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.rvTasks.adapter = adapter //rvTask = activity_main.xml
        updateList()

        insertListeners()
        //ENVIAR EVENTO PARA AGENDA
        //DATA STORE
        //ROOM
    }

    private fun insertListeners() {
        binding.fab.setOnClickListener {
            // startActivityForResult(Intent(this, AddTaskActivity::class.java), CREATE_NEW_TASK)
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        adapter.listenerEdit = {
            updateList()
        }

        adapter.listenerDelete = {

            updateList()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CREATE_NEW_TASK && resultCode == Activity.RESULT_OK) updateList()

    }

    private fun updateList() {
        taskViewModel.getAll().observe(this, {task -> adapter.submitList(task)})

        /*
        val list = TaskRepository.getList()
        binding.includeEmpty.emptyState.visibility =
            if (list.isEmpty()) View.VISIBLE
            else View.GONE

        adapter.submitList(list) */

    }

    companion object {
        private const val CREATE_NEW_TASK = 1000
    }

}