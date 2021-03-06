package com.example.desafios

import java.util.*
import kotlin.math.round

fun main() {

    val entrada = Scanner(System.`in`)

    val n1 = entrada.nextFloat().toFloat()

    val n2 = entrada.nextFloat().toFloat()

    val n3 = entrada.nextFloat().toFloat()

    val n4 = entrada.nextFloat().toFloat()

    var media: Float = ( n1.times(2) + n2.times(3) + n3.times(4) + n4 ).div(10)

    println("Media: ${media.round(1)}")
    // complete o codigo

    if (media >= 7) {

        println("Aluno aprovado.")

    } else {

        if (media < 5) {

            println("Aluno reprovado.")

        }

        if (media >= 5.0 && media <= 6.9) {

            println("Aluno em exame.")

            val exame : Float = entrada.nextFloat()

            println("Nota do exame: ${exame.round(1)}")

            media = ((media.plus(exame)).div(2))

            if (media >= 5) {

                println("Aluno aprovado.")

            } else {

                println("Aluno reprovado")

            }

            println("Media final: ${media.round(1)}")

        }

    }

}

private fun Float.round(decimals: Int): Float {

    var multiplier = 1.0F

    repeat(decimals) { multiplier *= 10 }

    return round(this * multiplier) / multiplier

}