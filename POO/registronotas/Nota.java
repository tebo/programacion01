package POO.registronotas;

/**
 * Clase que representa las notas de un alumno en una materia
 * Contiene las notas de 3 parciales y calcula el promedio
 */
public class Nota {
    private Materia materia;
    private double parcial1;
    private double parcial2;
    private double parcial3;
    private static final double NOTA_MINIMA_APROBACION = 70.0;

    public Nota(Materia materia, double parcial1, double parcial2, double parcial3) {
        this.materia = materia;
        this.parcial1 = validarNota(parcial1);
        this.parcial2 = validarNota(parcial2);
        this.parcial3 = validarNota(parcial3);
    }

    /**
     * Valida que la nota esté entre 0 y 100
     */
    private double validarNota(double nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100");
        }
        return nota;
    }

    // Getters y setters
    public Materia getMateria() {
        return materia;
    }

    public double getParcial1() {
        return parcial1;
    }

    public void setParcial1(double parcial1) {
        this.parcial1 = validarNota(parcial1);
    }

    public double getParcial2() {
        return parcial2;
    }

    public void setParcial2(double parcial2) {
        this.parcial2 = validarNota(parcial2);
    }

    public double getParcial3() {
        return parcial3;
    }

    public void setParcial3(double parcial3) {
        this.parcial3 = validarNota(parcial3);
    }

    /**
     * Calcula el promedio de los 3 parciales
     */
    public double calcularPromedio() {
        return (parcial1 + parcial2 + parcial3) / 3.0;
    }

    /**
     * Verifica si el alumno aprobó la materia (promedio >= 70%)
     */
    public boolean esAprobado() {
        return calcularPromedio() >= NOTA_MINIMA_APROBACION;
    }

    /**
     * Obtiene el estado de aprobación como string
     */
    public String getEstado() {
        return esAprobado() ? "APROBADO" : "NO APROBADO";
    }

    @Override
    public String toString() {
        return String.format(
            "Materia: %s | P1: %.2f | P2: %.2f | P3: %.2f | Promedio: %.2f | %s",
            materia.getNombre(),
            parcial1,
            parcial2,
            parcial3,
            calcularPromedio(),
            getEstado()
        );
    }
}
