package com.example.desafios

import java.util.*

// Idade em Dias
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    val entrada: Int = scanner.nextInt()
    val horas : Int = entrada.div(3600)
    val minutos : Int = (entrada.rem(3600)).div(60)
    val segundos : Int =  (entrada.rem(3600)).rem(60)
    //complete o código aqui

    println("$horas:$minutos:$segundos")
}