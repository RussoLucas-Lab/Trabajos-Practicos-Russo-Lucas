import java.time.LocalDate;

public class Empleado {
    private String DNI;
    private String nombre;
    private String apellido;
    private int anioIngreso;

    public Empleado(){}

    public Empleado(String DNI, String nombre, String apellido, int anioIngreso) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioIngreso = anioIngreso;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public String nombreCompleto(){
        return this.nombre + " " + this.apellido;
    }
    public int antiguedadEnAnios(){
        int antiguedad;
        int anioActual =  LocalDate.now().getYear();
        antiguedad = anioActual - this.anioIngreso;
        return antiguedad;
    }

    public double getSalario(){
        double salario = 0.0;
        return salario;
    }
}
