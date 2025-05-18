package Kata_2;

public class PayPal implements Pago{
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.printf("Procesando pago de $%.2f con PayPal (%s)\n", monto, email);
    }

}
