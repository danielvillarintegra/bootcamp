package br.com.danielvillarintegra.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val nome: String,
    val empresa: String,
    val telefone: String,
    val email: String,
    val fundoPersonalizado: String
)
