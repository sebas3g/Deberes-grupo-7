# EJERCICIO 6

#### ANÁLISIS

* **Definición de Variables:**
  * **Entradas:**
    * `n` (Entero): Número de filas/límite de los patrones (debe cumplirse que `2 <= n <= 10`).
  * **Variables de Control e Internas:**
    * `i` (Entero): Contador del ciclo `for` exterior (controla el número de fila actual).
    * `j` (Entero): Contador del ciclo `for` interior (controla la cantidad de elementos o números impresos por fila).
  * **Salidas:**
    * `patron1` (Texto): Triángulo rectángulo ascendente con asteriscos (`*`).
    * `patron2` (Texto): Triángulo rectángulo descendente con asteriscos (`*`).
    * `patron3` (Texto): Triángulo rectángulo numérico ascendente.

* **Restricciones y Validaciones:**
  * Debe validarse con un ciclo `while` que el valor ingresado esté estrictamente en el rango de 2 a 10 (`n >= 2 && n <= 10`).

* **Procesamiento y Fórmulas:**
  1. Solicitar y validar la entrada $n$ mediante un ciclo `while`.
  2. **Patrón 1 (Asteriscos Ascendente):**
     * Ciclo exterior `i` desde `1` hasta `n` (incremento de 1).
     * Ciclo interior `j` desde `1` hasta `i` (incremento de 1).
     * Imprimir `"*"` en la misma línea y al finalizar el ciclo interior imprimir salto de línea.
  3. **Patrón 2 (Asteriscos Descendente):**
     * Ciclo exterior `i` desde `n` hasta `1` (decremento de 1).
     * Ciclo interior `j` desde `1` hasta `i` (incremento de 1).
     * Imprimir `"*"` en la misma línea y al finalizar el ciclo interior imprimir salto de línea.
  4. **Patrón 3 (Numérico Ascendente):**
     * Ciclo exterior `i` desde `1` hasta `n` (incremento de 1).
     * Ciclo interior `j` desde `1` hasta `i` (incremento de 1).
     * Imprimir el valor de `j` en la misma línea y al finalizar el ciclo interior imprimir salto de línea.

* **Salidas:**
  * Impresión secuencial en consola de los 3 patrones gráficos y numéricos.

---

## PSEUDOCODIGO


    Algoritmo TrianguloYPatrones
    Definir n, i, j Como Entero

    // Validar numero entre 2 y 10
    Repetir
        Escribir "Ingrese un numero entre 2 y 10: "
        Leer n
        Si n < 2 O n > 10 Entonces
            Escribir "Numero fuera de rango"
        FinSi
    Hasta Que n >= 2 Y n <= 10

    // Patron 1: triangulo creciente de asteriscos
    Para i <- 1 Hasta n Con Paso 1 Hacer
        Para j <- 1 Hasta i Con Paso 1 Hacer
            Escribir Sin Saltar "*"
        FinPara
        Escribir ""
    FinPara

    // Patron 2: triangulo decreciente de asteriscos
    Para i <- n Hasta 1 Con Paso -1 Hacer
        Para j <- 1 Hasta i Con Paso 1 Hacer
            Escribir Sin Saltar "*"
        FinPara
        Escribir ""
    FinPara

    // Patron 3: triangulo de numeros
    Para i <- 1 Hasta n Con Paso 1 Hacer
        Para j <- 1 Hasta i Con Paso 1 Hacer
            Escribir Sin Saltar j
        FinPara
        Escribir ""
    FinPara
FinAlgoritmo

#### PRUEBA DE ESCRITORIO

| Patrón | Fila Ext. (`i`) | Condición Ext. | Elemento Int. (`j`) | Condición Int. | Salida Generada en Consola | Estado / Explicación de la Interacción |
| :--- | :---: | :---: | :---: | :---: | :--- | :--- |
| **Inicio** | - | `n = 3` (Válido) | - | - | - | Ingreso validado en rango [2, 10] |
| **Patrón 1** | 1 | 1 <= 3 (Sí) | 1 | 1 <= 1 (Sí) | `*` | Imprime 1 asterisco, fin ciclo int. Salto de línea. |
| | 2 | 2 <= 3 (Sí) | 1, 2 | 1<=2, 2<=2 (Sí) | `**` | Imprime 2 asteriscos, fin ciclo int. Salto de línea. |
| | 3 | 3 <= 3 (Sí) | 1, 2, 3 | 1<=3, 2<=3, 3<=3 | `***` | Imprime 3 asteriscos, fin ciclo int. Salto de línea. |
| | 4 | 4 <= 3 (No) | - | - | - | Fin del Patrón 1 |
| **Patrón 2** | 3 | 3 >= 1 (Sí) | 1, 2, 3 | 1<=3, 2<=3, 3<=3 | `***` | Imprime 3 asteriscos, fin ciclo int. Salto de línea. |
| | 2 | 2 >= 1 (Sí) | 1, 2 | 1<=2, 2<=2 (Sí) | `**` | Imprime 2 asteriscos, fin ciclo int. Salto de línea. |
| | 1 | 1 >= 1 (Sí) | 1 | 1 <= 1 (Sí) | `*` | Imprime 1 asterisco, fin ciclo int. Salto de línea. |
| | 0 | 0 >= 1 (No) | - | - | - | Fin del Patrón 2 |
| **Patrón 3** | 1 | 1 <= 3 (Sí) | 1 | 1 <= 1 (Sí) | `1` | Imprime valor de `j` (1). Salto de línea. |
| | 2 | 2 <= 3 (Sí) | 1, 2 | 1<=2, 2<=2 (Sí) | `12` | Imprime valores de `j` (1, luego 2). Salto de línea. |
| | 3 | 3 <= 3 (Sí) | 1, 2, 3 | 1<=3, 2<=3, 3<=3 | `123` | Imprime valores de `j` (1, 2, 3). Salto de línea. |
| | 4 | 4 <= 3 (No) | - | - | - | Fin del Patrón 3 y del programa |
