package com.example.desafios

import java.util.*
import kotlin.math.round

fun main() {
    val entrada = Scanner(System.`in`)
    val n1 = entrada.nextFloat()
    val n2 = entrada.nextFloat()
    val n3 = entrada.nextFloat()
    val n4 = entrada.nextFloat()

    var media: Float = ( n1.times(2) + n2.times(3) + n3.times(4) + n4 ).div(10)
    println("Media: ${"%.1f".format(media)}")
    // complete o codigo
    when (media) {
        in 6.90..6.99 ->{ }
        in 7.0..10.0 -> {
            println("Aluno aprovado.")
        }

        in 0.0..4.9 -> {
            println("Aluno reprovado.")
        }

        else -> {
            println("Aluno em exame.")
            val exame = entrada.nextFloat()
            println("Nota do exame: ${"%.1f".format(exame)}")
            media = (media + exame).div(2)
            if (media >= 5.0F) {
                println("Aluno aprovado.")
            } else {
                println("Aluno reprovado")
            }
            if ((media >= 4.950F)&&(media <= 4.990F)) {
                media = round(media).toFloat()
                println("Media final: ${"%.1f".format(media)}")
            } else println("Media final: ${"%.1f".format(media)}")
        }
    }
}