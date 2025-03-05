import java.util.Scanner;
public class juegoAhorcado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // ingreso palabra a adivinar
        System.out.println("Introduce una palabra: ");
        String palabra = sc.next();

        // Mostramos la palabra oculta con *
        int longitud = palabra.length();
        String palabraOculta = "";
        for (int i = 0; i < longitud; i++) {
            palabraOculta += "*";
        }
        System.out.println("La palabra oculta es: " + palabraOculta);
        
        int intento=0;

        //Pedimos letras al usuario y vamos mostrando la palabra oculta hasta que acierte o falle 5 veces
        do {
            System.out.println("Introduce una letra: ");
            char letra = sc.next().charAt(0);
            for (int i = 0; i < longitud; i++) {
                if (palabra.charAt(i) == letra) {
                    palabraOculta = palabraOculta.substring(0, i) + letra + palabraOculta.substring(i + 1);
                }
            }
            System.out.println("La palabra oculta es: " + palabraOculta);
            intento++;
        } while (!palabra.equals(palabraOculta) && intento < 5);
        
        if (palabra.equals(palabraOculta)) {
            System.out.println("Has acertado la palabra es: " + palabra);
        } else {
            System.out.println("No has acertado la palabra es: " + palabra);
        }
        sc.close();
    }
}
