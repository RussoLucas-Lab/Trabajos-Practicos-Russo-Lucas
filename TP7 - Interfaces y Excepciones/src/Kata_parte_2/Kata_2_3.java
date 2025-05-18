package Kata_parte_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kata_2_3 {
    public static void main(String[] args) {
        // Nombre del archivo a leer
        String nombreArchivo = "archivo.txt";

        File archivo = new File(nombreArchivo);

        try (Scanner lector = new Scanner(archivo)) {
            System.out.println("Contenido del archivo '" + nombreArchivo + "':");
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo '" + nombreArchivo + "' no se encontró.");
        }

        System.out.println("Programa finalizado.");
    }
}
