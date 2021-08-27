import java.io.EOFException

fun main() {

    while (true) {

        try {
            var aux1 : String = ""
 //           val linha : String = ("10 10 10 10 15 18 20 15 11 10")

            var v = mutableListOf<Int>()
            val l = readLine()!!.toInt()
            //val l = 10
            val linha : String = readLine()!!

            linha.forEach {
                if (it.isWhitespace() == true) {
                    v.add(aux1.toInt())
                    aux1 = "0"
                } else if ((it.isLetter() == false)) {
                    aux1 = aux1 + it

                } else {
                    throw NumberFormatException("Caracter invalido")
                    //println ("Letra encontrada: $it")
                    //aux1="0"
                    //aux2 = aux2 + it
                }
            }
            v.add(aux1.toInt())
            if (v.size==l) {
                v.sort()
                when (v.last()) {
                    in 0..9 -> println("1")
                    in 10..19 -> println("2")
                    !in 0..19 -> println("3")
                    else -> throw Exception("Velocidades fora do range de 0 .. 20 cm/h")
                }
                // println("inteiros: $v")
            } else throw Exception("Quantidade de dados de velocidade diferente do quantidade de tartarugas")
        } catch (f :  NullPointerException) {
        break
    } catch (n : NumberFormatException) {
        break
    } catch (e : Exception) {
        break
    }
}
}