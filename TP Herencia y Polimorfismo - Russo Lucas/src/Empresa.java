import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    public Empresa(){};

    public void agregarEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }
    public Empleado empleadoConMasClientes(){
        Empleado empleadoConMasClientes = null;
        int maxClientes = -1;
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoAComision) {
                EmpleadoAComision comisionEmpleado = (EmpleadoAComision) empleado;
                if (comisionEmpleado.getCantClientesCaptados() > maxClientes) {
                    maxClientes = comisionEmpleado.getCantClientesCaptados();
                    empleadoConMasClientes = empleado;
                }
            }
    }
        return empleadoConMasClientes;
}
}
