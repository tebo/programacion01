// ejercico para la suma de matrices
import java.util.Scanner;
public class sumaMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de filas de la matriz: ");
        int filas = sc.nextInt();
        System.out.println("Introduce el número de columnas de la matriz: ");
        int columnas = sc.nextInt();
        int[][] A = new int[filas][columnas];
        int[][] B = new int[filas][columnas];
        int[][] C = new int[filas][columnas];
        // Pedir los elementos de la matriz A
        System.out.println("Introduce los elementos de la matriz A: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = sc.nextInt();
            }
        }
        // Pedir los elementos de la matriz B
        System.out.println("Introduce los elementos de la matriz B: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = sc.nextInt();
            }
        }
        // Sumar las matrices A y B
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        // Mostrar la matriz C
        System.out.println("Matriz resultante de la suma: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}