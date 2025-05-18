package Kata_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        Producto<Integer> papa = new Producto<>(1, "Papa", 150.0);
        Producto<Integer> zanahoria = new Producto<>(2, "Zanahoria", 120.0);
        Producto<Integer> lechuga = new Producto<>(3, "Lechuga", 80.0);
        Producto<Integer> tomate = new Producto<>(4, "Tomate", 200.0);

        Pedido pedido1 = new Pedido(101, LocalDate.of(2025, 5, 10));
        pedido1.agregarProducto(papa);
        pedido1.agregarProducto(lechuga);

        Pedido pedido2 = new Pedido(102, LocalDate.of(2025, 5, 8));
        pedido2.agregarProducto(zanahoria);
        pedido2.agregarProducto(tomate);
        pedido2.agregarProducto(papa);

        Pedido pedido3 = new Pedido(103, LocalDate.of(2025, 5, 12));
        pedido3.agregarProducto(tomate);

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        Collections.sort(pedidos);
        System.out.println("Pedidos ordenados por TOTAL:");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }

        Collections.sort(pedidos, new ComparadorPedidosPorFecha());
        System.out.println("\nPedidos ordenados por FECHA:");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
}