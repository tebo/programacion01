import java.util.Scanner;

public class bucle {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa cuantos valores tendra el vector: ");
        int numero = entrada.nextInt();
        
        int[] vector = new int[numero];
        for (int i = 0; i < numero; i++) {
            vector[i] = i + 45;
            System.out.println("Posicion[" + i + "] valor" + vector[i]);
        }
        entrada.close();
    }
}
