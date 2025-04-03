import java.security.cert.TrustAnchor;

public class Posnet {
    public static final double RECARGO_POR_CUOTA = 0.03;
    public static final int MINIMA_CANTIDAD_CUOTA = 1;
    public static final int MAXIMA_CANTIDAD_CUOTA = 6;

    public Ticket efectuarPago(TarjetaDeCredito tarjeta, double monto, int cantidadCuotas ){
        Ticket ticket = null;

        if(datosValidos(tarjeta, monto, cantidadCuotas)){
            double montoFinal = monto + monto * recargoCuotas(cantidadCuotas);

            if (tarjeta.tieneSaldoDisponible(montoFinal)) {
                tarjeta.descontar(montoFinal);
                String nomApe = tarjeta.nombreCompletoDeTitular();
                double montoPorCuota = montoFinal / cantidadCuotas;
                ticket = new Ticket(nomApe, montoFinal, montoPorCuota);
            }
        }

        return null;
    }

    private boolean datosValidos(TarjetaDeCredito tarjeta, double monto, int cantidadCuotas){
        boolean esTarjetaValida = tarjeta != null;
        boolean esMontoValido = monto >0;
        boolean cantCuotasValidas = cantidadCuotas>= MINIMA_CANTIDAD_CUOTA && cantidadCuotas <= MAXIMA_CANTIDAD_CUOTA;

        return esMontoValido && esTarjetaValida && cantCuotasValidas;
    }
    private double recargoCuotas(int cantidadCuotas){
        return (cantidadCuotas -1) * RECARGO_POR_CUOTA;
    }
}