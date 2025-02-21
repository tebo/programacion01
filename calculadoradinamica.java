import java.util.Scanner;

public class calculadoradinamica {
    
    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Salir");
        System.out.println("Ingrese la opción deseada: ");
        int opcion = sc.nextInt();
        sc.close();
        return opcion;
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

    public static int multiplicacion(int[] valores) {
        int multiplicacion = 0;
        for (int i = 0; i < valores.length; i++) {
            multiplicacion *= valores[i];
        }
        return multiplicacion;
    }

    public static int division(int[] valores) {
        int division = 0;
        for (int i = 0; i < valores.length; i++) {
            division /= valores[i];
        }
        return division;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = menu();

        int [] valores = new int[10];
        int i = 0;

        do {
            System.out.println("Ingrese el valor " + (i) + ": ");
            String dato = sc.next();
            if (dato.equals("=")) {
                break;
            }
            valores[i] = Integer.parseInt(dato);
            i++;
        } while (i < 10 );
        
        if (opcion == 1) {
            System.out.println("La suma es: " + suma(valores));
        } else if (opcion == 2) {
            System.out.println("La resta es: " + resta(valores));
        } else if (opcion == 3) {
            System.out.println("La multiplicación es: " + multiplicacion(valores));
        } else if (opcion == 4) {
            System.out.println("La división es: " + division(valores));
        } else if (opcion == 5) {
            System.out.println("Adiós");
        } 
        else {
            System.out.println("Opción no válida");
        }

        sc.close();
                 
}
}