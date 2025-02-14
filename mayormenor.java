// Ejercicio que pide tres números y los ordena de mayor a menor y de menor a mayor
// Se importa la librería Scanner
import java.util.Scanner;

public class mayormenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedimos los tres números
        System.out.println("Ingrese tres números diferentes:");
        System.out.print("Primer número: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Segundo número: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Tercer número: ");
        int num3 = scanner.nextInt();
        
        // Variables para almacenar los números ordenados
        int mayor, medio, menor;
        
        // Ordenamiento usando if anidados
        if (num1 > num2) {
            if (num1 > num3) {
                mayor = num1;
                if (num2 > num3) {
                    medio = num2;
                    menor = num3;
                } else {
                    medio = num3;
                    menor = num2;
                }
            } else {
                mayor = num3;
                medio = num1;
                menor = num2;
            }
        } else {
            if (num2 > num3) {
                mayor = num2;
                if (num1 > num3) {
                    medio = num1;
                    menor = num3;
                } else {
                    medio = num3;
                    menor = num1;
                }
            } else {
                mayor = num3;
                medio = num2;
                menor = num1;
            }
        }
        
        // Mostramos los números ordenados
        System.out.println("\nNúmeros ordenados de mayor a menor:");
        System.out.println(mayor + " > " + medio + " > " + menor);
        
        // Mostramos los números ordenados de menor a mayor
        System.out.println("\nNúmeros ordenados de menor a mayor:");
        System.out.println(menor + " < " + medio + " < " + mayor);
        
        scanner.close();
    }
}