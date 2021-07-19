fun main() {
    val N = readLine()!!
    var notas = N.toInt()

    val notas100 = notas.div(100)
    notas = notas.minus(notas100.times(100))

    val notas50 = notas.div(50)
    notas = notas.minus(notas50.times(50))

    val notas20 = notas.div(20)
    notas = notas.minus(notas20.times(20))

    val notas10 = notas.div(10)
    notas = notas.minus(notas10.times(10))

    val notas5 = notas.div(5)
    notas = notas.minus(notas5.times(5))

    val notas2 = notas.div(2)
    notas = notas.minus(notas2.times(2))

    println("$N")
    print("$notas100 nota(s) de R$ 100,00 \n")
    print("$notas50 nota(s) de R$ 50,00\n")
    print("$notas20 nota(s) de R$ 20,00\n")
    print("$notas10 nota(s) de R$ 10,00\n")
    print("$notas5 nota(s) de R$ 5,00\n")
    print("$notas2 nota(s) de R$ 2,00\n")
    print("$notas nota(s) de R$ 1,00\n")
}