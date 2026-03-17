// Ejemplo básico de Programación Orientada a Objetos en Java
// Este ejemplo demuestra los conceptos fundamentales: clases, objetos, encapsulamiento, herencia y polimorfismo

import java.util.Scanner;
import java.util.InputMismatchException;

// Clase base: Animal
class Animal {
    // Atributos encapsulados (privados)
    private String nombre;
    private int edad;

    // Constructor
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y setters para encapsulamiento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método que puede ser sobrescrito (polimorfismo)
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }

    // Método común
    public void dormir() {
        System.out.println(nombre + " está durmiendo");
    }
}

// Clase derivada: Perro (herencia)
class Perro extends Animal {
    private String raza;

    // Constructor que llama al constructor de la clase base
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    // Sobrescritura del método hacerSonido (polimorfismo)
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Guau guau!");
    }

    // Método específico de Perro
    public void moverCola() {
        System.out.println(getNombre() + " mueve la cola");
    }
}

// Clase derivada: Gato (herencia)
class Gato extends Animal {
    private String color;

    // Constructor
    public Gato(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Sobrescritura del método hacerSonido (polimorfismo)
    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Miau miau!");
    }

    // Método específico de Gato
    public void ronronear() {
        System.out.println(getNombre() + " está ronroneando");
    }
}

// Clase principal con el método main
public class EjemploPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Ejemplo Interactivo de Programación Orientada a Objetos ===\n");

        // Interacción para crear un Perro
        System.out.println("Vamos a crear un perro:");

        // Validación del nombre del perro
        String nombrePerro;
        do {
            System.out.print("Ingresa el nombre del perro (no vacío): ");
            nombrePerro = scanner.nextLine().trim();
            if (nombrePerro.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío. Inténtalo de nuevo.");
            }
        } while (nombrePerro.isEmpty());

        // Validación de la edad del perro
        int edadPerro = -1;
        do {
            System.out.print("Ingresa la edad del perro (número entero positivo): ");
            try {
                edadPerro = scanner.nextInt();
                if (edadPerro <= 0) {
                    System.out.println("Error: La edad debe ser un número positivo. Inténtalo de nuevo.");
                    edadPerro = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero. Inténtalo de nuevo.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (edadPerro <= 0);
        scanner.nextLine(); // Consumir el salto de línea

        // Validación de la raza del perro
        String razaPerro;
        do {
            System.out.print("Ingresa la raza del perro (no vacío): ");
            razaPerro = scanner.nextLine().trim();
            if (razaPerro.isEmpty()) {
                System.out.println("Error: La raza no puede estar vacía. Inténtalo de nuevo.");
            }
        } while (razaPerro.isEmpty());

        Perro miPerro = new Perro(nombrePerro, edadPerro, razaPerro);

        // Interacción para crear un Gato
        System.out.println("\nAhora vamos a crear un gato:");

        // Validación del nombre del gato
        String nombreGato;
        do {
            System.out.print("Ingresa el nombre del gato (no vacío): ");
            nombreGato = scanner.nextLine().trim();
            if (nombreGato.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío. Inténtalo de nuevo.");
            }
        } while (nombreGato.isEmpty());

        // Validación de la edad del gato
        int edadGato = -1;
        do {
            System.out.print("Ingresa la edad del gato (número entero positivo): ");
            try {
                edadGato = scanner.nextInt();
                if (edadGato <= 0) {
                    System.out.println("Error: La edad debe ser un número positivo. Inténtalo de nuevo.");
                    edadGato = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número entero. Inténtalo de nuevo.");
                scanner.nextLine(); // Limpiar el buffer
            }
        } while (edadGato <= 0);
        scanner.nextLine(); // Consumir el salto de línea

        // Validación del color del gato
        String colorGato;
        do {
            System.out.print("Ingresa el color del gato (no vacío): ");
            colorGato = scanner.nextLine().trim();
            if (colorGato.isEmpty()) {
                System.out.println("Error: El color no puede estar vacío. Inténtalo de nuevo.");
            }
        } while (colorGato.isEmpty());

        Gato miGato = new Gato(nombreGato, edadGato, colorGato);

        // Uso de métodos comunes (herencia)
        System.out.println("\nInformación de los animales:");
        System.out.println("Perro: " + miPerro.getNombre() + ", Edad: " + miPerro.getEdad() + ", Raza: " + miPerro.getRaza());
        System.out.println("Gato: " + miGato.getNombre() + ", Edad: " + miGato.getEdad() + ", Color: " + miGato.getColor());
        System.out.println();

        // Polimorfismo: el mismo método hace cosas diferentes
        System.out.println("Sonidos de los animales:");
        miPerro.hacerSonido();
        miGato.hacerSonido();
        System.out.println();

        // Métodos específicos
        System.out.println("Acciones específicas:");
        miPerro.moverCola();
        miGato.ronronear();
        System.out.println();

        // Método común a todos los animales
        System.out.println("Todos los animales duermen:");
        miPerro.dormir();
        miGato.dormir();
        System.out.println();

        // Demostración de encapsulamiento: cambiando valores con setters
        String respuesta;
        do {
            System.out.print("¿Quieres cambiar la edad del perro? (sí/no): ");
            respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("sí") && !respuesta.equals("si") && !respuesta.equals("no")) {
                System.out.println("Error: Responde 'sí' o 'no'. Inténtalo de nuevo.");
            }
        } while (!respuesta.equals("sí") && !respuesta.equals("si") && !respuesta.equals("no"));

        if (respuesta.equals("sí") || respuesta.equals("si")) {
            int nuevaEdad = -1;
            do {
                System.out.print("Ingresa la nueva edad del perro (número entero positivo): ");
                try {
                    nuevaEdad = scanner.nextInt();
                    if (nuevaEdad <= 0) {
                        System.out.println("Error: La edad debe ser un número positivo. Inténtalo de nuevo.");
                        nuevaEdad = -1;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Debes ingresar un número entero. Inténtalo de nuevo.");
                    scanner.nextLine(); // Limpiar el buffer
                }
            } while (nuevaEdad <= 0);
            miPerro.setEdad(nuevaEdad);
            System.out.println("Nueva edad del perro: " + miPerro.getEdad());
        }
        System.out.println();

        // Uso de polimorfismo con referencias de la clase base
        System.out.println("Polimorfismo con referencias de tipo Animal:");
        Animal animal1 = miPerro;  // Referencia de tipo Animal apuntando a un Perro
        Animal animal2 = miGato;   // Referencia de tipo Animal apuntando a un Gato

        animal1.hacerSonido();  // Llama al método sobrescrito de Perro
        animal2.hacerSonido();  // Llama al método sobrescrito de Gato

        System.out.println("\n=== Fin del ejemplo ===");
        scanner.close();
    }
}