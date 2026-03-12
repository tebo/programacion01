package POO;
public class circulo {
    static double calcularArea(double radio) {
        return Math.PI * radio * radio;
    }
    static double calcularPerimetro(double radio) {
        return 2 * Math.PI * radio;
    }
    public static void main(String[] args) {
        double radio = 5.0;
        System.out.println("Area: " + calcularArea(radio));
        System.out.println("Perimetro: " + calcularPerimetro(radio));
    }
}
