// 1 / 5 - Teste de Seleção 1

fun main(args: Array<String>) {

    val input = readLine()!!
//continue a solucao
    val a = input.split(" ")[0].toInt()
    val b = input.split(" ")[1].toInt()
    val c = input.split(" ")[2].toInt()
    val d = input.split(" ")[3].toInt()

    if (  (b > c ) && (d  > a)  && ((c.plus(d)) > (a.plus(b))) &&((c > 0) && (d  > 0)) && (a % 2 ==0 )) {
        println("Valores aceitos")
    } else {
        println("Valores nao aceitos")
    }

}