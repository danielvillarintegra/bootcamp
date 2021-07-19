
fun main(    ) {
    val N = readLine()!!
    var notas = N.toInt()

    val notas100 = notas.div(100)
    notas = notas.rem(100)
    val notas50 = notas.div(50)
    notas = notas.rem(50)
    val notas20 = notas.div(20)
    notas = notas.rem(20)
    val notas10 = notas.div(10)
    notas = notas.rem(10)
    val notas5 = notas.div(5)
    notas = notas.rem(5)
    val notas2 = notas.div(2)
    notas = notas.rem(2)


    println("$N")
    println("$notas100 nota(s) de R$ 100,00")
    println("$notas50 nota(s) de R$ 50,00")
    println("$notas20 nota(s) de R$ 20,00")
    println("$notas10 nota(s) de R$ 10,00")
    println("$notas5 nota(s) de R$ 5,00")
    println("$notas2 nota(s) de R$ 2,00")
    println("$notas nota(s) de R$ 1,00")
}
