package com.example.desafios

import java.util.*

// Idade em Dias
fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    val entrada: Int = scanner.nextInt()
    val anos : Int = entrada.div(365)
    val meses : Int = (entrada.rem(365)).div(30)
    val dias : Int =  (entrada.rem(365)).rem(30)
    //complete o código aqui

    println("${anos} ano(s)")
    println("${meses} mes(es)")
    println("${dias} dia(s)")
}