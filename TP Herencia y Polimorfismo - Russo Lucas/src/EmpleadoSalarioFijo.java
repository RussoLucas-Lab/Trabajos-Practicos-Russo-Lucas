public class EmpleadoSalarioFijo extends  Empleado{
    private final double PORC1 = 0.05;
    private final double PORC2 = 0.1;
    private final int ANIO1 = 2;
    private final int ANIO2 = 5;

    private double sueldoBasico;

    public EmpleadoSalarioFijo(String DNI, String nombre, String apellido, int anioIngreso, double sueldoBasico) {
        super(DNI, nombre, apellido, anioIngreso);
        this.sueldoBasico = sueldoBasico;
    }

    @Override
    public double getSalario(){
        double salario = 0.0;
        int antiguedad = antiguedadEnAnios();
        if (antiguedad < ANIO1){
            salario = this.sueldoBasico;
        } else if (antiguedad < ANIO2) {
            salario = this.sueldoBasico + this.sueldoBasico *PORC1;
        }else {
            salario = this.sueldoBasico + this.sueldoBasico *PORC2;
        }
        return salario;
    }
}
