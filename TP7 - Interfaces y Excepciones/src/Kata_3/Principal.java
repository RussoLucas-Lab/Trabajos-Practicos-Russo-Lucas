package Kata_3;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Lucas", "lucas@example.com");
        Pedido pedido = new Pedido(cliente);

        System.out.println("Estado actual: " + pedido.getEstado());

        pedido.cambiarEstado("Pendiente de envio");
        pedido.cambiarEstado("Entregado");


    }
}

