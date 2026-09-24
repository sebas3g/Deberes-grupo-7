import java.util.Scanner;
public class Parqueadero {
    
  public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int tipo;
        int horas;
        int opcion;

        int motocicletas = 0;
        int automoviles = 0;
        int camionetas = 0;
        int totalVehiculos = 0;

        double totalRecaudado = 0;
        double pago;
        double promedioPagado;

        do {
            System.out.println("\n===== ESTACIONAMIENTO UNIVERSITARIO =====");
            System.out.println("1. Motocicleta - $0.50 por hora");
            System.out.println("2. Automvil   - $1.00 por hora");
            System.out.println("3. Camioneta   - $1.50 por hora");

            System.out.print("Seleccione el tipo de vehiculo: ");
            tipo = entrada.nextInt();

            while (tipo < 1 || tipo > 3) {
                System.out.print("Tipo incorrecto. Ingrese 1, 2 o 3: ");
                tipo = entrada.nextInt();
            }

            System.out.print("Ingrese las horas estacionado: ");
            horas = entrada.nextInt();

            while (horas <= 0) {
                System.out.print("Las horas deben ser mayores que cero. Ingrese nuevamente: ");
                horas = entrada.nextInt();
            }

            switch (tipo) {
                case 1:
                    pago = horas * 0.50;
                    motocicletas++;
                    break;

                case 2:
                    pago = horas * 1.00;
                    automoviles++;
                    break;

                case 3:
                    pago = horas * 1.50;
                    camionetas++;
                    break;

                default:
                    pago = 0;
            }

            totalVehiculos++;
            totalRecaudado += pago;

            System.out.printf("Valor a pagar: $%.2f%n", pago);

            System.out.print("\nDesea registrar otro vehiculo? (1 = Si / 0 = No): ");
            opcion = entrada.nextInt();

        } while (opcion == 1);

        promedioPagado = totalRecaudado / totalVehiculos;

        System.out.println("\n========== REPORTE ==========");
        System.out.println("Motocicletas: " + motocicletas);
        System.out.println("Automoviles: " + automoviles);
        System.out.println("Camionetas: " + camionetas);
        System.out.println("Total vehiculos: " + totalVehiculos);
        System.out.printf("Total recaudado: $%.2f%n", totalRecaudado);
        System.out.printf("Promedio pagado: $%.2f%n", promedioPagado);
        System.out.println("==============================");

    }
}
