import java.util.Scanner;
public class ParqueaderoUni {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int opcion;
        int tipo;
        int rol;
        int horas;
        int dia;
        int boleto;

        int totalVehiculos = 0;
        int motos = 0;
        int automoviles = 0;
        int camionetas = 0;

        int estudiantes = 0;
        int docentes = 0;
        int visitantes = 0;

        int totalHoras = 0;

        double totalRecaudado = 0;
        double mayorPago = 0;
        double menorPago = 0;
        double pago;
        double tarifa;

        // Arreglos para guardar los datos de los vehiculos
        String[] tipos = new String[100];
        String[] roles = new String[100];
        String[] dias = new String[100];
        int[] horasRegistradas = new int[100];
        double[] pagos = new double[100];

        do {

            System.out.println("\n===================================");
            System.out.println("       PARQUEADERO UNIVERSITARIO");
            System.out.println("===================================");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Mostrar vehiculos registrados");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Mostrar recaudacion");
            System.out.println("5. Salir");
            System.out.println("===================================");

            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            while (opcion < 1 || opcion > 5) {
                System.out.print("Opcion incorrecta. Ingrese del 1 al 5: ");
                opcion = entrada.nextInt();
            }

            switch (opcion) {

                case 1:

                    // Caso limite: capacidad maxima
                    if (totalVehiculos >= 100) {
                        System.out.println("\nEl parqueadero ha alcanzado su capacidad maxima.");
                        break;
                    }

                    System.out.println("\n===== REGISTRAR VEHICULO =====");

                    System.out.println("1. Motocicleta - $0.50 por hora");
                    System.out.println("2. Automovil   - $1.00 por hora");
                    System.out.println("3. Camioneta   - $1.50 por hora");

                    System.out.print("Seleccione el tipo de vehiculo: ");
                    tipo = entrada.nextInt();

                    while (tipo < 1 || tipo > 3) {
                        System.out.print("Tipo incorrecto. Ingrese 1, 2 o 3: ");
                        tipo = entrada.nextInt();
                    }

                    System.out.println("\n1. Estudiante");
                    System.out.println("2. Docente");
                    System.out.println("3. Visitante");

                    System.out.print("Seleccione el rol: ");
                    rol = entrada.nextInt();

                    while (rol < 1 || rol > 3) {
                        System.out.print("Rol incorrecto. Ingrese 1, 2 o 3: ");
                        rol = entrada.nextInt();
                    }

                    System.out.print("Ingrese el numero de horas: ");
                    horas = entrada.nextInt();

                    while (horas <= 0) {
                        System.out.print("Las horas deben ser mayores que cero: ");
                        horas = entrada.nextInt();
                    }

                    System.out.println("\n1. Lunes");
                    System.out.println("2. Martes");
                    System.out.println("3. Miercoles");
                    System.out.println("4. Jueves");
                    System.out.println("5. Viernes");
                    System.out.println("6. Sabado");
                    System.out.println("7. Domingo");

                    System.out.print("Seleccione el dia: ");
                    dia = entrada.nextInt();

                    while (dia < 1 || dia > 7) {
                        System.out.print("Dia incorrecto. Ingrese del 1 al 7: ");
                        dia = entrada.nextInt();
                    }

                    System.out.print("¿Perdio el boleto? 1 = Si / 2 = No: ");
                    boleto = entrada.nextInt();

                    while (boleto < 1 || boleto > 2) {
                        System.out.print("Opcion incorrecta. Ingrese 1 o 2: ");
                        boleto = entrada.nextInt();
                    }

                    // Determinar tarifa segun el tipo
                    switch (tipo) {
                        case 1:
                            tarifa = 0.50;
                            tipos[totalVehiculos] = "Motocicleta";
                            motos++;
                            break;

                        case 2:
                            tarifa = 1.00;
                            tipos[totalVehiculos] = "Automovil";
                            automoviles++;
                            break;

                        default:
                            tarifa = 1.50;
                            tipos[totalVehiculos] = "Camioneta";
                            camionetas++;
                            break;
                    }

                    // Determinar rol
                    switch (rol) {
                        case 1:
                            roles[totalVehiculos] = "Estudiante";
                            estudiantes++;
                            pago = horas * tarifa * 0.90;
                            break;

                        case 2:
                            roles[totalVehiculos] = "Docente";
                            docentes++;
                            pago = horas * tarifa * 0.95;
                            break;

                        default:
                            roles[totalVehiculos] = "Visitante";
                            visitantes++;
                            pago = horas * tarifa;
                            break;
                    }

                    // Recargo por boleto perdido
                    if (boleto == 1) {
                        pago += 5.00;
                    }

                    // Guardar datos
                    switch (dia) {
                        case 1:
                            dias[totalVehiculos] = "Lunes";
                            break;
                        case 2:
                            dias[totalVehiculos] = "Martes";
                            break;
                        case 3:
                            dias[totalVehiculos] = "Miercoles";
                            break;
                        case 4:
                            dias[totalVehiculos] = "Jueves";
                            break;
                        case 5:
                            dias[totalVehiculos] = "Viernes";
                            break;
                        case 6:
                            dias[totalVehiculos] = "Sabado";
                            break;
                        default:
                            dias[totalVehiculos] = "Domingo";
                            break;
                    }

                    horasRegistradas[totalVehiculos] = horas;
                    pagos[totalVehiculos] = pago;

                    totalVehiculos++;
                    totalHoras += horas;
                    totalRecaudado += pago;

                    if (totalVehiculos == 1) {
                        mayorPago = pago;
                        menorPago = pago;
                    } else {
                        if (pago > mayorPago) {
                            mayorPago = pago;
                        }

                        if (pago < menorPago) {
                            menorPago = pago;
                        }
                    }

                    System.out.printf("Valor a pagar: $%.2f%n", pago);
                    System.out.println("Vehiculo registrado correctamente.");

                    break;

                case 2:

                    System.out.println("\n===== VEHICULOS REGISTRADOS =====");

                    if (totalVehiculos == 0) {
                        System.out.println("No existen vehiculos registrados.");
                    } else {

                        // Ciclo anidado para mostrar la informacion organizada
                        for (int i = 0; i < totalVehiculos; i++) {

                            System.out.println("\nVehiculo " + (i + 1));
                            System.out.println("Tipo: " + tipos[i]);
                            System.out.println("Rol: " + roles[i]);
                            System.out.println("Horas: " + horasRegistradas[i]);
                            System.out.println("Dia: " + dias[i]);
                            System.out.printf("Valor pagado: $%.2f%n", pagos[i]);

                            for (int j = 1; j <= 1; j++) {
                                System.out.println("-------------------------------");
                            }
                        }
                    }

                    break;

                case 3:

                    System.out.println("\n========== ESTADISTICAS ==========");

                    if (totalVehiculos == 0) {

                        System.out.println("No existen datos para mostrar.");

                    } else {

                        double promedioHoras = (double) totalHoras / totalVehiculos;

                        System.out.println("Vehiculos registrados: " + totalVehiculos);

                        System.out.println("\n--- POR TIPO ---");
                        System.out.println("Motocicletas: " + motos);
                        System.out.println("Automoviles: " + automoviles);
                        System.out.println("Camionetas: " + camionetas);

                        System.out.println("\n--- POR ROL ---");
                        System.out.println("Estudiantes: " + estudiantes);
                        System.out.println("Docentes: " + docentes);
                        System.out.println("Visitantes: " + visitantes);

                        System.out.println("\n--- TIEMPO ---");
                        System.out.println("Total de horas: " + totalHoras);
                        System.out.printf("Promedio de permanencia: %.2f horas%n",
                                promedioHoras);

                        System.out.println("\n--- PAGOS ---");
                        System.out.printf("Mayor valor pagado: $%.2f%n", mayorPago);
                        System.out.printf("Menor valor pagado: $%.2f%n", menorPago);
                    }

                    break;

                case 4:

                    System.out.println("\n========== RECAUDACION ==========");

                    if (totalVehiculos == 0) {
                        System.out.println("No existen vehiculos registrados.");
                    } else {

                        System.out.printf("Total recaudado: $%.2f%n",
                                totalRecaudado);

                        System.out.printf("Mayor pago: $%.2f%n",
                                mayorPago);

                        System.out.printf("Menor pago: $%.2f%n",
                                menorPago);

                        System.out.println("Cantidad de vehiculos: "
                                + totalVehiculos);
                    }

                    break;

                case 5:

                    System.out.println("\nGracias por utilizar el Parqueadero Universitario.");
                    break;
            }

        } while (opcion != 5);

    }
    
}
