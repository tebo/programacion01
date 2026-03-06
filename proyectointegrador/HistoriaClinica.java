package proyectointegrador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HistoriaClinica {
    // Matrices para almacenar información
    static final int MAX_PACIENTES = 10;
    static final int MAX_CONSULTAS = 5;
    
    static String[] nombresPacientes = new String[MAX_PACIENTES];
    static String[][] consultas = new String[MAX_PACIENTES][MAX_CONSULTAS];
    static String[][] diagnosticos = new String[MAX_PACIENTES][MAX_CONSULTAS];
    static double[][] pagos = new double[MAX_PACIENTES][MAX_CONSULTAS];
    static int[] numConsultas = new int[MAX_PACIENTES]; // Número de consultas por paciente
    static int numPacientes = 0;
    
    // Lista de medicamentos con precios
    static String[] medicamentos = {"Paracetamol", "Ibuprofeno", "Aspirina", "Amoxicilina"};
    static double[] preciosMedicamentos = {5.0, 7.5, 4.0, 10.0};
    static String[][] medicamentosPorConsulta = new String[MAX_PACIENTES][MAX_CONSULTAS];
    static double[][] costoMedicamentos = new double[MAX_PACIENTES][MAX_CONSULTAS];
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║    Bienvenido al Sistema de Historia Clínica    ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        
        do {
            mostrarMenu();
            try {
                System.out.print("Seleccione una opción (1-4): ");
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
                        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción entre 1 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = 0; // Para continuar el bucle
            }
        } while (opcion != 4);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║        Menú Principal                      ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ 1. Agregar paciente                        ║");
        System.out.println("║ 2. Registrar consulta y pago               ║");
        System.out.println("║ 3. Mostrar historial de paciente           ║");
        System.out.println("║ 4. Salir                                   ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
    // Método para agregar un paciente
    public static void agregarPaciente(Scanner scanner) {
        if (numPacientes >= MAX_PACIENTES) {
            System.out.println("❌ Error: No se pueden agregar más pacientes. Límite de " + MAX_PACIENTES + " alcanzado.");
            return;
        }
        
        System.out.print("👤 Ingrese el nombre del paciente: ");
        String nombre = scanner.nextLine().trim();
        
        if (nombre.isEmpty()) {
            System.out.println("❌ Error: El nombre no puede estar vacío.");
            return;
        }
        
        // Verificar si el paciente ya existe
        for (int i = 0; i < numPacientes; i++) {
            if (nombresPacientes[i].equalsIgnoreCase(nombre)) {
                System.out.println("❌ Error: Ya existe un paciente con ese nombre.");
                return;
            }
        }
        
        nombresPacientes[numPacientes] = nombre;
        numConsultas[numPacientes] = 0;
        numPacientes++;
        System.out.println("✅ Paciente '" + nombre + "' agregado exitosamente.");
    }
    
    // Método para registrar una consulta y pago
    public static void registrarConsulta(Scanner scanner) {
        if (numPacientes == 0) {
            System.out.println("❌ Error: No hay pacientes registrados. Agregue un paciente primero.");
            return;
        }
        
        System.out.println("\n📋 Pacientes registrados:");
        for (int i = 0; i < numPacientes; i++) {
            System.out.println("  " + (i + 1) + ". " + nombresPacientes[i]);
        }
        
        System.out.print("👤 Seleccione el número del paciente (1-" + numPacientes + "): ");
        int pacienteIndex;
        try {
            pacienteIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir salto de línea
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: Entrada inválida. Ingrese un número.");
            scanner.nextLine();
            return;
        }
        
        if (pacienteIndex < 0 || pacienteIndex >= numPacientes) {
            System.out.println("❌ Error: Número de paciente inválido.");
            return;
        }
        
        if (numConsultas[pacienteIndex] >= MAX_CONSULTAS) {
            System.out.println("❌ Error: No se pueden agregar más consultas para este paciente. Límite de " + MAX_CONSULTAS + " alcanzado.");
            return;
        }
        
        System.out.print("📝 Ingrese la descripción de la consulta: ");
        String descripcion = scanner.nextLine().trim();
        
        if (descripcion.isEmpty()) {
            System.out.println("❌ Error: La descripción no puede estar vacía.");
            return;
        }
        
        System.out.print("🔍 Ingrese el diagnóstico detallado: ");
        String diagnostico = scanner.nextLine().trim();
        
        if (diagnostico.isEmpty()) {
            System.out.println("❌ Error: El diagnóstico no puede estar vacío.");
            return;
        }
        
        System.out.print("💰 Ingrese el pago por la consulta: ");
        double pago;
        try {
            pago = scanner.nextDouble();
            scanner.nextLine(); // Consumir salto de línea
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: Entrada inválida. Ingrese un número válido para el pago.");
            scanner.nextLine();
            return;
        }
        
        if (pago < 0) {
            System.out.println("❌ Error: El pago no puede ser negativo.");
            return;
        }
        
        int consultaIndex = numConsultas[pacienteIndex];
        consultas[pacienteIndex][consultaIndex] = descripcion;
        diagnosticos[pacienteIndex][consultaIndex] = diagnostico;
        pagos[pacienteIndex][consultaIndex] = pago;
        
        // Opcional: Agregar medicamentos
        System.out.print("💊 ¿Desea agregar medicamentos? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        double costoMeds = 0;
        StringBuilder medsList = new StringBuilder();
        
        if (respuesta.equals("s") || respuesta.equals("si")) {
            System.out.println("\n💊 Medicamentos disponibles:");
            for (int i = 0; i < medicamentos.length; i++) {
                System.out.println("  " + (i + 1) + ". " + medicamentos[i] + " - $" + preciosMedicamentos[i]);
            }
            
            while (true) {
                System.out.print("Seleccione medicamento (número, 0 para terminar): ");
                try {
                    int medIndex = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (medIndex == -1) break;
                    if (medIndex < 0 || medIndex >= medicamentos.length) {
                        System.out.println("❌ Opción inválida. Intente nuevamente.");
                        continue;
                    }
                    costoMeds += preciosMedicamentos[medIndex];
                    if (medsList.length() > 0) medsList.append(", ");
                    medsList.append(medicamentos[medIndex]);
                    System.out.println("✅ " + medicamentos[medIndex] + " agregado.");
                } catch (InputMismatchException e) {
                    System.out.println("❌ Entrada inválida. Ingrese un número.");
                    scanner.nextLine();
                }
            }
        }
        
        costoMedicamentos[pacienteIndex][consultaIndex] = costoMeds;
        medicamentosPorConsulta[pacienteIndex][consultaIndex] = medsList.toString();
        
        numConsultas[pacienteIndex]++;
        
        System.out.println("✅ Consulta registrada exitosamente para " + nombresPacientes[pacienteIndex] + ".");
    }
    
    // Método para mostrar el historial de un paciente
    public static void mostrarHistorial(Scanner scanner) {
        if (numPacientes == 0) {
            System.out.println("❌ Error: No hay pacientes registrados.");
            return;
        }
        
        System.out.println("\n📋 Pacientes registrados:");
        for (int i = 0; i < numPacientes; i++) {
            System.out.println("  " + (i + 1) + ". " + nombresPacientes[i]);
        }
        
        System.out.print("👤 Seleccione el número del paciente para ver su historial (1-" + numPacientes + "): ");
        int pacienteIndex;
        try {
            pacienteIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Consumir salto de línea
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: Entrada inválida. Ingrese un número.");
            scanner.nextLine();
            return;
        }
        
        if (pacienteIndex < 0 || pacienteIndex >= numPacientes) {
            System.out.println("❌ Error: Número de paciente inválido.");
            return;
        }
        
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║    Historial de " + String.format("%-25s", nombresPacientes[pacienteIndex]) + "║");
        System.out.println("╚══════════════════════════════════════╝");
        
        if (numConsultas[pacienteIndex] == 0) {
            System.out.println("📝 No hay consultas registradas para este paciente.");
        } else {
            double totalPagos = 0;
            System.out.println("Consultas realizadas:");
            for (int i = 0; i < numConsultas[pacienteIndex]; i++) {
                System.out.printf("  %d. %s - Pago consulta: $%.2f%n", (i + 1), consultas[pacienteIndex][i], pagos[pacienteIndex][i]);
                System.out.println("     🔍 Diagnóstico: " + diagnosticos[pacienteIndex][i]);
                totalPagos += pagos[pacienteIndex][i];
                if (!medicamentosPorConsulta[pacienteIndex][i].isEmpty()) {
                    System.out.println("     💊 Medicamentos: " + medicamentosPorConsulta[pacienteIndex][i] + " - Costo: $" + costoMedicamentos[pacienteIndex][i]);
                    totalPagos += costoMedicamentos[pacienteIndex][i];
                }
            }
            System.out.println("────────────────────────────────────────");
            System.out.printf("💰 Total pagado: $%.2f%n", totalPagos);
        }
    }
}
