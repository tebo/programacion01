/**
 * Programa 1: Conceptos Básicos de POO
 * Demuestra: Clases, Atributos, Métodos y Constructores
 */

public class Estudiante {
    // Atributos de la clase
    private String nombre;
    private int edad;
    private double promedio;

    // Constructor - Se ejecuta al crear un objeto
    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    // Métodos para obtener información (Getters)
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        return promedio;
    }

    // Método para mostrar información del estudiante
    public void mostrarInfo() {
        System.out.println("--- Información del Estudiante ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + promedio);
    }

    // Método para verificar si el estudiante aprobó
    public boolean estaAprobado() {
        return promedio >= 6.0;
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear objetos de la clase Estudiante
        Estudiante est1 = new Estudiante("Juan Pérez", 20, 7.5);
        Estudiante est2 = new Estudiante("María García", 19, 8.2);
        Estudiante est3 = new Estudiante("Carlos López", 21, 5.8);

        // Usar los métodos de los objetos
        est1.mostrarInfo();
        System.out.println("¿Está aprobado? " + (est1.estaAprobado() ? "Sí" : "No"));
        System.out.println();

        est2.mostrarInfo();
        System.out.println("¿Está aprobado? " + (est2.estaAprobado() ? "Sí" : "No"));
        System.out.println();

        est3.mostrarInfo();
        System.out.println("¿Está aprobado? " + (est3.estaAprobado() ? "Sí" : "No"));
    }
}
