public class Coche {
    // Atributos (Estado)
    String marca;
    String color;
    int velocidad;

    // Constructor (Para inicializar el objeto)
    public Coche(String marca, String color) {
        this.marca = marca;
        this.color = color;
        this.velocidad = 0;
    }

    // Métodos (Comportamiento)
    public void acelerar() {
        velocidad += 10;
        System.out.println("El coche ha acelerado. Velocidad actual: " + velocidad + " km/h");
    }

    public void frenar() {
        velocidad = 0;
        System.out.println("El coche se ha detenido.");
    }
}