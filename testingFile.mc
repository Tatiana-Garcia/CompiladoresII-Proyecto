int res;

void main() {
    int a = 10;
    int b = 20;

    int c = a + b * 2;

    print_str("Esperado 50: ");
    print_int(c);
    println();


    if (c > 40 && a == 10) {
        print_str("Correcto: c es mayor a 40 y a es 10");
    } else {
        print_str("Error: Fallo en logica booleana");
    }
    println();

    int f = 5;
    int fact = 1;

    while (f > 0) {
        fact = fact * f;
        f = f - 1;
    }

    print_str("Factorial de 5 (120): ");
    print_int(fact);
    println();
}