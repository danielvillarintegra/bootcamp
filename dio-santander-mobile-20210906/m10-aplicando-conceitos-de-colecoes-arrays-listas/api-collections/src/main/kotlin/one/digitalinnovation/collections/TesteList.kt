package one.digitalinnovation.collections

fun main (){
    val joao = Funcionario("João", 2000.0)
    val pedro = Funcionario("Pedro", 1500.0)
    val maria = Funcionario("Maria", 4000.0)

    val funcionarios = listOf(joao, pedro, maria,)

    println("a) Original -----------------")
    funcionarios.forEach { println(it)}
    println(funcionarios.find { it.nome == "Maria" })

    println("b) Sort -----------------")
    funcionarios
        .sortedBy{it.salario}
        .forEach { println(it)}

}

data class Funcionario(
    val nome: String,
    val salario: Double

)  {
    override fun toString(): String =
        """
            Nome: $nome
            Salario: $salario

        """.trimIndent()


}