import java.util.Scanner;

public class calculadora {
 
    public static int suma (int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("Que desea hacer");
            System.out.println("1. suma");
            System.out.println("2. resta");
            System.out.println("5. Salir");
            opcion = entrada.nextInt();
            if (opcion  == 1) {
                System.out.println("Ingrese primer valor: ");
                int a = entrada.nextInt();
                System.out.println("Ingrese segundo valor: ");
                int b = entrada.nextInt();
                int resultado = suma(a, b);
                System.out.println("La suma es: " + resultado);
            } else if (opcion == 2) {
                System.out.println("Ingrese primer valor: ");
                int a = entrada.nextInt();
                System.out.println("Ingrese segundo valor: ");
                int b = entrada.nextInt();
                System.err.println("La resta es: " + (a - b));
            } else if (opcion == 5) {
                System.out.println("Adios");
            } else {
                System.out.println("Opcion no valida");
            }
        } while (opcion != 5);
        entrada.close(); 
    }
}
