package one.digitalinnovation.collections

fun main() {
    val salarios = arrayOf(
        "2000".toBigDecimal(),
        "1500".toBigDecimal(),
        "4000".toBigDecimal()
    )


    println("a) Somatoria, que é uma função extendida --------------------")
    println(salarios.somatoria())

    println("b) media, que é uma função extendida  --------------------")
    println(salarios.media())

}