package br.com.danielvillarintegra.todolist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.danielvillarintegra.todolist.databinding.ActivityAddTaskBinding
import br.com.danielvillarintegra.todolist.extensions.format
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.tilDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                Date(it).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")

        }

    }
}