import java.util.Scanner;
public class cajero {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcion;
        int depositos = 0;
        int retiros = 0;

        double saldo = 1000;
        double monto;
        double totalDepositado = 0;
        double totalRetirado = 0;

        do {
            System.out.println("\n============================");
            System.out.println("     CAJERO ACADEMICO");
            System.out.println("============================");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar movimientos");
            System.out.println("5. Salir");
            System.out.println("============================");

            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            while (opcion < 1 || opcion > 5) {
                System.out.print("Opcion incorrecta. Ingrese una opcion del 1 al 5: ");
                opcion = entrada.nextInt();
            }

            switch (opcion) {

                case 1:
                    System.out.printf("Saldo disponible: $%.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("Ingrese el monto a depositar: ");
                    monto = entrada.nextDouble();

                    while (monto < 0) {
                        System.out.print("No se permiten depositos negativos. Ingrese nuevamente: ");
                        monto = entrada.nextDouble();
                    }

                    saldo += monto;
                    totalDepositado += monto;
                    depositos++;

                    System.out.printf("Deposito realizado. Nuevo saldo: $%.2f%n", saldo);
                    break;

                case 3:
                    System.out.print("Ingrese el monto a retirar: ");
                    monto = entrada.nextDouble();

                    while (monto < 0 || monto > saldo) {
                        if (monto < 0) {
                            System.out.print("No se permiten retiros negativos. Ingrese nuevamente: ");
                        } else {
                            System.out.print("Fondos insuficientes. Ingrese un monto valido: ");
                        }

                        monto = entrada.nextDouble();
                    }

                    saldo -= monto;
                    totalRetirado += monto;
                    retiros++;

                    System.out.printf("Retiro realizado. Nuevo saldo: $%.2f%n", saldo);
                    break;

                case 4:
                    System.out.println("\n======= MOVIMIENTOS =======");
                    System.out.println("Depositos realizados: " + depositos);
                    System.out.println("Retiros realizados: " + retiros);
                    System.out.printf("Total depositado: $%.2f%n", totalDepositado);
                    System.out.printf("Total retirado: $%.2f%n", totalRetirado);
                    System.out.println("============================");
                    break;

                case 5:
                    System.out.println("\nSaliendo del cajero...");
                    break;
            }

        } while (opcion != 5);

        System.out.println("\n========== RESUMEN FINAL ==========");
        System.out.println("Depositos realizados: " + depositos);
        System.out.println("Retiros realizados: " + retiros);
        System.out.printf("Total depositado: $%.2f%n", totalDepositado);
        System.out.printf("Total retirado: $%.2f%n", totalRetirado);
        System.out.printf("Saldo final: $%.2f%n", saldo);
        System.out.println("===================================");

    }

}
