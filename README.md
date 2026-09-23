# Ciclos-Java — Taller Ciclos Grupo #7 

## Integrantes

- Francis Bonifaz
- Sebastian Navas
- David Punina
- Dixon Prado

## Objetivo

Desarrollar y fortalecer el conocimiento sobre el uso de ciclos en Java, aplicando estructuras repetitivas como `while`, `do-while` y `for` para resolver diferentes problemas mediante programas sencillos y prácticos.

## Descripción de los ejercicios

### Ejercicio 1. Control de calificaciones

Desarrolle un programa que permita ingresar las calificaciones de N estudiantes.
El número de estudiantes debe ser mayor que cero y cada calificación deberá estar entre **0 y 10**.

El programa deberá determinar:

- número de estudiantes;
- suma de calificaciones;
- promedio general;
- cantidad de aprobados;
- cantidad de reprobados;
- nota más alta;
- nota más baja.

## Estructuras utilizadas

| Estructura | Uso en el Ejercicio 1 |
| :--- | :--- |
| `while` | Validar que `N > 0` y que cada nota esté entre 0 y 10 (se repite hasta recibir un dato válido). |
| `for` | Recorrer exactamente `N` estudiantes para leer y procesar cada calificación. |
| `if / else` | Clasificar aprobados/reprobados y actualizar la nota más alta y más baja. |
| Acumulador | `suma` guarda el total de calificaciones. |
| Contadores | `aprobados` y `reprobados`. |

**Caso límite obligatorio:** probar las notas **0, 7 y 10**.

#### Análisis

**Entradas**

- Número de estudiantes `N` (debe cumplir `N > 0`).
- Las `N` calificaciones individuales (cada una en el rango `[0, 10]`).

**Restricciones y validaciones**

- Uso de la estructura `while` para validar que `N > 0` y que cada nota esté entre 0 y 10.

**Procesos**

- Acumular las notas para calcular la suma total y el promedio general.
- Contar cuántos estudiantes aprobaron (`nota >= 7`) y cuántos reprobaron (`nota < 7`).
- Determinar la nota máxima y la nota mínima.
- Uso de la estructura `for` para iterar exactamente `N` veces.

**Salidas**

- Número total de estudiantes.
- Suma total de calificaciones.
- Promedio general.
- Cantidad de aprobados y reprobados.
- Nota más alta y nota más baja.



#### Diagrama de flujo

<img width="2280" height="8140" alt="Diagrama de flujo - Ejercicio 1" src="https://github.com/user-attachments/assets/fdde3d2c-da44-4461-84ef-17df2e55f607" />



#### Pseudocódigo

```
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
```

## Casos de prueba

### Prueba de escritorio — Ejercicio 1 (caso límite: notas 0, 7 y 10)

| Paso | Iteración (`i`) | `N` | Entrada (`nota`) | Validación | `suma` | `aprobados` | `reprobados` | `notaMax` | `notaMin` | `promedio` |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | 3 | - | Válido (3 > 0) | 0.0 | 0 | 0 | - | - | - |
| **Iteración 1** | 1 | 3 | 0.0 | Válida (0 entre 0 y 10) | 0.0 | 0 | 1 | 0.0 | 0.0 | - |
| **Iteración 2** | 2 | 3 | 7.0 | Válida (7 entre 0 y 10) | 7.0 | 1 | 1 | 7.0 | 0.0 | - |
| **Iteración 3** | 3 | 3 | 10.0 | Válida (10 entre 0 y 10) | 17.0 | 2 | 1 | 10.0 | 0.0 | - |
| **Fin del ciclo** | - | 3 | - | - | 17.0 | 2 | 1 | 10.0 | 0.0 | **5.67** |

### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| N no válido | `N = 0` o `N = -2` | Muestra "El numero de estudiantes debe ser mayor que cero" y vuelve a pedir N. |
| Nota menor al rango | `nota = -1` | Muestra "Calificacion invalida" y vuelve a pedir la nota. |
| Nota mayor al rango | `nota = 11` | Muestra "Calificacion invalida" y vuelve a pedir la nota. |
| Nota límite de aprobación | `nota = 7` | Se cuenta como **aprobado**. |
| Un solo estudiante | `N = 1`, `nota = 8` | Suma 8, promedio 8, 1 aprobado, nota más alta y más baja = 8. |

## Capturas o evidencias

<img width="486" height="470" alt="image" src="https://github.com/user-attachments/assets/819c433e-4fdd-4721-87a3-8f3770173305" />

## Conclusiones

- El ciclo `while` es adecuado para validar datos de entrada, ya que repite la solicitud hasta que el usuario ingresa un valor correcto.
- El ciclo `for` es ideal cuando se conoce de antemano el número de repeticiones, como al procesar exactamente N calificaciones.
- El uso de acumuladores y contadores dentro de los ciclos permite obtener sumas, promedios y conteos de forma sencilla.
- Probar los casos límite (0, 7 y 10) permite comprobar que las validaciones y la condición de aprobación (`>= 7`) funcionan correctamente.

EJERCICIO 2

## Objetivo

Desarrollar y fortalecer el conocimiento sobre el uso de ciclos en Java, aplicando estructuras repetitivas como `while`, `do-while` y `for` para resolver diferentes problemas mediante programas sencillos y prácticos.

## Descripción de los ejercicios

### Ejercicio 1. Control de calificaciones

Desarrolle un programa que permita ingresar las calificaciones de N estudiantes.
El número de estudiantes debe ser mayor que cero y cada calificación deberá estar entre **0 y 10**.

El programa deberá determinar:

- número de estudiantes;
- suma de calificaciones;
- promedio general;
- cantidad de aprobados;
- cantidad de reprobados;
- nota más alta;
- nota más baja.

**Estructuras esperadas:** `while` para validación y `for` para procesamiento.
**Caso límite obligatorio:** probar las notas **0, 7 y 10**.

#### Análisis

* **Definición de Variables:**
  * **Entradas:**
    * `tablaInicial` (Entero): Número de la primera tabla a generar.
    * `tablaFinal` (Entero): Número de la última tabla a generar.
    * `limiteMultiplicador` (Entero): Número máximo hasta el cual se multiplicará cada tabla.
  * **Variables de Control e Internas:**
    * `i` (Entero): Contador del ciclo externo (controla la tabla actual).
    * `j` (Entero): Contador del ciclo interno (controla el multiplicador actual).
  * **Salidas:**
    * `producto` (Entero): Resultado de la multiplicación actual (`i * j`).

* **Restricciones y Validaciones:**
  * Se debe validar con un ciclo `while` que la tabla inicial sea menor o igual a la tabla final (`tablaInicial <= tablaFinal`).
  * El multiplicador máximo debe ser un entero estrictamente mayor a cero (`limiteMultiplicador > 0`).

* **Procesamiento y Fórmulas:**
  1. Solicitar y validar los datos de entrada usando la estructura `while`.
  2. Implementar un **ciclo `for` exterior** desde `i = tablaInicial` hasta `i = tablaFinal` (paso 1) para iterar sobre cada número de tabla.
  3. En cada vuelta del ciclo exterior, imprimir el encabezado de la tabla (ej. `TABLA DEL i`).
  4. Implementar un **ciclo `for` interior** desde `j = 1` hasta `j = limiteMultiplicador` (paso 1) para realizar las multiplicaciones.
  5. Calcular en cada paso la fórmula: `producto = i * j`.
  6. Imprimir en pantalla el formato: `i x j = producto`.

* **Salidas:**
  * Título indicador para cada tabla generada.
  * Listado completo de multiplicaciones para el rango especificado.

#### Diagrama de flujo



<img width="1840" height="6652" alt="image" src="https://github.com/user-attachments/assets/1c2d75f5-b000-40f8-8a2a-437a9a3eaa9c" />



#### Pseudocódigo

```
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
```

## Estructuras utilizadas

| Estructura | Uso en el Ejercicio 1 |
| :--- | :--- |
| `while` | Validar que `N > 0` y que cada nota esté entre 0 y 10 (se repite hasta recibir un dato válido). |
| `for` | Recorrer exactamente `N` estudiantes para leer y procesar cada calificación. |
| `if / else` | Clasificar aprobados/reprobados y actualizar la nota más alta y más baja. |
| Acumulador | `suma` guarda el total de calificaciones. |
| Contadores | `aprobados` y `reprobados`. |

## Instrucciones de ejecución

## Casos de prueba

### Prueba de Escritorio - Ejercicio 2 (Caso: Tabla Inicial = 3, Tabla Final = 4, Hasta el 2)

| Paso | Tabla (`i`) | Multiplicador (`j`) | Operación | Resultado | Salida |
| :--- | :---: | :---: | :---: | :---: | :--- |
| Inicio | - | - | - | - | Entrada de datos |
| Encabezado | 3 | - | - | - | `=== TABLA DEL 3 ===` |
| Iteración 1.1 | 3 | 1 | 3 * 1 | 3 | `3 x 1 = 3` |
| Iteración 1.2 | 3 | 2 | 3 * 2 | 6 | `3 x 2 = 6` |
| Encabezado | 4 | - | - | - | `=== TABLA DEL 4 ===` |
| Iteración 2.1 | 4 | 1 | 4 * 1 | 4 | `4 x 1 = 4` |
| Iteración 2.2 | 4 | 2 | 4 * 2 | 8 | `4 x 2 = 8` |
| Fin | - | - | - | - | Fin del programa |

### Casos de validación

| Caso | Entrada | Resultado esperado |
| :--- | :--- | :--- |
| N no válido | `N = 0` o `N = -2` | Muestra "El numero de estudiantes debe ser mayor que cero" y vuelve a pedir N. |
| Nota menor al rango | `nota = -1` | Muestra "Calificacion invalida" y vuelve a pedir la nota. |
| Nota mayor al rango | `nota = 11` | Muestra "Calificacion invalida" y vuelve a pedir la nota. |
| Nota límite de aprobación | `nota = 7` | Se cuenta como **aprobado**. |
| Un solo estudiante | `N = 1`, `nota = 8` | Suma 8, promedio 8, 1 aprobado, nota más alta y más baja = 8. |

## Capturas o evidencias

Las capturas de ejecución de cada ejercicio se encuentran en la carpeta [`evidencias/`](./evidencias).

**Ejercicio 1 — Ejecución con notas 0, 7 y 10**

<!-- Reemplazar por la captura real subida a GitHub -->
![Ejecución Ejercicio 1](./evidencias/ejercicio01.png)

## Conclusiones

- El ciclo `while` es adecuado para validar datos de entrada, ya que repite la solicitud hasta que el usuario ingresa un valor correcto.
- El ciclo `for` es ideal cuando se conoce de antemano el número de repeticiones, como al procesar exactamente N calificaciones.
- El uso de acumuladores y contadores dentro de los ciclos permite obtener sumas, promedios y conteos de forma sencilla.
- Probar los casos límite (0, 7 y 10) permite comprobar que las validaciones y la condición de aprobación (`>= 7`) funcionan correctamente.
