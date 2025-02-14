import java.util.Scanner;

public class ordenarvector {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa cuantos valores tendra el vector: ");
        int numero = entrada.nextInt();
        
        int[] vector = new int[numero];
        for (int i = 0; i < numero; i++) {
            System.out.print("Ingrese la posicion del vector " + i + "-> ");
            vector[i] = entrada.nextInt();
        }

        int aux;
        for (int j = 0; j < numero; j++) {
            for (int i = 0; i < (numero - 1); i++) {
                if (vector[i] < vector[i+1]) {
                    aux = vector[i];
                    vector[i] = vector[i+1];
                    vector[i+1] = aux;
                }
            }
        }

        for (int i = 0; i < numero; i++) {
            System.out.println("posicion del vector " + i + "-> " + vector[i]);
        }
        entrada.close();
    }
}
