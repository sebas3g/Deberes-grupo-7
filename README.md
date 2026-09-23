# Deberes-grupo-7
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
