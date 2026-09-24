# EJERCICIO 5

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



##### PRUEBA DE ESCRITORIO

| Paso | Tipo (`tipoVehiculo`) | Horas (`horas`) | Validación Horas | Tarifa (`tarifaHora`) | Cobro (`horas * tarifa`) | `cantMotos` | `cantAutos` | `cantCamionetas` | `totalVehiculos` | `totalRecaudado` | Continuar (`continuar`) |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **Inicio** | - | - | - | - | - | 0 | 0 | 0 | 0 | 0.00 | - |
| **Vehículo 1** | 1 (Moto) | 2.0 | Válido (2.0 > 0) | 0.50 | 1.00 | 1 | 0 | 0 | 1 | 1.00 | Sí |
| **Vehículo 2** | 2 (Auto) | 3.0 | Válido (3.0 > 0) | 1.00 | 3.00 | 1 | 1 | 0 | 2 | 4.00 | Sí |
| **Vehículo 3** | 3 (Camioneta) | 4.0 | Válido (4.0 > 0) | 1.50 | 6.00 | 1 | 1 | 1 | 3 | 10.00 | No |
| **Fin Do-While**| - | - | - | - | - | 1 | 1 | 1 | 3 | 10.00 | - |

