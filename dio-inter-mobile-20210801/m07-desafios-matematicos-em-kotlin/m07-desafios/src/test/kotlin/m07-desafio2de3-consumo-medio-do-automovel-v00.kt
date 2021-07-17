import java.util.Scanner;

fun main(args: Array<String>) {
    val leitor = Scanner(System.`in`);
    //continue o código

    val x: Int = leitor.nextInt();  /* x é a distância percorrida em kilometros */
    val y: Float = leitor.nextFloat();  /* y é o consumo em litros */
    val media: Float

    media = x.div(y)

    println(String.format("%.3f km/l", media));
}