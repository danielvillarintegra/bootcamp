import java.util.Scanner;

fun main() {
    val linhas = mutableListOf<String>()
    val resultados = mutableListOf<Int>()

    var aux : String
    var raio1 : Int
    var raio2 : Int
    var resultado : Int

    val linha1 : String = readLine()!!     /* Le a quantidade de de pares de inteiros (os raios dos fios) */


    val T = linha1.toInt() /* Quantidade de linhas de entrada */

    /* Ler "T" linhas de entrada */
    for (i in 1..T) {
        linhas.add(readLine()!!)
    }

    for (i in 0..T-1) {
        /* Converter linha em inteiros e coletar os raios */
        /* armazenar o resultado */
        raio1 = 0
        raio2 = 0
        resultado = 0
        aux = ""
        linhas[i].forEach {
                if (it.isWhitespace() != true) {
                    aux = aux + it
                } else {
                    if (raio1 == 0) {
                        raio1 = aux.toInt()
                        aux = "0"
                    }
                }
        }
        raio2 = aux.toInt()
        resultado = raio1.plus(raio2)
        resultados.add(resultado)
    }

    resultados.forEach { println(it) }
}


