//Programa para determinar el tipo de triangulo dados sus lados

import java.util.Scanner;
public class triangulo {
    public static void determinaTipo(int lado1,int lado2, int lado3) {
        
        if (lado1 == lado2 && lado2 == lado3) {
            System.out.println("El triángulo es equilátero");
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            System.out.println("El triángulo es isósceles");
        } else {
            System.out.println("El triángulo es escaleno");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el lado 1: ");
        int a = sc.nextInt();
        System.out.println("Ingrese el lado 2: ");
        int b = sc.nextInt();
        System.out.println("Ingrese el lado 3: ");
        int c = sc.nextInt();
        determinaTipo(a, b, c);
        sc.close();
    }
}
