
import java.util.Scanner

fun main() {
    val divisor = 1009 	// Entre com um numero inicial qualquer.
    // O resultado final será o próximo numero primo após esse número inicial
    val proximoPrimo = nextPrime(divisor + 1)
    println("divisor: $divisor - Próximo primo:$proximoPrimo")

    println("${primesInRange(100, 30)}")
}

private fun nextPrime(divisor : Int): Int {
    var n = divisor
    while (!primo(n)) n++
    return n
}

private fun primo(n : Int) : Boolean {
    var d : Long = 2
    if (n <= 1) return false
    while (d*d <= n ) {
        if (n.rem(d) == 0L ) // d divide n
            return false
        d++
    }
    return true
}

// verifica se é primo dentro de um range
private fun primesInRange(a: Int, b: Int) {
    var aux : Int
    var inicio = a
    var fim = b

    if (inicio > fim) {
        aux = inicio
        inicio = fim
        fim = aux
    }
    if (inicio.rem(2) == 0) inicio = inicio + 1 //verifica se é impar
    for(i in inicio..fim step 2)
        if (primo(i)) print("$i, ")
}


/*
int main ()
{
    int a,b,n,cont,primo;

    printf("Digite o infimo e o supremo de um intervalo, separados por espaço:\n");
    scanf("%i %i", &a, &b);

    if (a > b) printf("erro\n");
    else {
            for (cont = a; cont <= b; cont++) {
                primo = 0;
                for(n = 1; n <= cont; n++) {
                    if(cont % n == 0)
                    primo++;
                }
            if(primo == 2)
            printf("%d\n", cont);
          }
    return 0;
}
*/