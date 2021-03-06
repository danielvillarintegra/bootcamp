/*
import kotlin.math.sqrt



fun main()

{

    val n = readLine()!!.toInt()



    for (i in 0 until n) {

        var x = readLine()!!.toDouble()

        val prime = isPrime(x)



        print(prime)

    }

}



fun print(prime: Boolean)

{

    if (prime) {

        print("Prime\n")

    } else print("Not Prime\n")

}



fun isPrime(num: Double): Boolean

{

    if (num < 2) return false

    if (num % 2 == 0.0) return num == 2.0



    val root = sqrt(num).toInt()

    var i = 3



    while (i <= root) {

        if (num % i == 0.0) return false

        i += 2

    }
   return true
}
*/
/*import java.util.*
import kotlin.math.round

fun main() {
    val
    //val listaDePrimos = arrayOf(0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0)
    val listaDePrimos = arrayOf(0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1)
    for (j in 0 .. 230) print(" ${listaDePrimos[j]},")
    println()

    val n = readLine()!!.toInt()

    for (i in 0..n-1) {

        var entrada = readLine()!!.toInt()

        println(listaDePrimos[entrada])

        if (listaDePrimos[entrada] == 0) println("Not Prime")
        else println("Prime")
    }
}
*/
/*
import java.util.*
import kotlin.math.round

fun main() {
    val listaPrimosPosicional = mutableListOf<Int>()
    for (i in 0..233) {
        if (primo(i)) listaPrimosPosicional.add(1)
        else listaPrimosPosicional.add(0)
    }
    println(listaPrimosPosicional)

    val n = readLine()!!.toInt()

    for (i in 1..n) {
        var entrada = readLine()!!.toInt()
        if (listaPrimosPosicional[entrada].equals(1)) println("Prime")
        else println("Not Prime")
    }
    println("$listaPrimosPosicional.position[entrada]")
}

private fun primo(n : Int) : Boolean {
    var d : Int = 2
    if (n <= 1) return false
    while (d*d <= n ) {
        if (n.rem(d) == 0 ) // d divide n
            return false
        d++
    }
    return true
}
*/
/*
import java.util.*
import kotlin.math.round

fun main() {
    val listaDePrimos = intArrayOf(0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0)

    val n = readLine()!!.toInt()

    for (i in 1..n) {
        var entrada = readLine()!!.toInt()
        if (entrada !in listaDePrimos) println("Not Prime")
        else println("Prime")
    }
}
*/
/*
import java.util.*
import kotlin.math.round

fun main() {
    val listaDePrimos = mutableListOf<Int>()
    for (i in 1..231) {
        if (primo(i)) listaDePrimos.add(i)
    }
    println(listaDePrimos)

    val n = readLine()!!.toInt()

    for (i in 1..n) {
        var entrada = readLine()!!.toInt()
        if (entrada in listaDePrimos) println("Prime")
        else println("Not Prime")
    }

}

private fun primo(n : Int) : Boolean {
    var d : Int = 2
    if (n <= 1) return false
    while (d*d <= n ) {
        if (n.rem(d) == 0 ) // d divide n
            return false
        d++
    }
    return true
}
*/


import java.util.*
import kotlin.math.round

fun main() {
    val n = readLine()!!.toInt()

    for (i in 1..n) {
        var entrada = readLine()!!.toLong()
        if (primo(entrada)) println("Prime")
        else println("Not Prime")
    }

}

private fun primo(n : Long) : Boolean {
    var d : Long = 2
    if (n <= 1) return false
    while (d*d <= n ) {
        if (n.rem(d) == 0L ) // d divide n
            return false
        d++
    }
    return true
}

