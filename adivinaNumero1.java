import java.util.Scanner;

public class adivinaNumero1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa el numero: ");
        int numero = entrada.nextInt();

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        boolean resultado = false;
        int i = 0;
        while ((resultado == false) || (i<=9)) {
            System.out.print("Ingresa tu opcion: ");
            int opcion = entrada.nextInt();
            i++;

            if (opcion == numero) {
                System.out.println("¡Felicidades! Adivinaste el número.");
                resultado = true;
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
