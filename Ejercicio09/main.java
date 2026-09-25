import java.util.Scanner;
public class estadisticaEncuesta {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int estudiantes;
        int edad;
        int semestre;
        int menorDosHoras = 0;

        double horas;
        double sumaEdades = 0;
        double sumaHoras = 0;
        double mayorHoras = -1;
        int estudianteMayorHoras = 0;

        System.out.print("Ingrese la cantidad de estudiantes: ");
        estudiantes = entrada.nextInt();

        while (estudiantes <= 0) {
            System.out.print("La cantidad debe ser mayor que cero: ");
            estudiantes = entrada.nextInt();
        }

        int[] semestres = new int[estudiantes];

        for (int i = 0; i < estudiantes; i++) {

            System.out.println("\n--- Estudiante " + (i + 1) + " ---");

            System.out.print("Ingrese la edad: ");
            edad = entrada.nextInt();

            while (edad < 16 || edad > 80) {
                System.out.print("Edad incorrecta. Ingrese una edad entre 16 y 80: ");
                edad = entrada.nextInt();
            }

            System.out.print("Ingrese el semestre: ");
            semestre = entrada.nextInt();

            while (semestre < 1 || semestre > 10) {
                System.out.print("Semestre incorrecto. Ingrese un valor entre 1 y 10: ");
                semestre = entrada.nextInt();
            }

            semestres[i] = semestre;

            System.out.print("Ingrese las horas de estudio por dia: ");
            horas = entrada.nextDouble();

            while (horas < 0 || horas > 24) {
                System.out.print("Horas incorrectas. Ingrese un valor entre 0 y 24: ");
                horas = entrada.nextDouble();
            }

            sumaEdades += edad;
            sumaHoras += horas;

            if (horas > mayorHoras) {
                mayorHoras = horas;
                estudianteMayorHoras = i + 1;
            }

            if (horas < 2) {
                menorDosHoras++;
            }
        }

        double edadPromedio = sumaEdades / estudiantes;
        double horasPromedio = sumaHoras / estudiantes;

        System.out.println("\n========== RESULTADOS ==========");
        System.out.printf("Edad promedio: %.2f%n", edadPromedio);
        System.out.printf("Horas promedio de estudio: %.2f%n", horasPromedio);
        System.out.println("Estudiante con mayor cantidad de horas: Estudiante "
                + estudianteMayorHoras + " (" + mayorHoras + " horas)");
        System.out.println("Estudiantes que estudian menos de 2 horas: " + menorDosHoras);

        System.out.println("\n===== ESTUDIANTES POR SEMESTRE =====");

        for (int semestreActual = 1; semestreActual <= 10; semestreActual++) {

            int cantidadSemestre = 0;

            for (int i = 0; i < estudiantes; i++) {
                if (semestres[i] == semestreActual) {
                    cantidadSemestre++;
                }
            }

            System.out.println("Semestre " + semestreActual + ": " + cantidadSemestre);
        }

    }
    
}
