# EJERCICIO 5 - Estacionamiento universitario

### Estructuras utilizadas

| Estructura | Uso en el Ejercicio 5 |
|---|---|
| `do-while` externo | Repetir el registro de vehículos hasta que el usuario responda `N` en `respuesta`. |
| `do-while` internos | Validar que `tipo` esté entre 1 y 3, que `horas` sea mayor que cero y que `respuesta` sea `S` o `N`. |
| `switch` | Asignar la `tarifa` y aumentar el contador correspondiente según el `tipo` de vehículo. |
| `if` | Mostrar el mensaje de error cuando el tipo o las horas ingresadas no son válidos. |
| Contadores | `motos`, `autos`, `camionetas` y `totalVehiculos` cuentan los vehículos registrados. |
| Acumuladores | `totalRecaudado` suma el `pago` de cada vehículo (`horas * tarifa`). |
| Cálculo final | `promedio` = `totalRecaudado / totalVehiculos`, usado en el reporte. |
| Variable de control | `tipo` (tipo de vehículo actual) y `respuesta` (decisión de continuar o terminar). |


#### ANÁLISIS

* **Definición de Variables:**
  * **Entradas:**
    * `tipoVehiculo` (Entero): Opción seleccionada del menú (1: Motocicleta, 2: Automóvil, 3: Camioneta).
    * `horas` (Entero / Real): Horas que el vehículo permaneció estacionado (debe ser `horas > 0`).
    * `continuar` (Carácter / Entero): Respuesta del usuario para decidir si desea registrar otro vehículo (`'s'`/`'n'` o `1`/`0`).
  * **Variables de Control e Internas:**
    * `tarifaHora` (Real): Monto asignado por hora según el tipo de vehículo mediante la estructura `switch`.
    * `cobroVehiculo` (Real): Valor a pagar por el vehículo actual (`horas * tarifaHora`).
  * **Acumuladores y Contadores (Salidas):**
    * `cantMotos` (Entero): Contador de motocicletas registradas.
    * `cantAutos` (Entero): Contador de automóviles registrados.
    * `cantCamionetas` (Entero): Contador de camionetas registradas.
    * `totalVehiculos` (Entero): Suma de todos los vehículos procesados (`cantMotos + cantAutos + cantCamionetas`).
    * `totalRecaudado` (Real): Acumulador del dinero total cobrado a todos los vehículos.
    * `promedioPagado` (Real): Promedio recaudado por vehículo (`totalRecaudado / totalVehiculos`).

* **Restricciones y Validaciones:**
  * Las horas deben ser estrictamente mayores que cero (`horas > 0`), validadas con una estructura `while` o `do-while`.
  * La opción del tipo de vehículo debe estar dentro del menú válido (1, 2 o 3).
  * Si no se registra ningún vehículo (`totalVehiculos == 0`), el promedio recaudado debe ser 0 para evitar la división por cero.

* **Procesamiento y Fórmulas:**
  1. Utilizar un ciclo `do-while` principal para permitir el registro interactivo de múltiples vehículos.
  2. Solicitar el `tipoVehiculo` y determinar mediante un `switch` la tarifa correspondiente:
     * **Caso 1 (Motos):** `tarifaHora = 0.50`, incrementar `cantMotos++`.
     * **Caso 2 (Autos):** `tarifaHora = 1.00`, incrementar `cantAutos++`.
     * **Caso 3 (Camionetas):** `tarifaHora = 1.50`, incrementar `cantCamionetas++`.
  3. Solicitar y validar las `horas` de estacionamiento (`horas > 0`).
  4. Calcular el cobro individual: `cobroVehiculo = horas * tarifaHora`.
  5. Acumular el total recaudado: `totalRecaudado = totalRecaudado + cobroVehiculo`.
  6. Incrementar el total de vehículos: `totalVehiculos = totalVehiculos + 1`.
  7. Preguntar si se desea registrar otro vehículo; si la respuesta es afirmativa, repetir el ciclo `do-while`.
  8. Calcular el promedio pagado: `promedioPagado = totalRecaudado / totalVehiculos`.

* **Salidas:**
  * Reporte impreso al finalizar el ciclo con el desglose de contadores por tipo de vehículo, el total acumulado y el promedio general.

#### PSEUCODIGO

    
    Algoritmo Estacionamiento
    Definir tipo, motos, autos, camionetas, totalVehiculos Como Entero
    Definir horas, tarifa, pago, totalRecaudado, promedio Como Real
    Definir respuesta Como Caracter

    motos <- 0
    autos <- 0
    camionetas <- 0
    totalVehiculos <- 0
    totalRecaudado <- 0

    Repetir
        // Validar tipo de vehiculo
        Repetir
            Escribir "Tipo de vehiculo:"
            Escribir "1. Motocicleta"
            Escribir "2. Automovil"
            Escribir "3. Camioneta"
            Leer tipo
            Si tipo < 1 O tipo > 3 Entonces
                Escribir "Tipo no valido, elija 1, 2 o 3"
            FinSi
        Hasta Que tipo >= 1 Y tipo <= 3

        // Validar horas
        Repetir
            Escribir "Horas estacionado: "
            Leer horas
            Si horas <= 0 Entonces
                Escribir "Error: las horas deben ser mayores que cero"
            FinSi
        Hasta Que horas > 0

        // Asignar tarifa y contar segun el tipo
        Segun tipo Hacer
            1:
                tarifa <- 0.50
                motos <- motos + 1
            2:
                tarifa <- 1.00
                autos <- autos + 1
            3:
                tarifa <- 1.50
                camionetas <- camionetas + 1
        FinSegun

        pago <- horas * tarifa
        totalRecaudado <- totalRecaudado + pago
        totalVehiculos <- totalVehiculos + 1
        Escribir "Valor a pagar: $", pago

        // Preguntar si continua
        Repetir
            Escribir "Registrar otro vehiculo? (S/N): "
            Leer respuesta
            respuesta <- Mayusculas(respuesta)
            Si respuesta <> "S" Y respuesta <> "N" Entonces
                Escribir "Responda solo S o N"
            FinSi
        Hasta Que respuesta = "S" O respuesta = "N"
    Hasta Que respuesta = "N"

    // El ciclo se ejecuta al menos una vez, por eso totalVehiculos >= 1
    promedio <- totalRecaudado / totalVehiculos

    Escribir "===== REPORTE ====="
    Escribir "Motocicletas: ", motos
    Escribir "Automoviles: ", autos
    Escribir "Camionetas: ", camionetas
    Escribir "Total vehiculos: ", totalVehiculos
    Escribir "Total recaudado: $", totalRecaudado
    Escribir "Promedio pagado: $", promedio
    Escribir "==================="
FinAlgoritmo

#### PRUEBA DE ESCRITORIO

| Paso | Tipo (`tipoVehiculo`) | Horas (`horas`) | Validación Horas | Tarifa (`tarifaHora`) | Cobro (`horas * tarifa`) | `cantMotos` | `cantAutos` | `cantCamionetas` | `totalVehiculos` | `totalRecaudado` | Continuar (`continuar`) |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | - | - | - | - | 0 | 0 | 0 | 0 | 0.00 | - |
| **Vehículo 1** | 1 (Moto) | 2.0 | Válido (2.0 > 0) | 0.50 | 1.00 | 1 | 0 | 0 | 1 | 1.00 | Sí |
| **Vehículo 2** | 2 (Auto) | 3.0 | Válido (3.0 > 0) | 1.00 | 3.00 | 1 | 1 | 0 | 2 | 4.00 | Sí |
| **Vehículo 3** | 3 (Camioneta) | 4.0 | Válido (4.0 > 0) | 1.50 | 6.00 | 1 | 1 | 1 | 3 | 10.00 | No |
| **Fin Do-While**| - | - | - | - | - | 1 | 1 | 1 | 3 | 10.00 | - |

