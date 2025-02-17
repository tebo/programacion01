import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingresa cuantos numeros se mostraran en la serie de Fibonacci: ");
        int n = entrada.nextInt();
        
        long num1 = 0, num2 = 1;

        System.out.print("Serie de Fibonacci de " + n + " términos: ");

        for (int i = 1; i <= n; ++i) {
            System.out.println(num1 + " ");

            // Calcular el siguiente término
            long sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }

        entrada.close();
    }
}