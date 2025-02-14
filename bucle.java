// Ejercicio de ingreso de datos en un vector
// Se importa la libreria Scanner
import java.util.Scanner;

// Se crea un objeto de la clase Scanner
public class bucle {
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);
        
        // Se solicita al usuario que ingrese la cantidad de valores que tendrá el vector
        System.out.print("Ingresa cuantos valores tendra el vector: ");
        int numero = entrada.nextInt();
        
        // Se crea un vector con la cantidad de valores especificada por el usuario
        int[] vector = new int[numero];
        
        // Se llena el vector con valores y se imprimen
        for (int i = 0; i < numero; i++) {
            vector[i] = i + 45; // Se asigna el valor i + 45 a cada posición del vector
            System.out.println("Posicion[" + i + "] valor" + vector[i]); // Se imprime el valor de cada posición del vector
        }
        
        // Se cierra el objeto Scanner
        entrada.close();
    }
}