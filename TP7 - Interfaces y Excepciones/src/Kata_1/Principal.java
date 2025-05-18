package Kata_1;

public class Principal {
    public static void main(String[] args) {

        Producto p1 = new Producto("Banana", 150.0);
        Producto p2 = new Producto("Pera", 300.0);

        Pedido pedido = new Pedido();
        pedido.agregarProducto(p1);
        pedido.agregarProducto(p2);

        System.out.println("Total del pedido: $" + pedido.calcularTotal());
    }
}
