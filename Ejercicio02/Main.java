import java.util.Scanner;
public class TablaDeMultiplicar {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int tablaInicial;
        int tablaFinal;
        int multiplicador;

        System.out.print("Ingrese la tabla inicial: ");
        tablaInicial = entrada.nextInt();

        System.out.print("Ingrese la tabla final: ");
        tablaFinal = entrada.nextInt();

        // Validación
        while (tablaInicial > tablaFinal) {
            System.out.println("Error: la tabla inicial no puede ser mayor que la tabla final.");

            System.out.print("Ingrese la tabla inicial: ");
            tablaInicial = entrada.nextInt();

            System.out.print("Ingrese la tabla final: ");
            tablaFinal = entrada.nextInt();
        }

        // Hasta qué número se multiplicará
        System.out.print("Hasta que multiplicador desea generar las tablas?: ");
        multiplicador = entrada.nextInt();

        while (multiplicador <= 0) {
            System.out.println("El multiplicador debe ser mayor que 0.");
            System.out.print("Ingrese nuevamente el multiplicador: ");
            multiplicador = entrada.nextInt();
        }

        System.out.println();

        // FOR externo: recorre las tablas
        for (int tabla = tablaInicial; tabla <= tablaFinal; tabla++) {

            System.out.println("TABLA DEL " + tabla);

            // FOR interno: realiza las multiplicaciones
            for (int i = 1; i <= multiplicador; i++) {
                System.out.println(tabla + " x " + i + " = " + (tabla * i));
            }

            System.out.println();
        }

    }
}
   
