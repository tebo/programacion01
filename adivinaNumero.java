import java.util.Scanner;

public class adivinaNumero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa el numero: ");
        int numero = entrada.nextInt();

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingresa tu opcion: ");
            int opcion = entrada.nextInt();

            if (opcion == numero) {
                System.out.println("¡Felicidades! Adivinaste el número.");
                break;
            } else {
                if (opcion < numero) {
                    System.out.println("El número es mayor.");
                } else {
                    System.out.println("El número es menor.");
                }
                System.out.println("Intenta de nuevo.");
            }
        }

        entrada.close();
    }
}
