package br.com.danielvillarintegra.todolist.extensions

import java.util.*

private val locale = Locale("pt", "BR")

fun Date.format() : String {
    return java.text.SimpleDateFormat("dd/MM/yyyy", locale).format(this)
}
