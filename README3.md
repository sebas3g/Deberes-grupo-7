PSEUDOCODIGO
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
