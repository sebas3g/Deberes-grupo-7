import java.util.Scanner;
public class CineEvalu {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int n;
        double nota;
        double suma = 0;
        double promedio;
        double mayor = 0;
        double menor = 0;

        int aprobados = 0;
        int reprobados = 0;

        // Validación del número de estudiantes
        System.out.print("Ingrese el numero de estudiantes: ");
        n = entrada.nextInt();

        while (n <= 0) {
            System.out.println("Numero incorrecto. Debe ser mayor que 0.");
            System.out.print("Ingrese el numero de estudiantes: ");
            n = entrada.nextInt();
        }

        // Procesamiento
        for (int i = 1; i <= n; i++) {

            System.out.print("Ingrese la calificacion del estudiante "
                    + i + ": ");
            nota = entrada.nextDouble();

            // Validación de la nota
            while (nota < 0 || nota > 18) {
                System.out.println(
                        "Nota incorrecta. Debe estar entre 0 y 18.");
                System.out.print("Ingrese nuevamente la calificacion: ");
                nota = entrada.nextDouble();
            }

            suma = suma + nota;

            if (nota >= 8) {
                aprobados++;
            } else {
                reprobados++;
            }

            // Nota mayor y menor
            if (i == 1) {
                mayor = nota;
                menor = nota;
            } else {
                if (nota > mayor) {
                    mayor = nota;
                }

                if (nota < menor) {
                    menor = nota;
                }
            }
        }

        promedio = suma / n;

        System.out.println();
        System.out.println("========== RESULTADOS ==========");
        System.out.println("Numero de estudiantes : " + n);
        System.out.println("Suma de calificaciones: " + suma);
        System.out.println("Promedio general      : " + promedio);
        System.out.println("Aprobados             : " + aprobados);
        System.out.println("Reprobados            : " + reprobados);
        System.out.println("Nota mas alta         : " + mayor);
        System.out.println("Nota mas baja         : " + menor);
        System.out.println("================================");

    }
}
