package Kata_4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Productos verdulería
        Producto<Integer> papa = new Producto<>(1, "Papa", 150.0);
        Producto<Integer> zanahoria = new Producto<>(2, "Zanahoria", 120.0);
        Producto<Integer> lechuga = new Producto<>(3, "Lechuga", 80.0);

        // Pedidos
        Pedido pedido1 = new Pedido(1001, LocalDate.of(2025, 5, 10));
        pedido1.agregarProducto(papa);

        Pedido pedido2 = new Pedido(1002, LocalDate.of(2025, 5, 11));
        pedido2.agregarProducto(zanahoria);
        pedido2.agregarProducto(lechuga);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);

        // Búsqueda
        Buscador<Pedido, Integer> buscador = new Buscador<>();
        Pedido encontrado = buscador.buscar(pedidos, 1002);

        if (encontrado != null) {
            System.out.println("Pedido encontrado: " + encontrado);
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }
}
