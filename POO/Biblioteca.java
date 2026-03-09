/**
 * Programa 4: Integración de Conceptos
 * Demuestra: Múltiples métodos, manejo de colecciones y lógica compleja
 */

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Atributos
    private String nombre;
    private List<Libro> libros;

    // Clase interna para representar Libros
    public static class Libro {
        private String titulo;
        private String autor;
        private int anio;
        private double precio;
        private boolean disponible;

        // Constructor
        public Libro(String titulo, String autor, int anio, double precio) {
            this.titulo = titulo;
            this.autor = autor;
            this.anio = anio;
            this.precio = precio;
            this.disponible = true;
        }

        // Getters
        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public int getAnio() {
            return anio;
        }

        public double getPrecio() {
            return precio;
        }

        public boolean isDisponible() {
            return disponible;
        }

        // Método para prestar un libro
        public void prestar() {
            if (disponible) {
                disponible = false;
            }
        }

        // Método para devolver un libro
        public void devolver() {
            disponible = true;
        }

        // Método para mostrar información del libro
        public void mostrarInfo() {
            System.out.println("  → " + titulo + " (" + anio + ")");
            System.out.println("    Autor: " + autor);
            System.out.println("    Precio: $" + precio);
            System.out.println("    Estado: " + (disponible ? "Disponible" : "Ocupado"));
        }
    }

    // Constructor de la biblioteca
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    // Método para agregar un libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("✓ Libro '" + libro.getTitulo() + "' agregado a la biblioteca");
    }

    // Método para contar libros disponibles
    public int contarLibrosDisponibles() {
        int cantidad = 0;
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    // Método para buscar un libro por título
    public Libro buscarPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    // Método para listar todos los libros
    public void listarTodosLosLibros() {
        System.out.println("\n--- Libros en " + nombre + " ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca");
        } else {
            for (int i = 0; i < libros.size(); i++) {
                System.out.println((i + 1) + ". ");
                libros.get(i).mostrarInfo();
            }
        }
        System.out.println("Total de libros: " + libros.size());
        System.out.println("Libros disponibles: " + contarLibrosDisponibles());
        System.out.println("-----------------------------------");
    }

    // Método para listar solo libros disponibles
    public void listarLibrosDisponibles() {
        System.out.println("\n--- Libros Disponibles ---");
        int contador = 0;
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                contador++;
                System.out.println(contador + ". ");
                libro.mostrarInfo();
            }
        }
        if (contador == 0) {
            System.out.println("No hay libros disponibles");
        }
        System.out.println("---------------------------");
    }

    // Método para calcular el valor total de la biblioteca
    public double calcularValorTotal() {
        double valor = 0;
        for (Libro libro : libros) {
            valor += libro.getPrecio();
        }
        return valor;
    }

    // Método para prestar un libro
    public void prestarLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        if (libro != null) {
            if (libro.isDisponible()) {
                libro.prestar();
                System.out.println("✓ Libro '" + titulo + "' prestado exitosamente");
            } else {
                System.out.println("✗ El libro '" + titulo + "' no está disponible");
            }
        } else {
            System.out.println("✗ El libro '" + titulo + "' no fue encontrado");
        }
    }

    // Método para devolver un libro
    public void devolverLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        if (libro != null) {
            libro.devolver();
            System.out.println("✓ Libro '" + titulo + "' devuelto exitosamente");
        } else {
            System.out.println("✗ El libro '" + titulo + "' no fue encontrado");
        }
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        // Crear una biblioteca
        Biblioteca biblio = new Biblioteca("Biblioteca Municipal");

        // Agregar libros
        biblio.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", 1605, 25.99));
        biblio.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 22.50));
        biblio.agregarLibro(new Libro("Don Juan Tenorio", "José Zorrilla", 1844, 18.75));
        biblio.agregarLibro(new Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001, 19.99));

        // Mostrar información
        biblio.listarTodosLosLibros();
        biblio.listarLibrosDisponibles();

        System.out.println("Valor total de la biblioteca: $" + biblio.calcularValorTotal());

        // Prestar libros
        System.out.println("\n--- Operaciones de Préstamo ---");
        biblio.prestarLibro("El Quijote");
        biblio.prestarLibro("Cien años de soledad");

        biblio.listarLibrosDisponibles();

        // Devolver un libro
        System.out.println("\n--- Devolución ---");
        biblio.devolverLibro("El Quijote");
        biblio.listarLibrosDisponibles();
    }
}
