# Arquitectura y Diseño POO del Sistema de Registro de Notas

## Diagrama de Relaciones entre Clases

```
┌─────────────────────────────────────────────────────────────┐
│                   SISTEMA DE REGISTRO DE NOTAS              │
│                    (Ejemplo POO Completo)                   │
└─────────────────────────────────────────────────────────────┘

    ┌──────────────────┐
    │   RegistroNotas  │ (GESTOR - Coordinador)
    │                  │
    │ - alumnos: Map   │
    │ - materias: Map  │
    └────┬─────────────┘
         │
         ├─────────────────────────┬──────────────────────┐
         │                         │                      │
         ▼                         ▼                      ▼
    ┌─────────────┐           ┌─────────────┐      ┌──────────────┐
    │   Alumno    │           │   Materia   │      │     Nota     │
    │             │           │             │      │              │
    │ - id        │           │ - codigo    │      │ - materia    │◄──┐
    │ - nombre    │           │ - nombre    │      │ - parcial1   │   │
    │ - email     │           │ - creditos  │      │ - parcial2   │   │
    │ - notas: Map│────┐      │ - docente   │      │ - parcial3   │   │
    └─────────────┘    │      └─────────────┘      └──────┬───────┘   │
                       │                                   │           │
                       └───────────────────────────────────┼───────────┘
                                                           │
                       (Composición/Asociación)────────────┘
                       Nota contiene referencia a Materia
                       Alumno contiene Map<String, Nota>


RELACIONES:
───────────

1. RegistroNotas --> Alumno (1 a N)
   - RegistroNotas gestiona múltiples Alumnos
   - Usa HashMap<String, Alumno>

2. RegistroNotas --> Materia (1 a N)
   - RegistroNotas gestiona múltiples Materias
   - Usa HashMap<String, Materia>

3. Alumno --> Nota (1 a N)
   - Cada Alumno tiene multiple Notas (una por materia)
   - Usa HashMap<String, Nota>

4. Nota --> Materia (N a 1)
   - Cada Nota hace referencia a una Materia
   - Relación de composición

5. Alumno --> Materia (Indirecta a través de Nota)
   - La relación se establece por la Nota
   - Demuestra asociación indirecta
```

---

## Principios POO Implementados

### 1. ENCAPSULACIÓN

**Definición:** Ocultar los detalles internos de un objeto.

**Implementado en:**
- Todos los atributos son `private`
- Acceso controlado a través de métodos `public`

```java
// Alumno.java
public class Alumno {
    private String id;              // Atributo privado
    private String nombre;
    private String email;
    
    public String getId() {         // Getter (lectura)
        return id;
    }
    
    public void setNombre(String nombre) {  // Setter (escritura con validación)
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }
}
```

**Beneficios demostrables:**
- No se puede modificar el ID después de crear el Alumno
- Se pueden agregar validaciones sin cambiar el código cliente

### 2. ABSTRACCIÓN

**Definición:** Mostrar solo las características relevantes, ocultando la complejidad.

**Implementado en:**
- `Nota.calcularPromedio()` - Abstrae el cálculo
- `Nota.esAprobado()` - Abstrae la lógica de decisión
- `RegistroNotas.registrarNotas()` - Abstrae la complejidad de asociación

```java
// Nota.java - Abstracción del cálculo
public double calcularPromedio() {
    return (parcial1 + parcial2 + parcial3) / 3.0;  // Detalles ocultos
}

public boolean esAprobado() {
    return calcularPromedio() >= NOTA_MINIMA_APROBACION;  // Lógica clara
}

// Cliente no necesita saber cómo se calcula
Nota nota = new Nota(materia, 85, 78, 88);
double promedio = nota.calcularPromedio();  // Simple interface
boolean aprobado = nota.esAprobado();       // Abstracción de criterio
```

**Beneficios demostrables:**
- Si cambias el criterio de aprobación (de 70 a 60), solo cambias una línea
- El código cliente no necesita cambios

### 3. HERENCIA (Potencial)

**No implementada en este ejemplo, pero se puede demostrar:**

```java
// Extensión potencial:
public abstract class Persona {
    protected String nombre;
    protected String email;
    
    public abstract void mostrarInfo();
}

public class Alumno extends Persona {
    private String id;
    
    @Override
    public void mostrarInfo() {
        System.out.println("Alumno: " + nombre);
    }
}

public class Profesor extends Persona {
    private String numero_empleado;
    
    @Override
    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre);
    }
}
```

### 4. POLIMORFISMO

**Definición:** Múltiples formas de hacer lo mismo.

**Implementado con:**
- Métodos `toString()` especializados en cada clase

```java
// Cada clase personaliza su representación
Alumno alumno = new Alumno("001", "Juan", "juan@email.com");
Materia materia = new Materia("MAT101", "Matemáticas", 4, "Dr. García");
Nota nota = new Nota(materia, 85, 78, 88);

System.out.println(alumno);   // Usa Alumno.toString()
System.out.println(materia);  // Usa Materia.toString()
System.out.println(nota);     // Usa Nota.toString()
```

### 5. ASOCIACIÓN / COMPOSICIÓN

**Definición:** Relaciones entre objetos.

**Implementado:**

1. **Composición (Nota contiene Materia):**
```java
public class Nota {
    private Materia materia;  // Composición fuerte
    
    public Nota(Materia materia, double p1, double p2, double p3) {
        this.materia = materia;
    }
}
```

2. **Agregación (Alumno contiene Notas):**
```java
public class Alumno {
    private Map<String, Nota> notas;  // Agregación
    
    public void registrarNota(String codigo, Nota nota) {
        notas.put(codigo, nota);
    }
}
```

3. **Asociación (RegistroNotas coordina Alumnos y Materias):**
```java
public class RegistroNotas {
    private Map<String, Alumno> alumnos;
    private Map<String, Materia> materias;
    
    public void registrarNotas(String idAlumno, String codigoMateria, 
                               double p1, double p2, double p3) {
        Alumno alumno = alumnos.get(idAlumno);
        Materia materia = materias.get(codigoMateria);
        Nota nota = new Nota(materia, p1, p2, p3);
        alumno.registrarNota(codigoMateria, nota);
    }
}
```

---

## Flujo de Creación de Objetos

```
Paso 1: Crear Materias
────────────────────────
registro.registrarMateria("MAT101", "Matemáticas", 4, "Dr. García")
                              ↓
                    new Materia(...)
                              ↓
                    Objeto Materia creado


Paso 2: Crear Alumnos
─────────────────────
registro.registrarAlumno("001", "Juan", "juan@email.com")
                              ↓
                    new Alumno(...)
                              ↓
                    Objeto Alumno creado (sin notas aún)


Paso 3: Crear Notas (Asociar Alumno + Materia)
───────────────────────────────────────────────
registro.registrarNotas("001", "MAT101", 85, 78, 88)
              ↓
    - Busca Alumno("001") en HashMap
    - Busca Materia("MAT101") en HashMap
    - Crea new Nota(materia, 85, 78, 88)
              ↓
    - alumno.registrarNota("MAT101", nota)
    - nota se almacena en HashMap de alumno


Resultado:
──────────
Alumno
  ├─ id: "001"
  ├─ nombre: "Juan"
  ├─ email: "juan@email.com"
  └─ notas: {
       "MAT101" → Nota {
                    materia: Materia("MAT101", "Matemáticas", ...),
                    parcial1: 85,
                    parcial2: 78,
                    parcial3: 88
                  }
     }
```

---

## Flujo de Ejecución: Ver Nota de un Alumno

```
usuario pide ver notas de alumno "001"
                ↓
RegistroNotas.generarReporteAlumno("001")
                ↓
obtener Alumno = alumnos.get("001")
                ↓
por cada Nota en alumno.getNotas().values()
                ↓
    nota.toString() que usa:
    - nota.getMateria().getNombre() → "Matemáticas"
    - nota.getParcial1() → 85
    - nota.getParcial2() → 78
    - nota.getParcial3() → 88
    - nota.calcularPromedio() → 83.67
    - nota.getEstado() → "APROBADO"
                ↓
Imprimir: "Materia: Matemáticas | P1: 85.00 | P2: 78.00 | P3: 88.00 | 
          Promedio: 83.67 | APROBADO"
```

---

## Ventajas del Diseño

### 1. **Modularidad**
- Cada clase tiene responsabilidad única
- Pueden modificarse independientemente
- Código reutilizable

### 2. **Mantenibilidad**
- Código claro y organizado
- Fácil de entender la estructura
- Cambios localizados

### 3. **Escalabilidad**
- Fácil agregar nuevas materias, alumnos, notas
- Fácil extender con nuevas funcionalidades
- Sistema robusto

### 4. **Validación**
- Validaciones en el constructor de `Nota` (0-100)
- Validaciones en `registrarAlumno` (ID único)
- Control de acceso exhaustivo

---

## Modificaciones Sugeridas como Ejercicio

### Modificación 1: Agregar Profesor como Clase

```java
public class Profesor {
    private String numeroEmpleado;
    private String nombre;
    private String especialidad;
    
    // ... constructor, getters, setters ...
}

// Modificar Materia para referenciar Profesor
public class Materia {
    private String codigo;
    private String nombre;
    private int creditos;
    private Profesor docente;  // Cambio de String a Profesor
}
```

### Modificación 2: Agregar Carrera

```java
public class Carrera {
    private String codigo;
    private String nombre;
    private List<Materia> materias;
    
    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }
}

// RegistroNotas maneja también Carreras
public class RegistroNotas {
    private Map<String, Carrera> carreras;
    
    public void registrarCarrera(String codigo, String nombre) {
        carreras.put(codigo, new Carrera(codigo, nombre));
    }
}
```

### Modificación 3: Validación en Setters

```java
public class Nota {
    private double parcial1;
    
    public void setParcial1(double parcial1) {
        if (parcial1 < 0 || parcial1 > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100");
        }
        this.parcial1 = parcial1;
    }
}
```

---

## Conclusión

Este sistema demuestra de manera práctica y real cómo los principios de POO se aplican en un proyecto educativo:

✓ **Encapsulación** - Datos privados, acceso controlado
✓ **Abstracción** - Ocultamiento de complejidad innecesaria  
✓ **Asociación** - Relaciones claras entre objetos
✓ **Validación** - Control de integridad de datos
✓ **Modularidad** - Código organizado y reutilizable
✓ **Extensibilidad** - Fácil de agregar funcionalidades

El programa es ideal para enseñar a estudiantes cómo pensar en términos de objetos y relaciones entre ellos, que es el corazón de la POO.
