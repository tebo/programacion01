package POO.registronotas;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un alumno
 */
public class Alumno {
    private String id;
    private String nombre;
    private String email;
    private Map<String, Nota> notas; // Materia -> Nota

    public Alumno(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.notas = new HashMap<>();
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Nota> getNotas() {
        return notas;
    }

    /**
     * Registra una nota para una materia específica
     */
    public void registrarNota(String materiaCodigo, Nota nota) {
        notas.put(materiaCodigo, nota);
    }

    /**
     * Obtiene la nota de una materia
     */
    public Nota obtenerNota(String materiaCodigo) {
        return notas.get(materiaCodigo);
    }

    /**
     * Verifica si el alumno tiene registrada una nota en una materia
     */
    public boolean tieneNota(String materiaCodigo) {
        return notas.containsKey(materiaCodigo);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
