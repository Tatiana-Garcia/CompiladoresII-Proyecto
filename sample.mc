int main() {
    int a = 5;
    int b = 10;
    int suma;

    if (a < b) {
        suma = a + b;
    } else {
        suma = a - b;
    }

    while (suma > 0) {
        suma = suma - 1;
    }

    return suma;
}
