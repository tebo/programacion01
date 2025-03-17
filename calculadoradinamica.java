import java.util.Scanner;

public class calculadoradinamica {
    
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Factorial");
        System.out.println("5. Salir");
        System.out.println("Ingrese la opción deseada: ");
        
        try {
            int opcion = sc.nextInt();
            return opcion;
        } catch (Exception e) {
            System.out.println("Caracter no valido -> " + e.getMessage());
            return 0;
        }
    }

    public static int[] datos (int n, char operacion) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[n];
        System.out.println("Ingrese los valores de la operacion " );
        for (int i = 0; i < n; i++) {
            String dato = sc.next();
            if (dato.equals("=")) {
                break;
            }
            try {
                valores[i] = Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                System.out.println("Caracter no valido -> " + e.getMessage());
                valores[i] = 0;
            }
            System.out.println(" " + operacion + " ");
        }

        return valores;
    }

    public static int suma(int[] valores) {
        int suma = 0;
        for (int i = 0; i < valores.length; i++) {
            suma += valores[i];
            //suma = suma + valores[i];
        }
        return suma;
    }

    public static int resta(int[] valores) {
        int resta = 0;
        for (int i = 0; i < valores.length; i++) {
            resta -= valores[i];
        }
        return resta;
    }

    public static int factorial(int[] valores) {
        int factorial = 1;
        for (int i = 1; i <= valores[0]; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            opcion = menu();
       

        int[] valores = new int[10];
        int i = 0;
             
        switch (opcion) {
            case 1 -> valores = datos(10, '+');
                System.out.println("La suma es: " + suma(valores));
                break;
            case 2:
                valores = datos(5, '-');
                System.out.println("La resta es: " + resta(valores));
                break;
            case 3:
                valores = datos(1, '!');
                System.out.println("El factorial es: " + factorial(valores));
                break;
            case 5:
                System.out.println("Adiós");
                break; 
            default:
                System.out.println("Opción no válida");
                break;
        }
        
    } while (opcion != 5);
        sc.close();            
}
}