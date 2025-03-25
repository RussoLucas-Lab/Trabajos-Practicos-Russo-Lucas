public class Empleado {
    private int id = 0;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0;

    public Empleado(String nombre, String puesto, double salario) {
        this.id = id++;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++;

    }

    //Constructores sobrescritos
    public Empleado(String nombre, String puesto) {
        this.id = 99;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 1500;
        totalEmpleados++;
    }

    public Empleado(String nombre) {
        this.id = 101;
        this.nombre = nombre;
        this.puesto = "Senior Developer";
        this.salario = 1500;
        totalEmpleados++;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public static int getTotalEmpleados() {
        return totalEmpleados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void actualizarSalario(int porcentaje) {
        this.salario += (this.salario * porcentaje / 100);
    }

    public void actualizarSalario(double cantFija) {
        this.salario += cantFija;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                '}';
    }

    public static int mostrarTotalEmpleados() {
        return Empleado.totalEmpleados;
    }
}
