fun main() {
    
    val n = readLine()!!.toInt()
     //declare suas variaveis auxiliares e continue a solucao
    var sum : Int = 0
    var t0 : Int = 0
    var t1 : Int =1
    
    for (i in 1..(n-1)) {
        print("$t0 ")
        
        sum = t0.plus(t1) 
        t0 = t1
        t1 = sum
    }
    print("$t0")
    println()
    
}