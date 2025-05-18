package Kata_2;

public class Principal {

    public static void main(String[] args) {
        Pago tarjeta = new TarjetaCredito("1111.2222.3333.4444");
        tarjeta.procesarPago(9000);

        PagoConDescuento tarjetaConDescuento = new TarjetaCredito("1010.1010.1010.1010");
        double montoConDescuento = tarjetaConDescuento.aplicarDescuento(15);
        tarjetaConDescuento.procesarPago(montoConDescuento);

        Pago paypal = new PayPal("lucas@example.com");
        paypal.procesarPago(300.0);
    }
}

