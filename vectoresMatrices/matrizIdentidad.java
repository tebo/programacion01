package vectoresMatrices;
// Ejercicio que genera una matriz de identidad
import java.util.Scanner;   // Importar la clase Scanner
public class matrizIdentidad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // Crear un objeto Scanner
        System.out.println("Introduce el tamaño de la matriz: ");
        int n = sc.nextInt();   // Leer un entero
        int[][] matriz = new int[n][n]; // Declarar e inicializar la matriz
        // Rellenar la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
            }
        }
        // Mostrar la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        sc.close(); // Cerrar el objeto Scanner
    }
}