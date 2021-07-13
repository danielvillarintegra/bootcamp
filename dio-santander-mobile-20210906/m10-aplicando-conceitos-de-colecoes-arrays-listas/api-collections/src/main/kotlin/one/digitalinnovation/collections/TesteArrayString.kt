package one.digitalinnovation.collections

fun main() {
    val nomes = Array(3) {""}
    nomes[0]    = "Maria"
    nomes[1]    = "Zazá"
    nomes[2]    = "José"

    println("a) for in ------------------")
    for (nome in nomes) {
        println(nome)
    }
    println("b) sort ------------------")
    nomes.sort()
    nomes.forEach {
        println(it)
    }

    println("c) ------------------")
    val nomes2 = arrayOf("Maria", "Zaza", "Pedro")
    nomes2.sort()
    nomes2.forEach {
        println(it)
    }

}