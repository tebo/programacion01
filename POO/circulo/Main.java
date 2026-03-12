
public class Main {
    public static void main(String[] args) {
        Circulotest c1 = new Circulotest(5.0, "rojo");
        Circulotest c2 = new Circulotest(3.5, "azul");
        System.out.println(c1);                       // toString()
        System.out.println("Area c1: " + c1.calcularArea());
        System.out.println("Area c2: " + c2.calcularArea());
    }
}


class Circulotest {
    private double radio;          // atributo encapsulado
    private String color;

    public Circulotest(double radio, String color) {   // constructor
        this.radio = radio;
        this.color = color;
    }

    public double calcularArea()      { return Math.PI * radio * radio; }
    public double calcularPerimetro() { return 2 * Math.PI * radio;     }

    @Override
    public String toString() {
        return "Circulo[radio=" + radio + ", color=" + color + "]";
    }
}