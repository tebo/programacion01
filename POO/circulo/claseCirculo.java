public class Circulo {
    private double radio;          // atributo encapsulado
    private String color;

    public Circulo(double radio, String color) {   // constructor
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

public class Main {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(5.0, "rojo");
        Circulo c2 = new Circulo(3.5, "azul");
        System.out.println(c1);                       // toString()
        System.out.println("Area c1: " + c1.calcularArea());
        System.out.println("Area c2: " + c2.calcularArea());
    }
}
