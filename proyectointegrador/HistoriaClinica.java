package proyectointegrador;

import java.util.Scanner;

public class HistoriaClinica {
    // Matrices para almacenar información
    static final int MAX_PACIENTES = 10;
    static final int MAX_CONSULTAS = 5;
    
    static String[] nombresPacientes = new String[MAX_PACIENTES];
    static String[][] consultas = new String[MAX_PACIENTES][MAX_CONSULTAS];
    static double[][] pagos = new double[MAX_PACIENTES][MAX_CONSULTAS];
    static int[] numConsultas = new int[MAX_PACIENTES]; // Número de consultas por paciente
    static int numPacientes = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n=== Sistema de Historia Clínica ===");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Registrar consulta y pago");
            System.out.println("3. Mostrar historial de paciente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            switch (opcion) {
                case 1:
                    agregarPaciente(scanner);
                    break;
                case 2:
                    registrarConsulta(scanner);
                    break;
                case 3:
                    mostrarHistorial(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
        
        scanner.close();
    }
    
    // Método para agregar un paciente
    public static void agregarPaciente(Scanner scanner) {
        if (numPacientes >= MAX_PACIENTES) {
            System.out.println("No se pueden agregar más pacientes. Límite alcanzado.");
            return;
        }
        
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine();
        nombresPacientes[numPacientes] = nombre;
        numConsultas[numPacientes] = 0;
        numPacientes++;
        System.out.println("Paciente agregado exitosamente.");
    }
    
    // Método para registrar una consulta y pago
    public static void registrarConsulta(Scanner scanner) {
        if (numPacientes == 0) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        
        System.out.println("Pacientes registrados:");
        for (int i = 0; i < numPacientes; i++) {
            System.out.println((i + 1) + ". " + nombresPacientes[i]);
        }
        
        System.out.print("Seleccione el número del paciente: ");
        int pacienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir salto de línea
        
        if (pacienteIndex < 0 || pacienteIndex >= numPacientes) {
            System.out.println("Paciente inválido.");
            return;
        }
        
        if (numConsultas[pacienteIndex] >= MAX_CONSULTAS) {
            System.out.println("No se pueden agregar más consultas para este paciente.");
            return;
        }
        
        System.out.print("Ingrese la descripción de la consulta: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Ingrese el pago por la consulta: ");
        double pago = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea
        
        int consultaIndex = numConsultas[pacienteIndex];
        consultas[pacienteIndex][consultaIndex] = descripcion;
        pagos[pacienteIndex][consultaIndex] = pago;
        numConsultas[pacienteIndex]++;
        
        System.out.println("Consulta registrada exitosamente.");
    }
    
    // Método para mostrar el historial de un paciente
    public static void mostrarHistorial(Scanner scanner) {
        if (numPacientes == 0) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        
        System.out.println("Pacientes registrados:");
        for (int i = 0; i < numPacientes; i++) {
            System.out.println((i + 1) + ". " + nombresPacientes[i]);
        }
        
        System.out.print("Seleccione el número del paciente: ");
        int pacienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir salto de línea
        
        if (pacienteIndex < 0 || pacienteIndex >= numPacientes) {
            System.out.println("Paciente inválido.");
            return;
        }
        
        System.out.println("\nHistorial de " + nombresPacientes[pacienteIndex] + ":");
        if (numConsultas[pacienteIndex] == 0) {
            System.out.println("No hay consultas registradas.");
        } else {
            double totalPagos = 0;
            for (int i = 0; i < numConsultas[pacienteIndex]; i++) {
                System.out.println("Consulta " + (i + 1) + ": " + consultas[pacienteIndex][i] + " - Pago: $" + pagos[pacienteIndex][i]);
                totalPagos += pagos[pacienteIndex][i];
            }
            System.out.println("Total pagado: $" + totalPagos);
        }
    }
}
