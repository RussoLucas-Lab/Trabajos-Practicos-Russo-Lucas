package Kata_2;

public class Principal {
    public static void main(String[] args) {

        Producto<Integer> prod1 = new Producto<>(1, "Papa", 150.0);
        Producto<Integer> prod2 = new Producto<>(2, "Zanahoria", 120.0);
        Producto<Integer> prod3 = new Producto<>(3, "Lechuga", 80.0);

        Carrito<Producto<?>> carrito = new Carrito<>();

        carrito.agregarProducto(prod1);
        carrito.agregarProducto(prod2);
        carrito.agregarProducto(prod3);

        carrito.mostrarProductos();

        System.out.println("Total del carrito: $" + carrito.obtenerTotal());
    }
}