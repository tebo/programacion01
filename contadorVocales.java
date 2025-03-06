// Ejercicio para contar vocales
import java.util.Scanner;

public class contadorVocales {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce una palabra o frase: ");
            String cadena = sc.nextLine();  // Leer una cadena
            // Eliminar los espacios en blanco
            cadena = cadena.trim();
            // Convertir la cadena a minúsculas
            cadena = cadena.toLowerCase();
            // Contar las vocales
            int contador = 0;
            for (int i = 0; i < cadena.length(); i++) {
                char letra = cadena.charAt(i);
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || 
                letra == 'á' || letra == 'é' || letra == 'í' || letra == 'ó' || letra == 'ú') {
                    contador++;
                }
            }
            System.out.println("El número de vocales es: " + contador);

            sc.close();
        }
}
