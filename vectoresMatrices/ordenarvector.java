package vectoresMatrices;
// Ejercicio 1.2: Ordenar un vector de mayor a menor
// Crear un programa que pida al usuario cuántos valores va a ingresar, luego solicite los valores y los almacene en un vector. Finalmente, el programa debe ordenar los valores de mayor a menor y mostrarlos en pantalla.
import java.util.Scanner;

public class ordenarvector {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa cuantos valores tendra el vector: ");
        int numero = entrada.nextInt();        
        int[] vector = new int[numero];
        for (int i = 0; i < numero; i++) {
            System.out.print("Ingrese la posicion del vector " + i + "-> ");
            vector[i] = entrada.nextInt();
        }
        // Ordenamiento de mayor a menor
        int aux;
        for (int j = 0; j < numero; j++) {
            for (int i = 0; i < (numero - 1); i++) {
                if (vector[i] < vector[i+1]) {
                    // Intercambiamos los valores
                    aux = vector[i];
                    vector[i] = vector[i+1];
                    vector[i+1] = aux;
                }
            }
        }

        for (int i = 0; i < numero; i++) {
            System.out.println("posicion del vector " + i + "-> " + vector[i]);
        }
        entrada.close();
    }
}
