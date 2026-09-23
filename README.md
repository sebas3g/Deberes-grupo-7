Ciclos-Java — Taller Ciclos Grupo #7 - EJERCICIO/01
Integrantes
Francis Bonifaz
Sebastian Navas
David Punina
Dixon Prado
Objetivo

Desarrollar y fortalecer el conocimiento sobre el uso de ciclos en Java, aplicando estructuras repetitivas como while, do-while y for para resolver diferentes problemas mediante programas sencillos y prácticos.

Descripción de los ejercicios
Ejercicio 1. Control de calificaciones

Desarrolle un programa que permita ingresar las calificaciones de N estudiantes. El número de estudiantes debe ser mayor que cero y cada calificación deberá estar entre 0 y 10.

El programa deberá determinar:

número de estudiantes;
suma de calificaciones;
promedio general;
cantidad de aprobados;
cantidad de reprobados;
nota más alta;
nota más baja.

Estructuras esperadas: while para validación y for para procesamiento. Caso límite obligatorio: probar las notas 0, 7 y 10.

Análisis

Entradas

Número de estudiantes N (debe cumplir N > 0).
Las N calificaciones individuales (cada una en el rango [0, 10]).

Restricciones y validaciones

Uso de la estructura while para validar que N > 0 y que cada nota esté entre 0 y 10.

Procesos

Acumular las notas para calcular la suma total y el promedio general.
Contar cuántos estudiantes aprobaron (nota >= 7) y cuántos reprobaron (nota < 7).
Determinar la nota máxima y la nota mínima.
Uso de la estructura for para iterar exactamente N veces.

Salidas

Número total de estudiantes.
Suma total de calificaciones.
Promedio general.
Cantidad de aprobados y reprobados.
Nota más alta y nota más baja.



Diagrama de flujo
<img width="2280" height="8140" alt="Diagrama de flujo - Ejercicio 1" src="https://github.com/user-attachments/assets/fdde3d2c-da44-4461-84ef-17df2e55f607" />



Pseudocódigo
Algoritmo ControlCalificaciones
    Definir n, i, aprobados, reprobados Como Entero
    Definir nota, suma, notaMax, notaMin, promedio Como Real

    suma <- 0
    aprobados <- 0
    reprobados <- 0

    // Validación del número de estudiantes
    Escribir "Ingrese el numero de estudiantes: "
    Leer n

    Mientras n <= 0 Hacer
        Escribir "El numero de estudiantes debe ser mayor que cero"
        Escribir "Ingrese el numero de estudiantes: "
        Leer n
    FinMientras

    // Procesamiento con Para (for)
    Para i <- 1 Hasta n Con Paso 1 Hacer

        Escribir "Ingrese la calificacion del estudiante ", i, ": "
        Leer nota

        Mientras nota < 0 O nota > 10 Hacer
            Escribir "Calificacion invalida. Debe estar entre 0 y 10"
            Escribir "Ingrese la calificacion del estudiante ", i, ": "
            Leer nota
        FinMientras

        suma <- suma + nota

        Si nota >= 7 Entonces
            aprobados <- aprobados + 1
        SiNo
            reprobados <- reprobados + 1
        FinSi

        Si i == 1 Entonces
            notaMax <- nota
            notaMin <- nota
        SiNo
            Si nota > notaMax Entonces
                notaMax <- nota
            FinSi
            Si nota < notaMin Entonces
                notaMin <- nota
            FinSi
        FinSi

    FinPara

    promedio <- suma / n

    Escribir "-----------------------------------"
    Escribir "Numero de estudiantes: ", n
    Escribir "Suma de calificaciones: ", suma
    Escribir "Promedio general: ", promedio
    Escribir "Cantidad de aprobados: ", aprobados
    Escribir "Cantidad de reprobados: ", reprobados
    Escribir "Nota mas alta: ", notaMax
    Escribir "Nota mas baja: ", notaMin

FinAlgoritmo
Estructuras utilizadas
Estructura	Uso en el Ejercicio 1
while	Validar que N > 0 y que cada nota esté entre 0 y 10 (se repite hasta recibir un dato válido).
for	Recorrer exactamente N estudiantes para leer y procesar cada calificación.
if / else	Clasificar aprobados/reprobados y actualizar la nota más alta y más baja.
Acumulador	suma guarda el total de calificaciones.
Contadores	aprobados y reprobados.
Instrucciones de ejecución

bash
# 1. Clonar el repositorio
git clone https://github.com/<usuario>/APE-Ciclos-Java-<Apellido>.git
cd APE-Ciclos-Java-<Apellido>

# 2. Compilar y ejecutar el ejercicio deseado
cd Ejercicio01
javac Main.java
java Main
Casos de prueba

| Paso | Iteración (`i`) | `N` | Entrada (`nota`) | Validación Nota | `suma` | `aprobados` | `reprobados` | `notaMaxima` | `notaMinima` | `promedio` |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | 3 | - | Válido (3 > 0) | 0.0 | 0 | 0 | -1.0 | 11.0 | - |
| **Iteración 1** | 1 | 3 | 0.0 | Válida (0 entre 0 y 10) | 0.0 | 0 | 1 | 0.0 | 0.0 | - |
| **Iteración 2** | 2 | 3 | 7.0 | Válida (7 entre 0 y 10) | 7.0 | 1 | 1 | 7.0 | 0.0 | - |
| **Iteración 3** | 3 | 3 | 10.0 | Válida (10 entre 0 y 10) | 17.0 | 2 | 1 | 10.0 | 0.0 | - |
| **Fin Ciclo** | - | 3 | - | - | 17.0 | 2 | 1 | 10.0 | 0.0 | **5.67** |

Casos de validación

Caso	Entrada	Resultado esperado
N no válido	N = 0 o N = -2	Muestra "El numero de estudiantes debe ser mayor que cero" y vuelve a pedir N.
Nota menor al rango	nota = -1	Muestra "Calificacion invalida" y vuelve a pedir la nota.
Nota mayor al rango	nota = 11	Muestra "Calificacion invalida" y vuelve a pedir la nota.
Nota límite de aprobación	nota = 7	Se cuenta como aprobado.
Un solo estudiante	N = 1, nota = 8	Suma 8, promedio 8, 1 aprobado, nota más alta y más baja = 8.
Capturas o evidencias

<img width="486" height="470" alt="image" src="https://github.com/user-attachments/assets/ab013d51-85ad-409f-b2f7-090590f1e8e4" />


Conclusiones
El ciclo while es adecuado para validar datos de entrada, ya que repite la solicitud hasta que el usuario ingresa un valor correcto.
El ciclo for es ideal cuando se conoce de antemano el número de repeticiones, como al procesar exactamente N calificaciones.
El uso de acumuladores y contadores dentro de los ciclos permite obtener sumas, promedios y conteos de forma sencilla.
Probar los casos límite (0, 7 y 10) permite comprobar que las validaciones y la condición de aprobación (>= 7) funcionan correctamente.
