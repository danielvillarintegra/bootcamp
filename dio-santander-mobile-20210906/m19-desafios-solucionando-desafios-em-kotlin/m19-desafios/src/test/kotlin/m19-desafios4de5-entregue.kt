
fun main() {
    
    fun Double.format(digits: Int) = "%.${digits}f".format(this).replace(',','.')
    
    val (n1, n2, n3) = readLine()!!.split(" ")
  
//insira as variaveis de acordo com o calculo do perimetro e area 
    val a = n1.replace(",",".").toDouble()
    val b = n2.replace(",",".").toDouble()
    val c = n3.replace(",",".").toDouble()


    if (  (a < ( b.plus(c) )) &&  (b  < ( a.plus(c) )) && (c  < ( a.plus(b) )) ) { 
        val p = ( a.plus(b.plus(c) )).format(1)
        println("Perimetro = $p")
    } else {
        val r = ( (( ( a.plus(b) ).times(c)).div(2) ) ).format(1)
        println("Area = $r")
      }
    
}
