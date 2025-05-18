package Kata_parte_2;

import java.util.Scanner;

public class Kata_2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese el primer número : ");
            int num1 = scanner.nextInt();

            System.out.print("Ingrese el segundo número: ");
            int num2 = scanner.nextInt();

            int resultado = num1 / num2;

            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero, ingrese un divisor distinto de cero.");
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}

