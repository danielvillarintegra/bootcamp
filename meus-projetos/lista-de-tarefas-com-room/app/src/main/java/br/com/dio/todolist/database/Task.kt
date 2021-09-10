package br.com.dio.todolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "id") val id: Int,
                @ColumnInfo(name = "title") val title: String,
                @ColumnInfo(name = "hour") val hour: String,
                @ColumnInfo(name = "date") val date: String,
                @ColumnInfo(name = "descritions") val description: String
            )







