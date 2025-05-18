package Kata_2;

public class TarjetaCredito implements PagoConDescuento{
    private String numeroTarjeta;

    public TarjetaCredito(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.printf("Procesando pago de $%.2f con tarjeta %s\n", monto, numeroTarjeta);
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        System.out.println("Aplicando descuento del " + porcentaje + "% con tarjeta.");
        return 100.0 * (1 - porcentaje / 100.0); // ejemplo: un monto base de $100 con descuento
    }
}

