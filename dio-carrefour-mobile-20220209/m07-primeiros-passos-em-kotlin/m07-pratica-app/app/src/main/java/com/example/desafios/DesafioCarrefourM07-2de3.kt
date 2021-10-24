package com.example.desafios
fun main() {
/*
    println("8 e 12 = ${mdc(8, 12)}")
    println("9 e 27 = ${mdc(9, 27)}")
    println("259 e 111 = ${mdc(111, 259)}")
*/  val lista = mutableListOf<Int>()
    var n1 : Int
    var n2 : Int

        for (i in 1..readLine()!!.toInt()) {
            val input = readLine()!!.split(" ").map { it.toInt() }
            n1 = input[0]
            n2 = input[1]

            lista.add(mdc(n1,n2))
        }
    lista.forEach { println(it) }
    //println("$lista\n")
}



// máximo divisor comum (chamada recursiva)
fun mdc(n1: Int, n2: Int): Int {
    var m : Int = n1
    var n : Int = n2
    var aux : Int

    while (n > 0) {
        aux = n
        n = m.rem(n)
        m = aux
    }
    return m
}



/*
fun main() {
    println("Hello Word")

    var a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val prod = a.times(b)
    println("PROD = $prod")   //insira as variaveis corretamente
    a = 10
    for (i in 2..a step 1) {
    if (i.mod(2) == 0)
        println("Primo $i = ${numeroPrimo(i)}")
    }

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

fun mdc()
 */
