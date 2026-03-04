// CÓDIGO CON ERRORES PARA QUE EL ALUMNO CORRIJA
public class errores2 {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3};
        System.out.println(numeros[5]); // Error 1: Fuera de límites
        
        int resultado = 10 / 0; // Error 2: División por cero
        
        validarEdad(-5); // Error 3: Lógica negativa
    }

    public static void validarEdad(int edad) {
        if (edad < 0) {
            System.out.println("Edad inválida"); 
            // Error 4: Debería lanzar una excepción, no solo imprimir
        }
    }
}
