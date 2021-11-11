package com.example.desafiocarrefourm24

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    val n: Int
    var n1: Int
    var d1: Int
    var n2: Int
    var d2: Int
    var nf = 0
    var df = 0
    var ns: Int
    var ds: Int
    var aux0: String
    var aux1: String
    var aux2: String
    n = scan.nextInt()
    for (i in 1..n) {
        n1 = scan.nextInt()
        aux1 = scan.next()
        d1 = scan.nextInt()
        aux0 = scan.next()
        n2 = scan.nextInt()
        aux2 = scan.next()
        d2 = scan.nextInt()
        when (aux0) {
            "+" -> { //Soma: (N1*D2 + N2*D1) / (D1*D2)
                //nf = ((n1.times(d2)).plus(n2.times(d1))).div((d1.times(d2)))
                nf =(n1*d2 + n2*d1)
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
        ns = nf
        ds = df

        /* while (                                        ) {
            if (                 ) {

            } else {

            }
        } */
        println("$nf/$df = $ns/$ds")
    }
}