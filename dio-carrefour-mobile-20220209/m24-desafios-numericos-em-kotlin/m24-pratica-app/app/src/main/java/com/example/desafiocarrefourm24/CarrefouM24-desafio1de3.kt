package com.example.desafiocarrefourm24

fun main() {
    val resultados = mutableListOf<Int>()

    val N = readLine()!!.toInt()
    for (i in 1..N) {
        var input : String = readLine()!! //.split(" ").map { it.toInt() }
        var N1 : Int = ConvertCharToInt(input[0]) //.toInt()//digitToInt()
        var letra : Char = input[1]//toChar() //code
        var N2 : Int = ConvertCharToInt(input[2]) //.toInt()//digitToInt()

        //println("$input")
//        println("$N1, $letra, $N2")
        if (N1==N2) {
//            println("n1 = n2")
//            println(N1.times(N2))
            resultados.add(N1.times(N2))
        } else if ("$letra" in "A".."Z" ) { //>=65 && letra <=90 ) {
//            println("n1 - n2")
//            println(N2.minus(N1))
            resultados.add(N2.minus(N1))
            }
            else {
//                println("n1 + n2")
//                println(N1.plus(N2))
            resultados.add(N1.plus(N2))
            }
        }
    resultados.forEach{ println(it) }
}

fun ConvertCharToInt(carac : Char) : Int
{
    var j : Int
    var c : Char
    if ("$carac" in "0".."9") {
        c = carac.toChar()
        j = (c - 48).toInt()
        }
    else j = 0
    return j
}
