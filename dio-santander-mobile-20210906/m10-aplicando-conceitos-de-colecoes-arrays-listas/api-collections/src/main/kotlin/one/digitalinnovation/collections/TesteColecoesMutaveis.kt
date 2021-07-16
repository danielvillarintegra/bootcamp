package one.digitalinnovation.collections

fun main () {

    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0 , "PJ")
    val maria = Funcionario("Maria", 4000.0 , "CLT")

    println("a) Original -------------------")
    val funcionarios = mutableListOf(joao ,  maria)
    funcionarios.forEach{println(it)}

    println("b) Adicionando pedro -------------------")
    funcionarios.add(pedro)
    funcionarios.forEach{println(it)}

    println("c) Removendo joao -------------------")
    funcionarios.remove(joao)
    funcionarios.forEach{println(it)}

    println("d) setOf joao -------------------")
    val funcionarioSet = mutableSetOf(joao)
    funcionarioSet.forEach{println(it)}

    println("e) add pedro e maria -------------------")
    funcionarioSet.add(pedro)
    funcionarioSet.add(maria)
    funcionarioSet.forEach{println(it)}



}