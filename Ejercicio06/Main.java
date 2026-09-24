import java.util.Scanner;
public class Triangulo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int numero;

        System.out.print("Ingrese un numero entre 2 y 10: ");
        numero = entrada.nextInt();

        while (numero < 2 || numero > 10) {
            System.out.print("Numero incorrecto. Ingrese un numero entre 2 y 10: ");
            numero = entrada.nextInt();
        }

        // Primer patron
        System.out.println("\nPrimer patron:");

        for (int i = 1; i <= numero; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Segundo patron
        System.out.println("\nSegundo patron:");

        for (int i = numero; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Tercer patron
        System.out.println("\nTercer patron:");

        for (int i = 1; i <= numero; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
