# EJERCICIO 4 - Cajero automático básico

## Estructuras utilizadas
Estructura	Uso en el Ejercicio 4
do-while	Mantener el menú activo hasta que el usuario elija Salir (5 o S).
switch	Ejecutar la acción según opcion: consultar saldo, depositar, retirar, mostrar movimientos, salir o rechazar una opción inexistente (default).
if / else anidados	Validar que el depósito y el retiro sean mayores que cero, y que el retiro no supere el saldo disponible.
for	Recorrer el arreglo de movimientos desde 1 hasta numMov al elegir "Mostrar movimientos".
Contadores	depositos, retiros y numMov cuentan las operaciones realizadas.
Acumuladores	totalDepositado, totalRetirado y saldo van sumando o restando los montos de cada operación.
Variable de control	opcion (opción elegida en el menú) e i (posición del movimiento que se muestra).


#### ANÁLISIS

* **Definición de Variables:**
  * **Entradas:**
    * `opcion` (Entero): Elección del menú principal (1: Consultar saldo, 2: Depositar, 3: Retirar, 4: Mostrar movimientos, 5: Salir)[cite: 3].
    * `montoDeposito` (Real): Cantidad de dinero a ingresar al saldo (debe cumplirse que `montoDeposito > 0`)[cite: 3].
    * `montoRetiro` (Real): Cantidad de dinero a retirar del saldo (debe cumplirse que `montoRetiro > 0` y `montoRetiro <= saldo`)[cite: 3].
  * **Variables de Control e Internas:**
    * `saldo` (Real): Saldo actual de la cuenta, inicializado obligatoriamente en `$100.00`[cite: 3].
  * **Acumuladores y Contadores (Salidas):**
    * `cantDepositos` (Entero): Contador de depósitos válidos realizados[cite: 3].
    * `cantRetiros` (Entero): Contador de retiros válidos realizados[cite: 3].
    * `totalDepositado` (Real): Acumulador del dinero total depositado[cite: 3].
    * `totalRetirado` (Real): Acumulador del dinero total retirado[cite: 3].

* **Restricciones y Validaciones:**
  * Saldo inicial fijado en `$100.00`[cite: 3].
  * No permitir depósitos negativos o iguales a cero (`montoDeposito > 0`)[cite: 3].
  * No permitir retiros negativos o iguales a cero (`montoRetiro > 0`)[cite: 3].
  * No permitir retirar más dinero del disponible en la cuenta (`montoRetiro <= saldo`)[cite: 3].
  * Validar con un bloque `switch` / `default` para rechazar opciones inexistentes en el menú (diferentes a 1, 2, 3, 4 o 5)[cite: 3].

* **Procesamiento y Fórmulas:**
  1. Utilizar un ciclo `do-while` para mantener activo el sistema hasta que el usuario elija la opción 5 (Salir)[cite: 3].
  2. Implementar una estructura `switch(opcion)` para procesar las operaciones[cite: 3]:
     * **Opción 1 (Consultar saldo):** Desplegar el valor actual de `saldo`[cite: 3].
     * **Opción 2 (Depositar):** Solicitar `montoDeposito`. Validar con `while` que sea mayor a 0[cite: 3]. Actualizar las variables:
       $$\text{saldo} = \text{saldo} + \text{montoDeposito}$$
       $$\text{totalDepositado} = \text{totalDepositado} + \text{montoDeposito}$$
       $$\text{cantDepositos} = \text{cantDepositos} + 1$$
     * **Opción 3 (Retirar):** Solicitar `montoRetiro`. Validar que sea mayor a 0 y menor o igual a `saldo`[cite: 3]. Actualizar las variables:
       $$\text{saldo} = \text{saldo} - \text{montoRetiro}$$
       $$\text{totalRetirado} = \text{totalRetirado} + \text{montoRetiro}$$
       $$\text{cantRetiros} = \text{cantRetiros} + 1$$
     * **Opción 4 (Mostrar movimientos):** Mostrar un resumen parcial con `cantDepositos`, `totalDepositado`, `cantRetiros` y `totalRetirado`[cite: 3].
     * **Opción 5 (Salir):** Romper el ciclo e imprimir el reporte final de movimientos[cite: 3].
     * **Default:** Mostrar mensaje de error por opción inválida[cite: 3].

* **Salidas:**
  * Saldo actual para consultas[cite: 3].
  * Mensajes de confirmación o error de transacciones[cite: 3].
  * Reporte final acumulado con: Depósitos realizados, Retiros realizados, Total depositado, Total retirado y Saldo final[cite: 3].

#### PSEUDOCODIGO 

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

#### PRUEBA DE ESCRITORIO

| Paso | Opción Menú | Depósito (`montoDeposito`) | Retiro (`montoRetiro`) | Validación Operación | `saldo` | `cantDepositos` | `cantRetiros` | `totalDepositado` | `totalRetirado` | Estado / Mensaje de Salida |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | - | - | - | - | $100.00 | 0 | 0 | $0.00 | $0.00 | Sistema iniciado con $100[cite: 3] |
| **Paso 1** | 2 (Depositar) | $50.00 | - | Válido (50 > 0) | $150.00 | 1 | 0 | $50.00 | $0.00 | `"Depósito exitoso. Saldo: $150.00"`[cite: 3] |
| **Paso 2** | 3 (Retirar) | - | $200.00 | Inválido (200 > 150) | $150.00 | 1 | 0 | $50.00 | $0.00 | `"Error: Fondos insuficientes"`[cite: 3] |
| **Paso 3** | 3 (Retirar) | - | $30.00 | Válido (30 <= 150) | $120.00 | 1 | 1 | $50.00 | $30.00 | `"Retiro exitoso. Saldo: $120.00"`[cite: 3] |
| **Paso 4** | 5 (Salir) | - | - | Finalizar programa | $120.00 | 1 | 1 | $50.00 | $30.00 | Muestra el reporte final y termina[cite: 3] |
