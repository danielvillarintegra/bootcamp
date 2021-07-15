package one.digitalinnovation.collections

fun main() {
    val pair: Pair<String, Double> = Pair("João" , 1000.0)
    val map1 = mapOf(pair)

    println("a) Original -------------------")
    map1.forEach{ (k, v) -> println("Chave: $k - Valor: $v") }

    println("b) outra maneira de escrever o mesmo código -------------------")
    map1.forEach { k, v -> println("Chave: $k - Valor: $v") }


    println("c) infix -------------------")
    val map2 = mapOf(
        "Pedro" to 2500.0,
        "Maria" to 3000.0
    )
    map2.forEach{ (k, v) -> println("Chave: $k - Valor: $v") }
}