
fun main() {
    val resultados = mutableListOf<Int>()
    var c : Char
    var j : Int

    for (i in 48..57) {
        when (i) {
            in 48..57 -> { println("$i = ${i.toChar()} ${i.toChar().digitToInt()*2} número")
                c = i.toChar()
                j = (c - 48).toInt()
                println("$j")
            }
            in 65..90 -> { println("$i = ${i.toChar()} letra maiúscula") }
            in 97..122 -> { println("$i = ${i.toChar()} letra minúscula") }
            else -> println("$i = ${i.toChar()}")
        }
    }
}


