// Ejercio para determinar si un palabra o frase es palindromo
import java.util.Scanner;

public class palindromo {
    public static String invertirCadena(String cadena) {
        // Determinar la longitud de la cadena
        int longitud = cadena.length();
        // Crear una cadena vacía
        String cadenaInvertida = "";
        // Invertir la cadena
        for (int i = longitud - 1; i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);
        }
        return cadenaInvertida;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una palabra o frase: ");
        String cadena = sc.nextLine();
        // Eliminar los espacios en blanco
        cadena = cadena.trim();
        // Convertir la cadena a minúsculas
        cadena = cadena.toLowerCase();
    
        if (cadena.equals(invertirCadena(cadena))) {
            System.out.println("La cadena es un palíndromo");
        } else {
            System.out.println("La cadena no es un palíndromo");
        }
        sc.close();
    }
}
