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
                            "A" -> println("Soma")
                            "B" -> println("Subtração")
                            "C" -> println("Multiplicação")
                            "D" -> println("Divisão / Resto")
                            "E" -> println("Exponenciação")
                            "S" -> println("Sair")
                            else -> println("escolha inválida")
            }

        } while ((letra.toUpperCase()) != "S")


}
  