package one.digitalinnovation.collections

fun main () {
    val salarios = doubleArrayOf(1000.0 , 2250.0 , 4000.0)

    println("a) Original ---- ")
    for (salario in salarios) {
        println("$salario")
    }
        println("Maior salário: ${salarios.max()}")
        println("Menor salário: ${salarios.min()}")
        println("Média salarial: ${salarios.average()}")

    println("b) filter ---- ")
    val salariosMaiorQue2500 = salarios.filter{it > 2500.0}
    salariosMaiorQue2500.forEach { println(it) }

    println("c) Substituindo max e min ( deprecated ) ---- ")
    println("Maior salário: ${salarios.maxOrNull()}")
    println("Menor salário: ${salarios.minOrNull()}")
    println("Média salarial: ${salarios.average()}")

    println("d) Array count ---- ")
    println(salarios.count{it in 2000.0 .. 5000.0})

    println("e) find ---- ")
    println(salarios.find{it == 2250.0})
    println(salarios.find{it == 500.0})

    println("e) any ---- ")
    println(salarios.any{it == 1000.0})
    println(salarios.any{it == 500.0})
}