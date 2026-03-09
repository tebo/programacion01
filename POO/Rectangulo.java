/**
 * Programa 3: Métodos Complejos y Cálculos
 * Demuestra: Métodos que devuelven valores, cálculos y lógica de negocio
 */

public class Rectangulo {
    // Atributos
    private double ancho;
    private double alto;

    // Constructor
    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    // Getters
    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    // Setters con validación
    public void setAncho(double ancho) {
        if (ancho > 0) {
            this.ancho = ancho;
        } else {
            System.out.println("Error: El ancho debe ser mayor a 0");
        }
    }

    public void setAlto(double alto) {
        if (alto > 0) {
            this.alto = alto;
        } else {
            System.out.println("Error: El alto debe ser mayor a 0");
        }
    }

    // Método para calcular el área
    public double calcularArea() {
        return ancho * alto;
    }

    // Método para calcular el perímetro
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }

    // Método para calcular la diagonal
    public double calcularDiagonal() {
        return Math.sqrt(ancho * ancho + alto * alto);
    }

    // Método para verificar si es un cuadrado
    public boolean esUnCuadrado() {
        return ancho == alto;
    }

    // Método para comparar áreas de dos rectángulos
    public int compararArea(Rectangulo otro) {
        double area1 = this.calcularArea();
        double area2 = otro.calcularArea();

        if (area1 > area2) {
            return 1; // Este rectángulo es más grande
        } else if (area1 < area2) {
            return -1; // El otro rectángulo es más grande
        } else {
            return 0; // Tienen la misma área
        }
    }

    // Método para mostrar información del rectángulo
    public void mostrarInfo() {
        System.out.println("\n--- Información del Rectángulo ---");
        System.out.println("Ancho: " + ancho);
        System.out.println("Alto: " + alto);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
        System.out.println("Diagonal: " + String.format("%.2f", calcularDiagonal()));
        System.out.println("¿Es un cuadrado? " + (esUnCuadrado() ? "Sí" : "No"));
        System.out.println("----------------------------------");
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear rectángulos
        Rectangulo rect1 = new Rectangulo(5, 3);
        Rectangulo rect2 = new Rectangulo(4, 4);
        Rectangulo rect3 = new Rectangulo(6, 2);

        // Mostrar información
        rect1.mostrarInfo();
        rect2.mostrarInfo();
        rect3.mostrarInfo();

        // Comparar áreas
        System.out.println("--- Comparación de Áreas ---");
        int comparacion = rect1.compararArea(rect2);
        if (comparacion > 0) {
            System.out.println("Rect1 (ancho: " + rect1.getAncho() + ", alto: " + rect1.getAlto() + ") tiene mayor área");
        } else if (comparacion < 0) {
            System.out.println("Rect2 (ancho: " + rect2.getAncho() + ", alto: " + rect2.getAlto() + ") tiene mayor área");
        } else {
            System.out.println("Rect1 y Rect2 tienen la misma área");
        }

        comparacion = rect1.compararArea(rect3);
        if (comparacion > 0) {
            System.out.println("Rect1 tiene mayor área que Rect3");
        } else if (comparacion < 0) {
            System.out.println("Rect3 tiene mayor área que Rect1");
        }
    }
}
