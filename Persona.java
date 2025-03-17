public class Persona {
    // Atributos
    private String nombre;
    String apellido;
    int edad;
    String ocupacion;
    String ci;
    String genero;

    
    // Método para mostrar información
    void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Ocupación: " + ocupacion);
        System.out.println("CI: " + ci);
        System.out.println("Genero: " + genero);
    }

    void Alimentar() {
        System.out.println("Alimentando a la persona " + nombre);
    }

    void cambioOcupacion(String nuevaOcupacion) {
        ocupacion = nuevaOcupacion;
    }
    void cambioGenero(String nuevoGenero) {
        genero = nuevoGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            System.out.println("El nombre no puede ser nulo");
            return;
        } 
        else 
        {
        this.nombre = nombre;
        }
    }   
}
