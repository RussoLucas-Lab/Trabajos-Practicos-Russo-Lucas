package Kata_parte_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KAta_2_5 {
    public static void main(String[] args) {
        String nombreArchivo = "archivo.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            System.out.println("Contenido del archivo '" + nombreArchivo + "':");
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Programa finalizado.");
    }
}
