import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Circulotest c1 = new Circulotest();
        Circulotest c2 = new Circulotest();
        c1.radio = 5.0;
        c1.color = "rojo";
        c2.radio = 3.5;
        c2.color = "azul";
        //System.out.println(c1);                       // toString()
        System.out.println("Area c1: " + c1.calcularArea());
        System.out.println("Area c2: " + c2.calcularArea());
        System.out.println("Perimetro c1: " + c1.calcularPerimetro());
        System.out.println("Perimetro c2: " + c2.calcularPerimetro());
    }
}


class Circulotest {
    double radio;          // atributo encapsulado
    String color;

    public double calcularArea() { 
        return Math.PI * radio * radio; 
    }

    public double calcularPerimetro() { 
        return 2 * Math.PI * radio;     
    }

}