import java.util.Scanner;
public class VentasCafeteria {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcion;
        int producto;
        int cantidad;

        int ventas = 0;
        int totalProductos = 0;

        int cafe = 0;
        int sandwich = 0;
        int jugo = 0;
        int empanada = 0;

        double totalRecaudado = 0;
        double promedioVenta;
        double subtotal;

        do {
            System.out.println("\n================================");
            System.out.println("      CAFETERIA UNIVERSITARIA");
            System.out.println("================================");
            System.out.println("1. Registrar venta");
            System.out.println("2. Mostrar estadisticas");
            System.out.println("3. Mostrar tabla de productos");
            System.out.println("4. Salir");
            System.out.println("================================");

            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            while (opcion < 1 || opcion > 4) {
                System.out.print("Opcion incorrecta. Ingrese una opcion del 1 al 4: ");
                opcion = entrada.nextInt();
            }

            switch (opcion) {

                case 1:
                    System.out.println("\n--- REGISTRAR VENTA ---");
                    System.out.println("1. Cafe        $1.00");
                    System.out.println("2. Sandwich    $2.50");
                    System.out.println("3. Jugo        $1.50");
                    System.out.println("4. Empanada    $1.25");

                    System.out.print("Seleccione el producto: ");
                    producto = entrada.nextInt();

                    while (producto < 1 || producto > 4) {
                        System.out.print("Producto incorrecto. Ingrese del 1 al 4: ");
                        producto = entrada.nextInt();
                    }

                    System.out.print("Ingrese la cantidad: ");
                    cantidad = entrada.nextInt();

                    while (cantidad <= 0) {
                        System.out.print("La cantidad debe ser mayor que cero: ");
                        cantidad = entrada.nextInt();
                    }

                    switch (producto) {
                        case 1:
                            subtotal = cantidad * 1.00;
                            cafe += cantidad;
                            break;

                        case 2:
                            subtotal = cantidad * 2.50;
                            sandwich += cantidad;
                            break;

                        case 3:
                            subtotal = cantidad * 1.50;
                            jugo += cantidad;
                            break;

                        default:
                            subtotal = cantidad * 1.25;
                            empanada += cantidad;
                            break;
                    }

                    ventas++;
                    totalProductos += cantidad;
                    totalRecaudado += subtotal;

                    System.out.printf("Total de la venta: $%.2f%n", subtotal);
                    break;

                case 2:
                    System.out.println("\n========== ESTADISTICAS ==========");

                    if (ventas > 0) {
                        promedioVenta = totalRecaudado / ventas;

                        System.out.println("Numero de ventas: " + ventas);
                        System.out.println("Cantidad total de productos: " + totalProductos);
                        System.out.printf("Total recaudado: $%.2f%n", totalRecaudado);
                        System.out.printf("Promedio por venta: $%.2f%n", promedioVenta);

                        if (cafe >= sandwich && cafe >= jugo && cafe >= empanada) {
                            System.out.println("Producto con mayor cantidad vendida: Cafe");
                        } else if (sandwich >= cafe && sandwich >= jugo && sandwich >= empanada) {
                            System.out.println("Producto con mayor cantidad vendida: Sandwich");
                        } else if (jugo >= cafe && jugo >= sandwich && jugo >= empanada) {
                            System.out.println("Producto con mayor cantidad vendida: Jugo");
                        } else {
                            System.out.println("Producto con mayor cantidad vendida: Empanada");
                        }

                    } else {
                        System.out.println("No existen ventas registradas.");
                    }

                    System.out.println("==================================");
                    break;

                case 3:
                    System.out.println("\n======= TABLA DE PRODUCTOS =======");
                    System.out.println("1. Cafe        $1.00");
                    System.out.println("2. Sandwich    $2.50");
                    System.out.println("3. Jugo        $1.50");
                    System.out.println("4. Empanada    $1.25");
                    System.out.println("==================================");
                    break;

                case 4:
                    System.out.println("\nGracias por utilizar el sistema.");
                    break;
            }

        } while (opcion != 4);

    }
}
