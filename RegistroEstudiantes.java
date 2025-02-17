import java.util.Scanner;

public class RegistroEstudiantes {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // Preguntar cuántos estudiantes se van a registrar
        System.out.print("¿Cuántos estudiantes desea registrar? ");
        int numEstudiantes = teclado.nextInt();
        teclado.nextLine(); // Limpiar el buffer
        
        // Arrays para almacenar los datos
        String[] nombres = new String[numEstudiantes];
        int[] edades = new int[numEstudiantes];
        double[] calificaciones = new double[numEstudiantes];
        
        // Ciclo for para pedir los datos
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("\n--- Datos del estudiante " + (i + 1) + " ---");
            
            System.out.print("Nombre: ");
            nombres[i] = teclado.nextLine();
            
            System.out.print("Edad: ");
            edades[i] = teclado.nextInt();
            
            System.out.print("Calificación: ");
            calificaciones[i] = teclado.nextDouble();
            teclado.nextLine(); // Limpiar el buffer
        }
        
        // Mostrar todos los datos ingresados
        System.out.println("\n=== Registro de Estudiantes ===");
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Edad: " + edades[i]);
            System.out.println("Calificación: " + calificaciones[i]);
        }
        
        // Calcular y mostrar promedio de calificaciones
        double sumaCalificaciones = 0;
        for (double calificacion : calificaciones) {
            sumaCalificaciones += calificacion;
        }
        double promedio = sumaCalificaciones / numEstudiantes;
        System.out.println("\nPromedio de calificaciones: " + promedio);
        
        teclado.close();
    }
}