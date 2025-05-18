package Kata_parte_2;

import java.util.Scanner;

public class Kata_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        String entrada = scanner.nextLine();

        try {
            int numero = Integer.parseInt(entrada);
            System.out.println("Número ingresado: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: La entrada no es un número entero válido.");
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}
