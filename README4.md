
PSEUDOCODIGO 

    Algoritmo CajeroAcademico
    Definir opcion Como Caracter
    Definir saldo, monto, totalDepositado, totalRetirado Como Real
    Definir depositos, retiros, numMov, i Como Entero
    Dimension tipoMov[200], montoMov[200]
    Definir tipoMov Como Caracter
    Definir montoMov Como Rea
    
    saldo <- 100.00
    totalDepositado <- 0
    totalRetirado <- 0
    depositos <- 0
    retiros <- 0
    numMov <- 0

    Repetir
        Escribir "CAJERO ACADEMICO"
        Escribir "1. Consultar saldo"
        Escribir "2. Depositar"
        Escribir "3. Retirar"
        Escribir "4. Mostrar movimientos"
        Escribir "5. Salir (o S)"
        Escribir "Elija una opcion: "
        Leer opcion

        Segun Mayusculas(opcion) Hacer
            "1":
                Escribir "Saldo actual: $", saldo

            "2":
                Escribir "Monto a depositar: "
                Leer monto
                Si monto <= 0 Entonces
                    Escribir "Error: el deposito debe ser mayor que cero"
                Sino
                    saldo <- saldo + monto
                    totalDepositado <- totalDepositado + monto
                    depositos <- depositos + 1
                    numMov <- numMov + 1
                    tipoMov[numMov] <- "Deposito"
                    montoMov[numMov] <- monto
                    Escribir "Deposito realizado. Saldo: $", saldo
                FinSi

            "3":
                Escribir "Monto a retirar: "
                Leer monto
                Si monto <= 0 Entonces
                    Escribir "Error: el retiro debe ser mayor que cero"
                Sino
                    Si monto > saldo Entonces
                        Escribir "Error: fondos insuficientes"
                    Sino
                        saldo <- saldo - monto
                        totalRetirado <- totalRetirado + monto
                        retiros <- retiros + 1
                        numMov <- numMov + 1
                        tipoMov[numMov] <- "Retiro"
                        montoMov[numMov] <- monto
                        Escribir "Retiro realizado. Saldo: $", saldo
                    FinSi
                FinSi

            "4":
                Si numMov = 0 Entonces
                    Escribir "No hay movimientos registrados"
                Sino
                    Para i <- 1 Hasta numMov Con Paso 1 Hacer
                        Escribir i, ". ", tipoMov[i], ": $", montoMov[i]
                    FinPara
                FinSi

            "5", "S":
                Escribir "Gracias por usar el cajero"

            De Otro Modo:
                Escribir "Opcion no valida, intente de nuevo"
        FinSegun
    Hasta Que Mayusculas(opcion) = "5" O Mayusculas(opcion) = "S"

    Escribir "Depositos realizados: ", depositos
    Escribir "Retiros realizados: ", retiros
    Escribir "Total depositado: $", totalDepositado
    Escribir "Total retirado: $", totalRetirado
    Escribir "Saldo final: $", saldo
FinAlgoritmo
