
import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    val n: Long
    var n1: Int
    var d1: Int
    var n2: Int
    var d2: Int
    var nf = 0
    var df = 0
    var ns = 0
    var ds = 0
    var aux0: String

    n = scan.nextLong()
    for (i in 1..n) {
        n1 = scan.nextInt()
        scan.next() // Lê o caractere. Mas nesse programa não precisamos usar, por isso não foi atribuido uma variável
        d1 = scan.nextInt()
        aux0 = scan.next()
        n2 = scan.nextInt()
        scan.next() // Lê o caractere. Mas nesse programa não precisamos usar, por isso não foi atribuido uma variável
        d2 = scan.nextInt()
        when (aux0) {
            "+" -> { //Soma: (N1*D2 + N2*D1) / (D1*D2)
                //nf = ((n1.times(d2)).plus(n2.times(d1))).div((d1.times(d2)))
                nf = ((n1.times(d2)).plus(n2.times(d1)))
                //nf =(n1*d2 + n2*d1)
                df = d1.times(d2)
            }
            "-" -> { //Subtração: (N1*D2 - N2*D1) / (D1*D2)
                nf = (n1.times(d2) - n2.times(d1))
                df = d1.times(d2)
            }
            "*" -> {//Multiplicação: (N1*N2) / (D1*D2)
                nf = (n1.times(n2))
                df = d1.times(d2)
            }
            "/" -> {//Divisão: (N1/D1) / (N2/D2), ou seja (N1*D2)/(N2*D1)
                nf = n1.times(d2)
                df = n2.times(d1)
            }
        }

        var divisor : Int = 2
        var divisorGeral : Int = 1
        var restoDs : Int
        var restoNs : Int

        ds = df
        ns = nf

        if (ns<0) {
            ns = ns.times(-1)
        }

        while (((ds > 1) || (ns > 1))&&(divisor<df)) {
            restoDs = ds.rem(divisor)
            restoNs = ns.rem(divisor)

            if (restoDs==0) {
                ds = ds.div(divisor)
            }

            if (restoNs==0) {
                ns = ns.div(divisor)
            }

            if ((restoDs == 0)&&(restoNs == 0)) {
                divisorGeral = divisorGeral * divisor

            } else divisor ++ // implementar divisor = nextPrime

        }

        ns = nf.div(divisorGeral)
        ds = df.div(divisorGeral)

        println("$nf/$df = $ns/$ds")
    }
}
