# Mision-Primaria-1
  > Palabras Clave: Interfaces, Clases Abstractras
  
## Uso
```bash
java -jar gradeording-1.0-SNAPSHOT.jar [input] [output]  
```
* input: absolute or relative path to the excel/csv file with the inscriptions. 
* output: csv or txt file to append the ordered list.

## Gestión y adimistración de calificaciones escolares

El departamento de servicios escolares se encarga de centralizar y concentrar las calificaciones de los
alumnos inscritos en la universidad. Por lo cual, se ha solicitado al departamento de sistemas un sistema
informático para la captura y cálculo de los promedios de los alumnos, así como el orden de toma de carga
para el siguiente periodo. Este sistema informático será alimentado mediante la carga de un archivo excel
(véase archivo adjunto) que contendrá la información de:

  * Nombre de alumnos
  * Matricula de cada alumno
  * Procentaje de asistencia de cada alumno
  * Calificación por cada unidad
  * Nombre de la materia
  * Código de la materia
  
## Requerimientos funcionales
  * El sistema deberá ser robusto al número variables de unidades de cada materia [1,4] (Reading restriction)
  * Cada alumno puede tomar un máximo de 8 materias al cuatrimestre (Reading restriction).
  * Si el alumno tiene una unidad reprobada, su calificación final es inmediatamente 60 (Reading restriction).
  * Si el alumno tiene una asistencia menor al 80% su calificación final es inmediatamente 60 (Reading restriction).
  * Cada materia tiene un máximo de 32 alumnos (Reading restriction).
  * Si el promedio total de dos alumnos es igual, se le dará prioridad de la siguiente manera (Sorting restrictions):
    * cuatrimestres mayores (antiguedad)
    * número mayor de materias tomadas por el alumno
    * número mayor de materias aprobadas (This one makes no sense if we already grouped by failed subjects and order by the previous point ).
    
### Requerimientos no funcionales
  * Se necesita que el sistema informático tenga un módulo de captura de los alumnos al archivo xlsx.
  * Se necesita que el sistema informático tenga un módulo de carga del archivo (xlsx, csv).
  * Se necesita que el sistema tenga un módulo de búsqueda y visualización de las calificaciones del alumno.
  