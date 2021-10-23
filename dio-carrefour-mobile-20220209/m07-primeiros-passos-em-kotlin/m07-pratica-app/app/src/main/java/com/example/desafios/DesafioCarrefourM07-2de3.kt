package com.example.desafios

fun main() {
    println("Hello Word")
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val prod = a.times(b)
    println("PROD = $prod")   //insira as variaveis corretamente
    for (i in 2..a step 1)
        println("Primo $i = ${numeroPrimo(i)}")

}

fun numeroPrimo(n : Int) : Boolean {
    var isPrimo : Boolean = false
    if (n <= 1) {
        isPrimo = false
    }
    for (i in 2 .. n step 1)
        if (n.mod(2) == 0) {
            isPrimo = false
        } else isPrimo = true
    return isPrimo
}
