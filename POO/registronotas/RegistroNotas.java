package POO.registronotas;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

/**
 * Clase gestora que maneja el registro de alumnos, materias y sus notas
 * Permite la interacción entre los diferentes objetos
 */
public class RegistroNotas {
    private Map<String, Alumno> alumnos; // ID alumno -> Alumno
    private Map<String, Materia> materias; // Código materia -> Materia

    public RegistroNotas() {
        this.alumnos = new HashMap<>();
        this.materias = new HashMap<>();
    }

    /**
     * Registra un nuevo alumno
     */
    public void registrarAlumno(String id, String nombre, String email) {
        if (alumnos.containsKey(id)) {
            throw new IllegalArgumentException("El alumno con ID " + id + " ya existe");
        }
        alumnos.put(id, new Alumno(id, nombre, email));
        System.out.println("✓ Alumno registrado: " + nombre);
    }

    /**
     * Registra una nueva materia
     */
    public void registrarMateria(String codigo, String nombre, int creditos, String docente) {
        if (materias.containsKey(codigo)) {
            throw new IllegalArgumentException("La materia con código " + codigo + " ya existe");
        }
        materias.put(codigo, new Materia(codigo, nombre, creditos, docente));
        System.out.println("✓ Materia registrada: " + nombre);
    }

    /**
     * Registra las notas de un alumno en una materia
     */
    public void registrarNotas(String idAlumno, String codigoMateria, 
                               double parcial1, double parcial2, double parcial3) {
        Alumno alumno = alumnos.get(idAlumno);
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno con ID " + idAlumno + " no existe");
        }

        Materia materia = materias.get(codigoMateria);
        if (materia == null) {
            throw new IllegalArgumentException("La materia con código " + codigoMateria + " no existe");
        }

        Nota nota = new Nota(materia, parcial1, parcial2, parcial3);
        alumno.registrarNota(codigoMateria, nota);
        System.out.println("✓ Notas registradas para " + alumno.getNombre() + " en " + materia.getNombre());
    }

    /**
     * Obtiene un alumno por su ID
     */
    public Alumno obtenerAlumno(String id) {
        return alumnos.get(id);
    }

    /**
     * Obtiene una materia por su código
     */
    public Materia obtenerMateria(String codigo) {
        return materias.get(codigo);
    }

    /**
     * Obtiene todos los alumnos registrados
     */
    public Collection<Alumno> obtenerTodosAlumnos() {
        return alumnos.values();
    }

    /**
     * Obtiene todas las materias registradas
     */
    public Collection<Materia> obtenerTodasMaterias() {
        return materias.values();
    }

    /**
     * Genera un reporte de calificaciones de un alumno
     */
    public void generarReporteAlumno(String idAlumno) {
        Alumno alumno = alumnos.get(idAlumno);
        if (alumno == null) {
            System.out.println("El alumno no existe");
            return;
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("REPORTE DE CALIFICACIONES");
        System.out.println("=".repeat(70));
        System.out.println(alumno);
        System.out.println("-".repeat(70));

        if (alumno.getNotas().isEmpty()) {
            System.out.println("No hay notas registradas");
        } else {
            for (Nota nota : alumno.getNotas().values()) {
                System.out.println(nota);
            }
        }
        System.out.println("=".repeat(70) + "\n");
    }

    /**
     * Genera un reporte consolidado de todos los alumnos
     */
    public void generarReporteGeneral() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("REPORTE GENERAL DE CALIFICACIONES");
        System.out.println("=".repeat(80));

        for (Alumno alumno : alumnos.values()) {
            System.out.println("\nAlumno: " + alumno.getNombre() + " (ID: " + alumno.getId() + ")");
            System.out.println("-".repeat(80));

            if (alumno.getNotas().isEmpty()) {
                System.out.println("  No hay notas registradas");
            } else {
                int aprobadas = 0;
                int noAprobadas = 0;

                for (Nota nota : alumno.getNotas().values()) {
                    System.out.println("  " + nota);
                    if (nota.esAprobado()) {
                        aprobadas++;
                    } else {
                        noAprobadas++;
                    }
                }

                System.out.println("  Resumen: " + aprobadas + " aprobadas, " + noAprobadas + " no aprobadas");
            }
        }
        System.out.println("=".repeat(80) + "\n");
    }

    /**
     * Obtiene estadísticas de una materia
     */
    public void generarEstadisticasMateria(String codigoMateria) {
        Materia materia = materias.get(codigoMateria);
        if (materia == null) {
            System.out.println("La materia no existe");
            return;
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("ESTADÍSTICAS - " + materia.getNombre());
        System.out.println("=".repeat(70));
        System.out.println("Código: " + materia.getCodigo());
        System.out.println("Docente: " + materia.getDocente());
        System.out.println("Créditos: " + materia.getCreditos());
        System.out.println("-".repeat(70));

        double sumaPromedios = 0;
        int aprobados = 0;
        int noAprobados = 0;
        int conNotas = 0;

        for (Alumno alumno : alumnos.values()) {
            if (alumno.tieneNota(codigoMateria)) {
                Nota nota = alumno.obtenerNota(codigoMateria);
                sumaPromedios += nota.calcularPromedio();
                conNotas++;

                if (nota.esAprobado()) {
                    aprobados++;
                } else {
                    noAprobados++;
                }
            }
        }

        if (conNotas == 0) {
            System.out.println("No hay notas registradas para esta materia");
        } else {
            double promediogeneral = sumaPromedios / conNotas;
            double porcentajeAprobacion = (aprobados * 100.0) / (aprobados + noAprobados);

            System.out.println("Estudiantes con notas: " + conNotas);
            System.out.println("Promedio general: " + String.format("%.2f", promediogeneral));
            System.out.println("Aprobados: " + aprobados + " (" + String.format("%.1f", porcentajeAprobacion) + "%)");
            System.out.println("No aprobados: " + noAprobados + " (" + String.format("%.1f", 100 - porcentajeAprobacion) + "%)");
        }
        System.out.println("=".repeat(70) + "\n");
    }

    /**
     * Verifica si existe un alumno
     */
    public boolean existeAlumno(String id) {
        return alumnos.containsKey(id);
    }

    /**
     * Verifica si existe una materia
     */
    public boolean existeMateria(String codigo) {
        return materias.containsKey(codigo);
    }
}
