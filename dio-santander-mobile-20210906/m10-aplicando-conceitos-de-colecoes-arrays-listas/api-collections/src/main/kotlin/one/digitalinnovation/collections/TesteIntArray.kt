package one.digitalinnovation.collections

fun main () {
    val values = IntArray(5)
    values[0] = 1
    values[1] = 7
    values[2] = 6
    values[3] = 3
    values[4] = 2
    println ("a) --------------------")
    for (valor in values)
        println(valor)
    println ("b) ForEach (it)--------------------")
    values.forEach {
        println(it)
    }

    println ("c) ForEach valor --------------------")
    values.forEach { valor ->
        println(valor)
    }
    println ("d) index in --------------------")
    for (index in values.indices) {
        println(values[index])
    }

    println ("e) sort --------------------")
    values.sort()
    for (valor in values) {
        println(valor)
    }
}