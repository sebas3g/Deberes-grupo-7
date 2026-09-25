PSEUDOCODIGO
    
    Algoritmo EstadisticasEncuestaUniversitaria
    Definir nEstudiantes, i, j Como Entero
    Definir edad, semestre, contadorMenos2Horas Como Entero
    Definir horasEstudio, sumaEdad, sumaHoras Como Real
    Definir maxHoras, promEdad, promHoras Como Real
    Definir estudianteMaxHoras Como Entero

     Escribir "============================================="
    Escribir "    ENCUESTA DE ESTUDIANTES UNIVERSITARIOS   "
    Escribir "============================================="
    Escribir "Ingrese la cantidad de estudiantes a encuestar:"
    Leer nEstudiantes
    
    Mientras nEstudiantes <= 0 Hacer
        Escribir "Error: La cantidad debe ser mayor a 0. Intente nuevamente:"
        Leer nEstudiantes
    FinMientras
    
    // Arreglo para almacenar el semestre de cada estudiante y procesarlo con ciclos anidados
    Dimension semestresEstudiantes[nEstudiantes]
    
    sumaEdad <- 0
    sumaHoras <- 0
    maxHoras <- -1
    estudianteMaxHoras <- 0
    contadorMenos2Horas <- 0
    
    Para i <- 1 Hasta nEstudiantes Con Paso 1 Hacer
        Escribir ""
        Escribir "---------------------------------------------"
        Escribir "DATOS DEL ESTUDIANTE ", i
        Escribir "---------------------------------------------"
        
        // Validación de Edad (16 - 80)
        Repetir
            Escribir "Ingrese la edad (16 - 80):"
            Leer edad
            Si edad < 16 O edad > 80 Entonces
                Escribir "Error: La edad debe estar comprendida entre 16 y 80 anos."
            FinSi
        Hasta Que edad >= 16 Y edad <= 80
        
        // Validación de Semestre (1 - 10)
        Repetir
            Escribir "Ingrese el semestre (1 - 10):"
            Leer semestre
            Si semestre < 1 O semestre > 10 Entonces
                Escribir "Error: El semestre debe estar comprendido entre 1 y 10."
            FinSi
        Hasta Que semestre >= 1 Y semestre <= 10
        
        semestresEstudiantes[i] <- semestre
        
        // Validación de Horas de estudio (0 - 24)
        Repetir
            Escribir "Ingrese las horas de estudio diarias (0 - 24):"
            Leer horasEstudio
            Si horasEstudio < 0 O horasEstudio > 24 Entonces
                Escribir "Error: Las horas deben estar comprendidas entre 0 y 24."
            FinSi
        Hasta Que horasEstudio >= 0 Y horasEstudio <= 24
        
        // Acumuladores
        sumaEdad <- sumaEdad + edad
        sumaHoras <- sumaHoras + horasEstudio
        
        // Estudiante con mayor número de horas
        Si horasEstudio > maxHoras Entonces
            maxHoras <- horasEstudio
            estudianteMaxHoras <- i
        FinSi
        
        // Estudiantes con menos de 2 horas
        Si horasEstudio < 2 Entonces
            contadorMenos2Horas <- contadorMenos2Horas + 1
        FinSi
    FinPara
    
    // Promedios
    promEdad <- sumaEdad / nEstudiantes
    promHoras <- sumaHoras / nEstudiantes
    
    // Impresión de Resultados
    Escribir ""
    Escribir "============================================="
    Escribir "          RESULTADOS DE LA ENCUESTA          "
    Escribir "============================================="
    Escribir "Edad promedio: ", promEdad, " anos"
    Escribir "Horas promedio de estudio: ", promHoras, " horas/dia"
    Escribir "Estudiante con mayor cantidad de horas: Estudiante #", estudianteMaxHoras, " (", maxHoras, " horas/dia)"
    Escribir "Estudiantes que estudian menos de 2 horas: ", contadorMenos2Horas
    Escribir ""
    Escribir "--- CANTIDAD DE ESTUDIANTES POR SEMESTRE ---"
    
    // Estrategia con ciclos anidados para conteo por semestre (del 1 al 10)
    Para j <- 1 Hasta 10 Con Paso 1 Hacer
        Definir contadorSemestre Como Entero
        contadorSemestre <- 0
        
        Para i <- 1 Hasta nEstudiantes Con Paso 1 Hacer
            Si semestresEstudiantes[i] == j Entonces
                contadorSemestre <- contadorSemestre + 1
            FinSi
        FinPara
        
        Escribir "Semestre ", j, ": ", contadorSemestre, " estudiante(s)"
    FinPara
    
FinAlgoritmo
