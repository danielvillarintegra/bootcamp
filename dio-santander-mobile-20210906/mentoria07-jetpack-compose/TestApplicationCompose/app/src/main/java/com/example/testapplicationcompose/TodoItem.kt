package com.example.testapplicationcompose

import java.util.*

data class TodoItem(val text: String, val id: String = UUID.randomUUID().toString())
{
}