package Kata_parte_2;

import java.util.Scanner;

public class Kata_2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();

            // Validar la edad
            if (edad < 0 || edad > 120) {
                throw new EdadInvalidaException("Edad inválida: debe estar entre 0 y 120 años.");
            }

            System.out.println("Edad ingresada correctamente: " + edad);
        } catch (EdadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: Por favor ingrese un número válido.");
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}
