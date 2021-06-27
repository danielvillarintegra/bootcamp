fun main() {
    do {
        println("Pressione uma letra para:")
        println("(A) Soma")
        println("(B) Subtração")
        println("(C) Multiplicação")
        println("(D) Divisão / Resto")
        println("(E) Exponenciação")
        println("(S) Sair")

            val letra = readLine()!!
            /* println(letra) */
            when (letra.toUpperCase()) {
                            "A" -> {
                                    println("Soma")
                                    soma()
                            }
                            "B" -> println("Subtração")
                            "C" -> println("Multiplicação")
                            "D" -> println("Divisão / Resto")
                            "E" -> println("Exponenciação")
                            "S" -> println("Sair")
                            else -> println("escolha inválida")
            }

        } while ((letra.toUpperCase()) != "S")


}

fun soma() {

/*  Verificar se é letra ou null ou outro caractere diferente do float
    ou forçar uma formatação de entrada
    do {
        print("Digite o primeiro número: ")
        var a = readLine()!!
        if (a.isNullOrBlank()==1)
    } while (a.isNullOrBlank()==1)
*/
    print("Digite o primeiro número: ")
    var a = readLine()!!

    println()
    print("Digite o segundo número: ")
    var b = readLine()!!

    var resultado : Float

    a = a.replace(",",".")
    b = b.replace(",",".")

    print("Soma: $a + $b = ")
    resultado = (a.toFloat()).plus(b.toFloat())
    println("($resultado)")
}
