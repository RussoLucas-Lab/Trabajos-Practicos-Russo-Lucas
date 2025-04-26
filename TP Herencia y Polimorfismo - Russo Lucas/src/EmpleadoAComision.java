public class EmpleadoAComision extends Empleado {
    private double salarioMinimo;
    private int cantClientesCaptados;
    private double montoPorCliente;

    public EmpleadoAComision(String DNI, String nombre, String apellido, int anioIngreso, double salarioMinimo, int cantClientesCaptados, double montoPorCliente) {
        super(DNI, nombre, apellido, anioIngreso);
        this.salarioMinimo = salarioMinimo;
        this.cantClientesCaptados = cantClientesCaptados;
        this.montoPorCliente = montoPorCliente;
    }

    public double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public int getCantClientesCaptados() {
        return cantClientesCaptados;
    }

    public void setCantClientesCaptados(int cantClientesCaptados) {
        this.cantClientesCaptados = cantClientesCaptados;
    }

    public double getMontoPorCliente() {
        return montoPorCliente;
    }

    public void setMontoPorCliente(double montoPorCliente) {
        this.montoPorCliente = montoPorCliente;
    }

    @Override
    public double getSalario(){
        double comision = this.cantClientesCaptados * this.montoPorCliente;
        double salario = (comision<this.salarioMinimo) ? this.salarioMinimo : comision;
        return salario;
    }

}
