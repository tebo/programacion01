import java.util.Scanner;

public class ingreso2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa un número entero 1: ");
        int numero1 = entrada.nextInt();
        System.out.println("el numero es: " + numero1);

        System.out.print("Ingresa tu nombre: ");
        String nombre = entrada.next();
        System.out.println("el nombre es: " + nombre);
        entrada.close();
        }
    }