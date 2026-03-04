public class ejemplothrow {
    
    // Método que lanza una excepción
    public static int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return dividendo / divisor;
    }
    
    // Método que valida la edad
    public static void verificarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (edad < 18) {
            throw new IllegalArgumentException("Debes ser mayor de 18 años");
        }
        System.out.println("Edad válida: " + edad + " años");
    }
    
    // Método que lanza excepción personalizada
    public static void procesarCalificacion(float calificacion) {
        if (calificacion < 0 || calificacion > 100) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 100");
        }
        System.out.println("Calificación procesada: " + calificacion);
    }
    
    // Método que realiza operaciones con throw
    public static String obtenerNombre(String[] nombres, int indice) {
        if (indice < 0 || indice >= nombres.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return nombres[indice];
    }
    
    public static void main(String[] args) {
        
        System.out.println("=== EJEMPLOS DE USO DE THROW EN JAVA ===\n");
        
        // Ejemplo 1: División por cero
        System.out.println("--- Ejemplo 1: División por cero ---");
        try {
            int resultado = dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 2: División válida
        System.out.println("--- Ejemplo 2: División válida ---");
        try {
            int resultado = dividir(20, 4);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 3: Validación de edad - edad negativa
        System.out.println("--- Ejemplo 3: Validación de edad (negativa) ---");
        try {
            verificarEdad(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 4: Validación de edad - menor de edad
        System.out.println("--- Ejemplo 4: Validación de edad (menor de edad) ---");
        try {
            verificarEdad(16);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 5: Validación de edad - edad válida
        System.out.println("--- Ejemplo 5: Validación de edad (válida) ---");
        try {
            verificarEdad(25);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 6: Calificación inválida
        System.out.println("--- Ejemplo 6: Calificación inválida ---");
        try {
            procesarCalificacion(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 7: Calificación válida
        System.out.println("--- Ejemplo 7: Calificación válida ---");
        try {
            procesarCalificacion(85.5f);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 8: Acceso a índice válido
        System.out.println("--- Ejemplo 8: Acceso a índice válido ---");
        String[] nombres = {"Ana", "Bruno", "Carlos", "Diana"};
        try {
            String nombre = obtenerNombre(nombres, 2);
            System.out.println("Nombre encontrado: " + nombre);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 9: Acceso a índice inválido
        System.out.println("--- Ejemplo 9: Acceso a índice inválido ---");
        try {
            String nombre = obtenerNombre(nombres, 10);
            System.out.println("Nombre encontrado: " + nombre);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
        System.out.println();
        
        // Ejemplo 10: Múltiples excepciones
        System.out.println("--- Ejemplo 10: Manejo de múltiples excepciones ---");
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Error: El texto no es un número válido");
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
        
        System.out.println("\n=== FIN DE LOS EJEMPLOS ===");
    }
}
