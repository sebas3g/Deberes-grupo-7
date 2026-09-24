### EJERCICIO 3 - Serie y suma de números pares

#### ANÁLISIS

* **Definición de Variables:**
  * **Entradas:**
    * `n` (Entero): Límite superior ingresado por el usuario para generar la serie par.
  * **Variables de Control e Internas:**
    * `i` (Entero): Contador del ciclo `for` que recorre la secuencia desde 2 hasta `n`.
    * `contadorPares` (Entero): Contador para registrar la cantidad total de números pares generados.
    * `sumaPares` (Entero): Acumulador para sumar cada número par de la serie.
  * **Salidas:**
    * `serie` (Cadena / Texto): Secuencia de números pares impresos desde 2 hasta `n`.
    * `cantidadPares` (Entero): Total de elementos en la serie par.
    * `sumaPares` (Entero): Suma acumulada de la serie.
    * `promedioPares` (Real / Double): Promedio general calculado (`sumaPares / cantidadPares`).

* **Restricciones y Validaciones:**
  * Se debe validar con un ciclo `while` que $n$ sea un entero estrictamente positivo ($n > 0$). Si se ingresa un valor negativo o cero, se debe mostrar un mensaje de error y solicitarlo nuevamente.

* **Procesamiento y Fórmulas:**
  1. Solicitar y validar la entrada $n$ mediante la estructura `while` ($n > 0$).
  2. Inicializar los acumuladores y contadores en 0 (`sumaPares = 0`, `contadorPares = 0`).
  3. Ejecutar un ciclo `for` desde `i = 2` hasta `i = n` incrementando de 2 en 2 (`i += 2`) o incrementando de 1 en 1 evaluando `i % 2 == 0`.
  4. En cada paso par:
     * Imprimir el número par actual `i`.
     * Incrementar el contador: `contadorPares = contadorPares + 1`.
     * Acumular la suma: `sumaPares = sumaPares + i`.
  5. Una vez terminado el ciclo, verificar si `contadorPares > 0` para evitar división para cero.
  6. Calcular el promedio: `promedioPares = sumaPares / contadorPares`.

* **Salidas:**
  * La serie impresa de números pares desde 2 hasta $n$.
  * Cantidad de pares generados.
  * Suma total de la serie.
  * Promedio de la serie par.
    
### PSEUDOCODIGO

Algoritmo SerieSumaPares
	Definir n, i, contador, suma Como Entero
	Definir promedio Como Real

	contador <- 0
	suma <- 0

	// Validacion de N
	Escribir "Ingrese N: "
	Leer n

	Mientras n <= 0 Hacer
		Escribir "N debe ser un valor positivo"
		Escribir "Ingrese N: "
		Leer n
	FinMientras

	Escribir "Serie: "

	Para i <- 2 Hasta n Con Paso 2 Hacer
		Escribir i
		contador <- contador + 1
		suma <- suma + i
	FinPara

	Si contador > 0 Entonces
		promedio <- suma / contador
	SiNo
		promedio <- 0
	FinSi

	Escribir "Cantidad de pares: ", contador
	Escribir "Suma: ", suma
	Escribir "Promedio: ", promedio

FinAlgoritmo

#### PRUEBAS DE ESCRITORIO

**Casos Límite y Especiales probados:**
* **Caso 1:** Ingreso inicial de valores inválidos (Negativo `-5`, Cero `0`) hasta ingresar un límite par $N = 12$.
* **Caso 2 (Límite):** $N = 1$ (Ingreso válido pero no produce ningún número par en el rango $2 \le i \le 1$).
* **Caso 3 (Límite):** $N = 2$ (Produce únicamente el primer número par).

##### Tabla 1. Ejecución Completa con Validación y Caso $N = 12$

| Paso | Entrada (`n`) | Validación (`n > 0`) | Iteración (`i`) | Condición (`i <= n`) | Imprime Serie | `contadorPares` | `sumaPares` | `promedioPares` | Salida en Consola |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | -5 | Inválido (-5 <= 0) | - | - | - | 0 | 0 | - | `"Error: Ingrese un entero positivo"` |
| **Reintento**| 0 | Inválido (0 <= 0) | - | - | - | 0 | 0 | - | `"Error: Ingrese un entero positivo"` |
| **Reintento**| 12 | Válido (12 > 0) | - | - | - | 0 | 0 | - | `"Serie: "` |
| **Iter. 1** | 12 | - | 2 | Válido (2 <= 12) | `2` | 1 | 2 | - | `2` |
| **Iter. 2** | 12 | - | 4 | Válido (4 <= 12) | `4` | 2 | 6 | - | `4` |
| **Iter. 3** | 12 | - | 6 | Válido (6 <= 12) | `6` | 3 | 12 | - | `6` |
| **Iter. 4** | 12 | - | 8 | Válido (8 <= 12) | `8` | 4 | 20 | - | `8` |
| **Iter. 5** | 12 | - | 10 | Válido (10 <= 12) | `10` | 5 | 30 | - | `10` |
| **Iter. 6** | 12 | - | 12 | Válido (12 <= 12) | `12` | 6 | 42 | - | `12` |
| **Fin Ciclo**| 12 | - | 14 | Falso (14 > 12) | - | 6 | 42 | **7.0** | `"Cantidad: 6, Suma: 42, Promedio: 7.0"` |

##### Tabla 2. Caso Límite $N = 1$

| Paso | Entrada (`n`) | Validación (`n > 0`) | Iteración (`i`) | Condición (`i <= n`) | `contadorPares` | `sumaPares` | `promedioPares` | Salida / Estado |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | 1 | Válido (1 > 0) | - | - | 0 | 0 | - | `"Serie: "` |
| **Iter. 1** | 1 | - | 2 | Falso (2 > 1) | 0 | 0 | 0.0 | No ingresa al `for`. No hay pares. |
| **Fin** | 1 | - | - | - | 0 | 0 | 0.0 | `"Cantidad: 0, Suma: 0, Promedio: 0"` |

##### Tabla 3. Caso Límite $N = 2$

| Paso | Entrada (`n`) | Validación (`n > 0`) | Iteración (`i`) | Condición (`i <= n`) | Imprime Serie | `contadorPares` | `sumaPares` | `promedioPares` | Salida en Consola |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | 2 | Válido (2 > 0) | - | - | - | 0 | 0 | - | `"Serie: "` |
| **Iter. 1** | 2 | - | 2 | Válido (2 <= 2) | `2` | 1 | 2 | - | `2` |
| **Fin Ciclo**| 2 | - | 4 | Falso (4 > 2) | - | 1 | 2 | **2.0** | `"Cantidad: 1, Suma: 2, Promedio: 2.0"` |
