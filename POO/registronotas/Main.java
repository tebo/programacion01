package POO.registronotas;

import java.util.Scanner;

/**
 * Clase principal que proporciona una interfaz interactiva
 * para el registro de notas de alumnos
 */
public class Main {
    private static RegistroNotas registro;
    private static Scanner scanner;

    public static void main(String[] args) {
        registro = new RegistroNotas();
        scanner = new Scanner(System.in);

        // Cargar datos de ejemplo
        cargarDatos();

        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerEntero();

            switch (opcion) {
                case 1:
                    menuAlumnos();
                    break;
                case 2:
                    menuMaterias();
                    break;
                case 3:
                    menuNotas();
                    break;
                case 4:
                    menuReportes();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("SISTEMA DE REGISTRO DE NOTAS");
        System.out.println("=".repeat(50));
        System.out.println("1. Gestionar Alumnos");
        System.out.println("2. Gestionar Materias");
        System.out.println("3. Registrar/Modificar Notas");
        System.out.println("4. Ver Reportes");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void menuAlumnos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE ALUMNOS ---");
            System.out.println("1. Registrar nuevo alumno");
            System.out.println("2. Ver todos los alumnos");
            System.out.println("3. Volver");
            System.out.print("Opción: ");

            int opcion = leerEntero();
            switch (opcion) {
                case 1:
                    registrarAlumno();
                    break;
                case 2:
                    verAlumnos();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void registrarAlumno() {
        System.out.print("ID del alumno: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        try {
            registro.registrarAlumno(id, nombre, email);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verAlumnos() {
        System.out.println("\n--- LISTA DE ALUMNOS ---");
        if (registro.obtenerTodosAlumnos().isEmpty()) {
            System.out.println("No hay alumnos registrados");
        } else {
            for (Alumno alumno : registro.obtenerTodosAlumnos()) {
                System.out.println(alumno);
            }
        }
    }

    private static void menuMaterias() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE MATERIAS ---");
            System.out.println("1. Registrar nueva materia");
            System.out.println("2. Ver todas las materias");
            System.out.println("3. Volver");
            System.out.print("Opción: ");

            int opcion = leerEntero();
            switch (opcion) {
                case 1:
                    registrarMateria();
                    break;
                case 2:
                    verMaterias();
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void registrarMateria() {
        System.out.print("Código de la materia: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Créditos: ");
        int creditos = leerEntero();

        System.out.print("Docente: ");
        String docente = scanner.nextLine();

        try {
            registro.registrarMateria(codigo, nombre, creditos, docente);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verMaterias() {
        System.out.println("\n--- LISTA DE MATERIAS ---");
        if (registro.obtenerTodasMaterias().isEmpty()) {
            System.out.println("No hay materias registradas");
        } else {
            for (Materia materia : registro.obtenerTodasMaterias()) {
                System.out.println(materia);
            }
        }
    }

    private static void menuNotas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- REGISTRO DE NOTAS ---");
            System.out.println("1. Registrar notas para un alumno");
            System.out.println("2. Ver notas de un alumno");
            System.out.println("3. Modificar nota de un parcial");
            System.out.println("4. Volver");
            System.out.print("Opción: ");

            int opcion = leerEntero();
            switch (opcion) {
                case 1:
                    registrarNotas();
                    break;
                case 2:
                    verNotasAlumno();
                    break;
                case 3:
                    modificarNota();
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void registrarNotas() {
        System.out.print("ID del alumno: ");
        String idAlumno = scanner.nextLine();

        if (!registro.existeAlumno(idAlumno)) {
            System.out.println("El alumno no existe");
            return;
        }

        System.out.print("Código de la materia: ");
        String codigoMateria = scanner.nextLine();

        if (!registro.existeMateria(codigoMateria)) {
            System.out.println("La materia no existe");
            return;
        }

        System.out.print("Nota Parcial 1 (0-100): ");
        double p1 = leerDouble();

        System.out.print("Nota Parcial 2 (0-100): ");
        double p2 = leerDouble();

        System.out.print("Nota Parcial 3 (0-100): ");
        double p3 = leerDouble();

        try {
            registro.registrarNotas(idAlumno, codigoMateria, p1, p2, p3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void verNotasAlumno() {
        System.out.print("ID del alumno: ");
        String idAlumno = scanner.nextLine();

        registro.generarReporteAlumno(idAlumno);
    }

    private static void modificarNota() {
        System.out.print("ID del alumno: ");
        String idAlumno = scanner.nextLine();

        Alumno alumno = registro.obtenerAlumno(idAlumno);
        if (alumno == null) {
            System.out.println("El alumno no existe");
            return;
        }

        System.out.print("Código de la materia: ");
        String codigoMateria = scanner.nextLine();

        if (!alumno.tieneNota(codigoMateria)) {
            System.out.println("No hay notas registradas para esta materia");
            return;
        }

        Nota nota = alumno.obtenerNota(codigoMateria);
        System.out.println("\nNotas actuales:");
        System.out.println("1. Parcial 1: " + nota.getParcial1());
        System.out.println("2. Parcial 2: " + nota.getParcial2());
        System.out.println("3. Parcial 3: " + nota.getParcial3());
        System.out.print("¿Cuál desea modificar? ");

        int parcial = leerEntero();
        System.out.print("Nueva nota (0-100): ");
        double nuevaNota = leerDouble();

        try {
            switch (parcial) {
                case 1:
                    nota.setParcial1(nuevaNota);
                    System.out.println("✓ Parcial 1 actualizado");
                    break;
                case 2:
                    nota.setParcial2(nuevaNota);
                    System.out.println("✓ Parcial 2 actualizado");
                    break;
                case 3:
                    nota.setParcial3(nuevaNota);
                    System.out.println("✓ Parcial 3 actualizado");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void menuReportes() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- REPORTES ---");
            System.out.println("1. Reporte de calificaciones de un alumno");
            System.out.println("2. Reporte general de todos los alumnos");
            System.out.println("3. Estadísticas de una materia");
            System.out.println("4. Volver");
            System.out.print("Opción: ");

            int opcion = leerEntero();
            switch (opcion) {
                case 1:
                    reporteAlumno();
                    break;
                case 2:
                    registro.generarReporteGeneral();
                    break;
                case 3:
                    reporteMateria();
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static void reporteAlumno() {
        System.out.print("ID del alumno: ");
        String idAlumno = scanner.nextLine();
        registro.generarReporteAlumno(idAlumno);
    }

    private static void reporteMateria() {
        System.out.print("Código de la materia: ");
        String codigoMateria = scanner.nextLine();
        registro.generarEstadisticasMateria(codigoMateria);
    }

    // Métodos auxiliares para lectura
    private static int leerEntero() {
        try {
            int valor = Integer.parseInt(scanner.nextLine());
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido");
            return -1;
        }
    }

    private static double leerDouble() {
        try {
            double valor = Double.parseDouble(scanner.nextLine());
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido");
            return -1;
        }
    }

    /**
     * Carga datos de ejemplo para demostración
     */
    private static void cargarDatos() {
        System.out.println("Cargando datos de ejemplo...\n");

        // Registrar alumnos
        registro.registrarAlumno("001", "Juan Pérez", "juan@email.com");
        registro.registrarAlumno("002", "María García", "maria@email.com");
        registro.registrarAlumno("003", "Carlos López", "carlos@email.com");

        // Registrar materias
        registro.registrarMateria("MAT101", "Matemáticas", 4, "Dr. García");
        registro.registrarMateria("FIS102", "Física", 4, "Dra. López");
        registro.registrarMateria("PRG103", "Programación", 3, "Ing. Martínez");

        // Registrar notas
        registro.registrarNotas("001", "MAT101", 85, 78, 88);
        registro.registrarNotas("001", "FIS102", 75, 72, 70);
        registro.registrarNotas("001", "PRG103", 90, 92, 95);

        registro.registrarNotas("002", "MAT101", 65, 70, 68);
        registro.registrarNotas("002", "FIS102", 88, 85, 90);
        registro.registrarNotas("002", "PRG103", 78, 82, 80);

        registro.registrarNotas("003", "MAT101", 92, 95, 94);
        registro.registrarNotas("003", "FIS102", 60, 65, 62);
        registro.registrarNotas("003", "PRG103", 88, 86, 90);

        System.out.println("\n✓ Datos de ejemplo cargados exitosamente\n");
    }
}
