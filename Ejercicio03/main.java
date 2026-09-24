import java.util.Scanner;
public class numeroPar {
    
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int n;
        int cantidad = 0;
        int suma = 0;
        double promedio;

        System.out.print("Ingrese un numero entero positivo: ");
        n = entrada.nextInt();

        while (n <= 0) {
            System.out.print("Valor incorrecto. Ingrese un numero positivo: ");
            n = entrada.nextInt();
        }

        System.out.println("\nSerie:");

        for (int i = 2; i <= n; i += 2) {
            System.out.print(i + " ");
            cantidad++;
            suma += i;
        }

        if (cantidad > 0) {
            promedio = (double) suma / cantidad;

            System.out.println("\nCantidad de pares: " + cantidad);
            System.out.println("Suma: " + suma);
            System.out.println("Promedio: " + promedio);
        } else {
            System.out.println("\nNo existen numeros pares hasta " + n);
            System.out.println("Cantidad de pares: 0");
            System.out.println("Suma: 0");
            System.out.println("Promedio: 0");
        }

    }
    
}
