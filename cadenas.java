// ejercicios de manejo de strings
public class cadenas {
    public static void main(String[] args) {
        String nombre = "Ana";
        String apellido = "García";
        //Concatenar cadenas
        String nombreCompleto = nombre + " " + apellido;  // Ana García
    
        System.out.println(nombreCompleto);
        // Usando el método concat()
        String nombreCompleto2 = nombre.concat(" ").concat(apellido);
        System.out.println(nombreCompleto2);

        // longitud de la cadena
        int  valor = nombre.length();
        System.out.println("La longitud de la cadena es: " + valor);

        // Obtener el primer caracter de la cadena
        char letra = nombre.charAt(0);
        System.out.println("El primer caracter de la cadena es: " + letra);
        
        // Obtener una subcadena
        String cadena = nombreCompleto.substring(3, 6);
        System.out.println("La subcadena es: " + cadena);
        String cadena2 = nombreCompleto.substring(1);
        System.out.println("La subcadena es: " + cadena2);
        String cadena3 = nombreCompleto.substring(1, 2);
        System.out.println("La subcadena es: " + cadena3);
        
        // Comparar cadenas
        String nombre2 = "Ana";
        boolean resultado = nombreCompleto.equals(nombre2);
        System.out.println("Las cadenas son iguales: " + resultado);
        
        // Comparar cadenas ignorando mayúsculas y minúsculas
        boolean resultado2 = nombreCompleto.equalsIgnoreCase(nombre2);
        System.out.println("Las cadenas son iguales: " + resultado2);
        
        // Comparar cadenas
        String nombre3 = "Ana";
        boolean resultado3 = nombre == nombre3;
        System.out.println("Las cadenas son iguales: " + resultado3);
        
        // Comparar cadenas
        System.out.println("La cadena contiene 'na': " + nombre.contains("na"));
        System.out.println("La cadena contiene 'na': " + nombre.contains("NA"));
}
}
