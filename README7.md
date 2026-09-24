# EJERCICIO 7 - Control de ventas de cafetería

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

#### PSEUDOCODIGO 


    Algoritmo CafeteriaUniversitaria
    Definir opcion, producto, cantidad Como Entero
    Definir numVentas, cantidadTotal Como Entero
    Definir cantCafe, cantSandwich, cantJugo, cantEmpanada Como Entero
    Definir mayorCantidad Como Entero
    Definir precio, subtotal, totalRecaudado, promedio Como Real
    Definir nombreMayor Como Caracter
    

    numVentas <- 0
    cantidadTotal <- 0
    totalRecaudado <- 0
    cantCafe <- 0
    cantSandwich <- 0
    cantJugo <- 0
    cantEmpanada <- 0

    Repetir
        Escribir "================================"
        Escribir "    CAFETERIA UNIVERSITARIA"
        Escribir "================================"
        Escribir "1. Registrar venta"
        Escribir "2. Mostrar estadisticas"
        Escribir "3. Mostrar tabla de productos"
        Escribir "4. Salir"
        Escribir "================================"
        Escribir "Elija una opcion: "
        Leer opcion

        Segun opcion Hacer
            1:
                // Validar producto
                Repetir
                    Escribir "Producto (1. Cafe, 2. Sandwich, 3. Jugo, 4. Empanada): "
                    Leer producto
                    Si producto < 1 O producto > 4 Entonces
                        Escribir "Producto no valido"
                    FinSi
                Hasta Que producto >= 1 Y producto <= 4

                // Validar cantidad
                Repetir
                    Escribir "Cantidad: "
                    Leer cantidad
                    Si cantidad <= 0 Entonces
                        Escribir "La cantidad debe ser mayor que cero"
                    FinSi
                Hasta Que cantidad > 0

                // Precio y acumulador por producto
                Segun producto Hacer
                    1:
                        precio <- 1.00
                        cantCafe <- cantCafe + cantidad
                    2:
                        precio <- 2.50
                        cantSandwich <- cantSandwich + cantidad
                    3:
                        precio <- 1.50
                        cantJugo <- cantJugo + cantidad
                    4:
                        precio <- 1.25
                        cantEmpanada <- cantEmpanada + cantidad
                FinSegun

                subtotal <- precio * cantidad
                numVentas <- numVentas + 1
                cantidadTotal <- cantidadTotal + cantidad
                totalRecaudado <- totalRecaudado + subtotal
                Escribir "Venta registrada. Subtotal: $", subtotal

            2:
                Si numVentas = 0 Entonces
                    Escribir "Aun no hay ventas registradas"
                Sino
                    promedio <- totalRecaudado / numVentas

                    // Buscar el producto mas vendido
                    mayorCantidad <- cantCafe
                    nombreMayor <- "Cafe"
                    Si cantSandwich > mayorCantidad Entonces
                        mayorCantidad <- cantSandwich
                        nombreMayor <- "Sandwich"
                    FinSi
                    Si cantJugo > mayorCantidad Entonces
                        mayorCantidad <- cantJugo
                        nombreMayor <- "Jugo"
                    FinSi
                    Si cantEmpanada > mayorCantidad Entonces
                        mayorCantidad <- cantEmpanada
                        nombreMayor <- "Empanada"
                    FinSi

                    Escribir "Numero de ventas: ", numVentas
                    Escribir "Cantidad total de productos: ", cantidadTotal
                    Escribir "Total recaudado: $", totalRecaudado
                    Escribir "Promedio por venta: $", promedio
                    Escribir "Producto mas vendido: ", nombreMayor, " (", mayorCantidad, " unidades)"
                FinSi

            3:
                Escribir "No.  Producto    Precio"
                Escribir "1.   Cafe        $1.00"
                Escribir "2.   Sandwich    $2.50"
                Escribir "3.   Jugo        $1.50"
                Escribir "4.   Empanada    $1.25"

            4:
                Escribir "Hasta luego"

            De Otro Modo:
                Escribir "Opcion no valida, intente de nuevo"
        FinSegun
    Hasta Que opcion = 4
FinAlgoritmo

#### PRUEBA DE ESCRITORIO

| Paso | Opción Menú | Producto (`opcionProducto`) | Cantidad (`cantidad`) | Precio (`precioUnitario`) | Subtotal (`montoVenta`) | `totalVentas` | `totalProductos` | `totalRecaudado` | `cantCafe` | `cantSandwich` | Estado / Salida |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| **Inicio** | - | - | - | - | - | 0 | 0 | 0.00 | 0 | 0 | Sistema iniciado |
| **Venta 1** | 1 | 1 (Café) | 3 | $1.00 | $3.00 | 1 | 3 | $3.00 | 3 | 0 | Venta registrada |
| **Venta 2** | 1 | 2 (Sándwich) | 2 | $2.50 | $5.00 | 2 | 5 | $8.00 | 3 | 2 | Venta registrada |
| **Reporte**| 2 | - | - | - | - | 2 | 5 | $8.00 | 3 | 2 | Genera Estadísticas |
| **Salir** | 4 | - | - | - | - | 2 | 5 | $8.00 | 3 | 2 | Fin de ejecución |
