public class Ticket {
    private String nombreApellido;
    private double montoTotal;
    private double montoCuota;

    public Ticket(String nombreApellido, double montoTotal, double montoCuota) {
        this.nombreApellido = nombreApellido;
        this.montoTotal = montoTotal;
        this.montoCuota = montoCuota;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "nombreApellido='" + nombreApellido + '\'' +
                ", montoTotal=" + montoTotal +
                ", montoCuota=" + montoCuota +
                '}';
    }
}
