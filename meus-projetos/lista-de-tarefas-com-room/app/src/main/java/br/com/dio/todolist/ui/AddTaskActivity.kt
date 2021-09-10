package br.com.dio.todolist.ui

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.todolist.R
import br.com.dio.todolist.TasksApplication
import br.com.dio.todolist.databinding.ActivityAddTaskBinding
import br.com.dio.todolist.util.format
import br.com.dio.todolist.database.Task
import br.com.dio.todolist.util.text
import br.com.dio.todolist.model.TaskViewModel
import br.com.dio.todolist.model.TaskViewModelFactory
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddTaskBinding.inflate(layoutInflater) }

    private val taskViewModel: TaskViewModel by viewModels {
        TaskViewModelFactory((application as TasksApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        insertListeners()

      }

    private fun insertListeners() {
        binding.tilDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()

            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                binding.tilDate.text = Date(it + offset).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        binding.tilHour.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            timePicker.addOnPositiveButtonClickListener {
                val minute = if (timePicker.minute in 0..9) "0${timePicker.minute}" else timePicker.minute
                val hour = if (timePicker.hour in 0..9) "0${timePicker.hour}" else timePicker.hour

                binding.tilHour.text = "$hour:$minute"
            }

            timePicker.show(supportFragmentManager, null)
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }

        binding.btnNewTask.setOnClickListener {
            val task = Task(
                title = binding.tilTitle.text,
                date = binding.tilDate.text,
                hour = binding.tilHour.text,
                description = binding.tilDescription.text,
                id = intent.getIntExtra(TASK_ID, 0)

            )
            taskViewModel.insertTask(task)
            Toast.makeText(this, R.string.label_show_success,Toast.LENGTH_SHORT).show()
            // TaskDataSource.insertTask(task)
            setResult(Activity.RESULT_OK)
            finish()
        }
    }


    companion object {
        const val TASK_ID = "task_id"
    }

}