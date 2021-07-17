import java.util.Scanner;

fun main() {
    //continue o codigo
    var aux : String = ""
    var H : Int = 0
    var P : Int = 0

    val linha : String = readLine()!!


    linha.forEach {
        if (it.isWhitespace() != true) {
            aux = aux + it
        } else {
            if (H == 0) {
                H = aux.toInt()
                aux = "0"
            }
        }
    }
    P = aux.toInt()


    val media : Double= (H.toDouble().div(P.toDouble()))

    println(String.format("%.2f", media))
}
