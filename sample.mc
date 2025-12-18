int main() {
    int a = 5;
    int b = 10;
    int suma;

    if (a < b) {
        suma = a + b;
    } else {
        suma = a - b;
    }
    print_str("suma: ");
    print_int(suma);

    while (suma > 0) {
        suma = suma - 1;
    }
    print_str("\nsuma: ");
    print_int(suma);

    return suma;
}
