# Ejemplo de Uso del Sistema de Registro de Notas

## Demostración en Clase

Este documento muestra cómo usar el sistema de forma práctica para la demostración en clase.

## Pantalla de Inicio

Al ejecutar el programa, se cargará automáticamente con datos de ejemplo:

```
Cargando datos de ejemplo...

✓ Alumno registrado: Juan Pérez
✓ Alumno registrado: María García
✓ Alumno registrado: Carlos López
✓ Materia registrada: Matemáticas
✓ Materia registrada: Física
✓ Materia registrada: Programación
[... más registros ...]

✓ Datos de ejemplo cargados exitosamente
```

## Menú Principal

```
==================================================
SISTEMA DE REGISTRO DE NOTAS
==================================================
1. Gestionar Alumnos
2. Gestionar Materias
3. Registrar/Modificar Notas
4. Ver Reportes
5. Salir
Seleccione una opción: 
```

---

## Caso de Uso 1: Ver Reporte General

**Pasos:**
1. Opción 4 (Ver Reportes)
2. Opción 2 (Reporte general de todos los alumnos)

**Resultado esperado:**
```
================================================================================
REPORTE GENERAL DE CALIFICACIONES
================================================================================

Alumno: Juan Pérez (ID: 001)
--------------------------------------------------------------------------------
  Materia: Matemáticas | P1: 85.00 | P2: 78.00 | P3: 88.00 | Promedio: 83.67 | APROBADO
  Materia: Programación | P1: 90.00 | P2: 92.00 | P3: 95.00 | Promedio: 92.33 | APROBADO
  Materia: Física | P1: 75.00 | P2: 72.00 | P3: 70.00 | Promedio: 72.33 | APROBADO
  Resumen: 3 aprobadas, 0 no aprobadas

Alumno: María García (ID: 002)
--------------------------------------------------------------------------------
  Materia: Matemáticas | P1: 65.00 | P2: 70.00 | P3: 68.00 | Promedio: 67.67 | NO APROBADO
  Materia: Programación | P1: 78.00 | P2: 82.00 | P3: 80.00 | Promedio: 80.00 | APROBADO
  Materia: Física | P1: 88.00 | P2: 85.00 | P3: 90.00 | Promedio: 87.67 | APROBADO
  Resumen: 2 aprobadas, 1 no aprobadas

[Continúa con los demás alumnos...]
================================================================================
```

**Conceptos POO demostrables:**
- Cada alumno es una instancia de la clase `Alumno`
- Cada materia es una instancia de la clase `Materia`
- Las notas están contenidas en objetos `Nota` que asocian o relacionan Alumno + Materia
- El `RegistroNotas` coordina toda la información

---

## Caso de Uso 2: Registrar un Nuevo Alumno

**Pasos:**
1. Opción 1 (Gestionar Alumnos)
2. Opción 1 (Registrar nuevo alumno)
3. Ingresar datos:
   - ID: `004`
   - Nombre: `Ana Martínez`
   - Email: `ana@email.com`

**Salida:**
```
✓ Alumno registrado: Ana Martínez
```

**Conceptos demostrables:**
- Creación de nuevas instancias de `Alumno`
- Validación de datos (ID único)
- Encapsulación de atributos privados
- Métodos de registro que validan información

---

## Caso de Uso 3: Registrar Notas para un Alumno

**Pasos:**
1. Opción 3 (Registrar/Modificar Notas)
2. Opción 1 (Registrar notas para un alumno)
3. Ingresar datos:
   - ID alumno: `004` (Ana Martínez)
   - Código materia: `MAT101` (Matemáticas)
   - Parcial 1: `85`
   - Parcial 2: `90`
   - Parcial 3: `88`

**Salida:**
```
✓ Notas registradas para Ana Martínez en Matemáticas
```

**Cálculos internos:**
```
Promedio = (85 + 90 + 88) / 3 = 87.67
Aprobado = 87.67 >= 70 ✓ APROBADO
```

**Conceptos demostrables:**
- Asociación entre `Alumno` y `Materia` a través de `Nota`
- Validación de rango (0-100)
- Cálculo de promedio automático
- Determinación de estado de aprobación

---

## Caso de Uso 4: Modificar una Nota

**Pasos:**
1. Opción 3 (Registrar/Modificar Notas)
2. Opción 3 (Modificar nota de un parcial)
3. Ingresar datos:
   - ID alumno: `001` (Juan Pérez)
   - Código materia: `MAT101` (Matemáticas)
4. Seleccionar parcial: `1`
5. Nueva nota: `82`

**Salida:**
```
Notas actuales:
1. Parcial 1: 85.0
2. Parcial 2: 78.0
3. Parcial 3: 88.0
¿Cuál desea modificar? 1
Nueva nota (0-100): 82
✓ Parcial 1 actualizado
```

**Nuevo promedio:** (82 + 78 + 88) / 3 = 82.67

**Conceptos demostrables:**
- Acceso y modificación de atributos
- Validación de cambios
- Recálculo automático de promedio

---

## Caso de Uso 5: Ver Estadísticas de una Materia

**Pasos:**
1. Opción 4 (Ver Reportes)
2. Opción 3 (Estadísticas de una materia)
3. Código materia: `MAT101`

**Salida esperada:**
```
======================================================================
ESTADÍSTICAS - Matemáticas
======================================================================
Código: MAT101
Docente: Dr. García
Créditos: 4
----------------------------------------------------------------------
Estudiantes con notas: 4
Promedio general: 82.67
Aprobados: 4 (100.0%)
No aprobados: 0 (0.0%)
======================================================================
```

**Conceptos demostrables:**
- Agregación de información desde múltiples objetos
- Cálculos estadísticos
- Relaciones uno-a-muchos (una materia → muchos alumnos)

---

## Interacciones Importantes para Demostraciones

### 1. Interacción Alumno ↔ RegistroNotas

```java
Alumno alumno = registro.obtenerAlumno("001");
```
- El `RegistroNotas` devuelve una instancia de `Alumno`
- El alumno mantiene sus propias notas en un `HashMap`

### 2. Interacción Nota ↔ Materia

```java
Nota nota = new Nota(materia, 85, 78, 88);
```
- La `Nota` contiene una referencia a la `Materia`
- Esto establece una relación composición/asociación

### 3. Interacción RegistroNotas ↔ Todos

```java
registro.registrarNotas(idAlumno, codigoMateria, p1, p2, p3);
```
- Busca el alumno por ID
- Busca la materia por código
- Crea una nueva `Nota` asociando ambas
- Registra la nota en el alumno
- Todo coordinado por `RegistroNotas`

---

## Ejercicios Propuestos para los Estudiantes

1. **Agregar métodos a Alumno:**
   - Calcular promedio general del alumno
   - Contar materias aprobadas

2. **Agregar métodos a Materia:**
   - Aumentar/disminuir créditos

3. **Agregar validaciones:**
   - Email válido
   - ID único
   - Nombre no vacío

4. **Extender RegistroNotas:**
   - Buscar alumno por nombre
   - Listar alumnos con todas las materias aprobadas
   - Listar alumnos con al menos una materia reprobada

5. **Crear nueva clase:**
   - `Profesor` con datos de docentes
   - `Carrera` que agrupe materias
   - `Horario` para clases

---

## Salida de Ejemplo Completa

Para ejecutar el programa:
```bash
cd /home/esteban/Documents/programacion1/programacion01
javac POO/registronotas/*.java
java POO.registronotas.Main
```

Luego interactúa con los menús según los casos de uso anteriores.
