package POO.persona;

public class Main {
    public static void main(String[] args) {
    Persona p1 = new Persona();
    p1.nombre = "Alice";
    p1.edad = 30;
    p1.saludar();
    Persona p2 = new Persona();
    p2.saludar();
    
    }    
}


class Persona {
    String nombre;
    int edad;

    void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

    
}