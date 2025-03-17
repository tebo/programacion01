//Completa el bucle for para sumar todos los números del 1 al 1000 de los números pares y que no sean múltiplos de 10.

public class numPares {
    public static void main(String[] args) {
    int suma = 0;
    for (int i = 1; i <= 1000; i++) {
        if (i % 2 == 0 && i % 10 != 0) {
            suma += i;
            }
        }
        System.out.println(suma);
        }
    }