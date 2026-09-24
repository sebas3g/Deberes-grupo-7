# EJERCICIO 7

#### ANÁLISIS

* **Definición de Variables:**
  * **Entradas:**
    * `opcionMenu` (Entero): Elección del menú principal (1 al 4).
    * `opcionProducto` (Entero): Producto seleccionado en la venta (1: Café, 2: Sándwich, 3: Jugo, 4: Empanada).
    * `cantidad` (Entero): Unidades del producto a vender (debe cumplirse que `cantidad > 0`).
  * **Variables de Control e Internas:**
    * `precioUnitario` (Real): Precio determinado según el producto mediante `switch`.
    * `montoVenta` (Real): Subtotal calculado para la transacción (`cantidad * precioUnitario`).
  * **Acumuladores y Contadores (Salidas):**
    * `totalVentas` (Entero): Contador del número total de transacciones registradas.
    * `totalProductos` (Entero): Acumulador del número total de unidades vendidas (`totalProductos + cantidad`).
    * `totalRecaudado` (Real): Acumulador del dinero recaudado (`totalRecaudado + montoVenta`).
    * `cantCafe`, `cantSandwich`, `cantJugo`, `cantEmpanada` (Enteros): Acumuladores individuales de unidades por producto para determinar cuál fue el más vendido.
    * `promedioPorVenta` (Real): Promedio del valor recaudado por transacción (`totalRecaudado / totalVentas`).
    * `productoMasVendido` (Texto): Nombre del producto con mayor cantidad acumulada de unidades vendidas.

* **Restricciones y Validaciones:**
  * Menú principal validado para aceptar únicamente opciones del 1 al 4.
  * Selección de producto validada estrictamente entre 1 y 4.
  * La cantidad vendida debe ser mayor a cero (`cantidad > 0`).
  * Si no se han registrado ventas (`totalVentas == 0`), las estadísticas deberán mostrar ceros para prevenir división entre cero.

* **Procesamiento y Fórmulas:**
  1. Utilizar un ciclo `do-while` principal para desplegar el menú de forma interactiva hasta seleccionar la opción 4 (Salir).
  2. Mediante la estructura `switch`:
     * **Opción 1 (Registrar venta):**
       * Solicitar y validar `opcionProducto`.
       * Determinar el `precioUnitario` ($1.00, $2.50, $1.50 o $1.25).
       * Solicitar y validar la `cantidad` (`cantidad > 0`).
       * Sumar la cantidad al acumulador específico del producto seleccionado.
       * Calcular `montoVenta = cantidad * precioUnitario`.
       * Acumular `totalRecaudado += montoVenta`, `totalProductos += cantidad` y `totalVentas++`.
     * **Opción 2 (Mostrar estadísticas):**
       * Calcular `promedioPorVenta = totalRecaudado / totalVentas` (si `totalVentas > 0`).
       * Evaluar mediante condicionales `if-else` cuál acumulador individual (`cantCafe`, `cantSandwich`, etc.) es el mayor para asignar a `productoMasVendido`.
       * Desplegar el reporte completo en pantalla.
     * **Opción 3 (Mostrar tabla de productos):** Imprimir la lista de precios.
     * **Opción 4 (Salir):** Finalizar la ejecución.

* **Salidas:**
  * Reporte de estadísticas con: número de ventas, cantidad total de productos, total recaudado, promedio por venta y producto con mayor cantidad vendida.


### PRUEBA DE ESCRITORIO

| Paso | Opción Menú | Producto (`opcionProducto`) | Cantidad (`cantidad`) | Precio (`precioUnitario`) | Subtotal (`montoVenta`) | `totalVentas` | `totalProductos` | `totalRecaudado` | `cantCafe` | `cantSandwich` | Estado / Salida |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | - | - | - | - | - | 0 | 0 | 0.00 | 0 | 0 | Sistema iniciado |
| **Venta 1** | 1 | 1 (Café) | 3 | $1.00 | $3.00 | 1 | 3 | $3.00 | 3 | 0 | Venta registrada |
| **Venta 2** | 1 | 2 (Sándwich) | 2 | $2.50 | $5.00 | 2 | 5 | $8.00 | 3 | 2 | Venta registrada |
| **Reporte**| 2 | - | - | - | - | 2 | 5 | $8.00 | 3 | 2 | Genera Estadísticas |
| **Salir** | 4 | - | - | - | - | 2 | 5 | $8.00 | 3 | 2 | Fin de ejecución |
