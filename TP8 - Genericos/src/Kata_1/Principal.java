package Kata_1;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Lista de productos
        List<Producto<?>> productos = new ArrayList<>();

        productos.add(new Producto<Integer>(101, "Manzana", 50.0));
        productos.add(new Producto<String>("A102", "Pera", 45.5));
        productos.add(new Producto<Long>(3001L, "Naranja", 60.0));

        // Imprimir productos
        System.out.println("Lista de productos:");
        for (Producto<?> producto : productos) {
            System.out.println(producto);
        }
    }
}
