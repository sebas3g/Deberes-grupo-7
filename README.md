# Deberes-grupo-7
ANÁLISIS
•	Entradas:
	o	Número de estudiantes N (debe ser N > 0).
	o	Las N calificaciones individuales (cada calificación debe estar en el rango [0, 10]).
	Restricciones y Validaciones:
    o	Uso de estructura while para validar que N > 0 y que cada nota esté entre 0 y 10.

•	Procesamiento:
	o	Acumular las notas para calcular la suma total y el promedio general.
	o	Contar cuántos estudiantes aprobaron (nota >= 7.0) y cuántos reprobaron (nota < 7.0).
	o	Determinar la nota máxima y la nota mínima procesadas.
	o	Uso de estructura for para iterar exactamente N veces.

•	Salidas:
	o	Número total de estudiantes.
	o	Suma total de calificaciones.
	o	Promedio general.
	o	Cantidad de aprobados y reprobados.
	o	Nota más alta y nota más baja.

PRUEBA DE ESCRITORIO

| Paso | Iteración (`i`) | `N` | Entrada (`nota`) | Validación Nota | `suma` | `aprobados` | `reprobados` | `notaMaxima` | `notaMinima` | `promedio` |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | 3 | - | Válido (3 > 0) | 0.0 | 0 | 0 | -1.0 | 11.0 | - |
| **Iteración 1** | 1 | 3 | 0.0 | Válida (0 entre 0 y 10) | 0.0 | 0 | 1 | 0.0 | 0.0 | - |
| **Iteración 2** | 2 | 3 | 7.0 | Válida (7 entre 0 y 10) | 7.0 | 1 | 1 | 7.0 | 0.0 | - |
| **Iteración 3** | 3 | 3 | 10.0 | Válida (10 entre 0 y 10) | 17.0 | 2 | 1 | 10.0 | 0.0 | - |
| **Fin Ciclo** | - | 3 | - | - | 17.0 | 2 | 1 | 10.0 | 0.0 | **5.67** |

DIAGRAMA DE FLUJO 
<img width="2280" height="8140" alt="image" src="https://github.com/user-attachments/assets/fdde3d2c-da44-4461-84ef-17df2e55f607" />

PSEUDOCODIGO
Algoritmo ControlCalificaciones
	Definir n, i, nota, suma, aprobados, reprobados, notaMax, notaMin Como Entero
	Definir promedio Como Real

	suma <- 0
	aprobados <- 0
	reprobados <- 0

	// Validacion del numero de estudiantes
	Escribir "Ingrese el numero de estudiantes: "
	Leer n

	Mientras n <= 0 Hacer
		Escribir "El numero de estudiantes debe ser mayor que cero"
		Escribir "Ingrese el numero de estudiantes: "
		Leer n
	FinMientras

	// Procesamiento con For
	Para i <- 1 Hasta n Con Paso 1 Hacer

		Escribir "Ingrese la calificacion del estudiante ", i, ": "
		Leer nota

		Mientras nota < 1 O nota > 18 Hacer
			Escribir "Calificacion invalida. Debe estar entre 1 y 18"
			Escribir "Ingrese la calificacion del estudiante ", i, ": "
			Leer nota
		FinMientras

		suma <- suma + nota

		Si nota >= 14 Entonces
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
