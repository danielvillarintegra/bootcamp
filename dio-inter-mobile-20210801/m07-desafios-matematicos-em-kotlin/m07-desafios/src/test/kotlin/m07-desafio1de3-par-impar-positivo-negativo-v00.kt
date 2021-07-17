
fun main() {

    val inteiros = mutableListOf<Int>(-5, 0, -3, -4, 12)
/* continue declarando as variaveis */
    val pares = mutableListOf<Int>()
    val impares = mutableListOf<Int>()
    val positivos = mutableListOf<Int>()
    val negativos = mutableListOf<Int>()


/*    inteiros.forEach {println(it)} */

/* Seleciona os valores positivos e negativos */
    inteiros.forEach {
        if ( it > 0 ) {
            positivos.add(it)
        } else if ( it < 0 ) {
            negativos.add(it)
        }
    }

    inteiros.forEach {
        if (it.rem(2) == 0 ) {
            pares.add(it)
        } else impares.add(it)
    }

    println("${pares.size} valor(es) par(es)")
    println("${impares.size} valor(es) impar(es)")
    println("${positivos.size} valor(es) positivo(s)")
    println("${negativos.size} valor(es) negativo(s)")
}