package one.digitalinnovation.collections

fun main () {
    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CLT")

    val repositorio = Repositorio<Funcionario>()

    repositorio.create(joao.nome, joao)
    repositorio.create(pedro.nome, pedro)
    repositorio.create(maria.nome, maria)

    println("a) Original -------------------")
    println(repositorio.findById(maria.nome))

    println("b) findAll -------------------")
    println(repositorio.findAll())

    println("c) findAll com forEach-------------------")
    repositorio.findAll().forEach { println(it) }

    println("d) remove maria  ---------------")
    repositorio.remove(maria.nome)
    repositorio.findAll().forEach { println(it) }

}