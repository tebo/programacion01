# Sistema de Registro de Notas - Ejemplo POO

Este programa es un ejemplo educativo que demuestra los principios de **Programación Orientada a Objetos (POO)** mediante un sistema de registro de notas de alumnos.

## Descripción del Proyecto

El sistema permite:
- **Registrar alumnos** con información de ID, nombre y email
- **Registrar materias** con código, nombre, créditos y docente
- **Registrar notas** de estudiantes en materias (3 parciales)
- **Calcular promedios** automáticamente
- **Determinar aprobación** (≥70% del promedio de los 3 parciales)
- **Generar reportes** detallados por alumno, materia y general

## Estructura del Proyecto

### Clases Implementadas

#### 1. **Alumno.java**
Representa a un estudiante con:
- ID único
- Nombre y email
- Colección de notas por materia

**Métodos principales:**
- `registrarNota(String materiaCodigo, Nota nota)`: Asigna una nota a una materia
- `obtenerNota(String materiaCodigo)`: Recupera la nota de una materia
- `tieneNota(String materiaCodigo)`: Verifica si hay notas registradas

#### 2. **Materia.java**
Representa una asignatura con:
- Código único
- Nombre
- Número de créditos
- Docente responsable

**Métodos principales:**
- Getters y setters para todos los atributos
- `toString()` para visualización

#### 3. **Nota.java**
Almacena las calificaciones de un alumno en una materia:
- Parcial 1, 2 y 3 (validados entre 0-100)
- Referencia a la materia

**Métodos principales:**
- `calcularPromedio()`: Calcula el promedio de los 3 parciales
- `esAprobado()`: Retorna true si promedio ≥ 70
- `getEstado()`: Retorna "APROBADO" o "NO APROBADO"
- Validación automática de notas en rango 0-100

#### 4. **RegistroNotas.java**
Gestor central que coordina alumnos, materias y notas:
- Mantiene registro de alumnos y materias
- Facilita la registración de notas asociando alumno + materia
- Interacción entre objetos

**Métodos principales:**
- `registrarAlumno(...)`: Añade nuevos alumnos
- `registrarMateria(...)`: Añade nuevas materias
- `registrarNotas(...)`: Asigna notas a un alumno en una materia
- `generarReporteAlumno(...)`: Muestra calificaciones de un alumno
- `generarReporteGeneral()`: Muestra matriz de todos los alumnos y materias
- `generarEstadisticasMateria(...)`: Estadísticas por materia

#### 5. **Main.java**
Interfaz interactiva con menú principal que permite:
- Gestionar alumnos (registrar, consultar)
- Gestionar materias (registrar, consultar)
- Registrar y modificar notas
- Generar reportes variados
- Carga automática de datos de ejemplo

## Cómo Compilar

```bash
javac -d . POO/registronotas/*.java
```

## Cómo Ejecutar

```bash
java POO.registronotas.Main
```

## Ejemplo de Uso

1. Al iniciar, el programa carga 3 alumnos, 3 materias y notas de ejemplo
2. Menú principal permite elegir:
   - **Opción 1**: Registrar nuevos alumnos o ver lista
   - **Opción 2**: Registrar nuevas materias o ver lista
   - **Opción 3**: Registrar notas (3 parciales) o modificarlas
   - **Opción 4**: Ver reportes (por alumno, general, estadísticas)
   - **Opción 5**: Salir

## Algoritmo de Aprobación

```
Promedio = (Parcial1 + Parcial2 + Parcial3) / 3
Aprobado = Promedio >= 70
```

## Conceptos POO Demostrables en Clase

- **Encapsulación**: Atributos privados con métodos de acceso
- **Abstracción**: Clases representan entidades del mundo real
- **Asociación**: RegistroNotas relaciona Alumnos, Materias y Notas
- **Composición**: Nota contiene una referencia a Materia
- **Reutilización**: Las clases son independientes y reutilizables
- **Validación**: Encapsulación con validación en setters
- **Polimorfismo**: Métodos toString() especializados
- **Colecciones**: Uso de HashMap para relaciones 1-N

## Datos de Ejemplo Incluidos

### Alumnos
- 001 - Juan Pérez
- 002 - María García
- 003 - Carlos López

### Materias
- MAT101 - Matemáticas (4 créditos, Dr. García)
- FIS102 - Física (4 créditos, Dra. López)
- PRG103 - Programación (3 créditos, Ing. Martínez)

### Notas Pre-registradas
Se incluyen ejemplos de notas para que los estudiantes vean cómo funciona el sistema.

## Extensiones Posibles

1. Persistencia de datos (archivos o base de datos)
2. Autenticación de usuarios
3. Cálculo de GPA (Promedio ponderado)
4. Exportación de reportes a PDF
5. Manejo de clases (grupos de alumnos)
6. Sistema de asistencia
7. Calificaciones parciales por tema

---

Este proyecto es ideal para enseñar POO porque:
- Las clases representan entidades del dominio (Alumno, Materia, Nota)
- Hay interacción clara entre objetos
- Incluye validación y reglas de negocio
- Permite visualizar el resultado del sistema
- Es extensible y mantenible
