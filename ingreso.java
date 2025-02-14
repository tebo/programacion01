import java.util.Scanner;

public class ingreso {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa un número entero 1: ");
        int numero1 = entrada.nextInt();
        System.out.print("Ingresa un número entero 2: ");
        int numero2 = entrada.nextInt();
        int resultado = numero1 + numero2;
        System.out.println("La suma de numero 1 y numero 2 es: " + resultado);
        resultado = numero1 - numero2;
        System.out.println("La resta de numero 1 y numero 2 es: " + resultado);
        resultado = numero1 * numero2;
        System.out.println("La multiplacacion de numero 1 y numero 2 es: " + resultado);
        resultado = numero1 / numero2;
        System.out.println("La division de numero 1 y numero 2 es: " + resultado);

        entrada.close();
        }
    }