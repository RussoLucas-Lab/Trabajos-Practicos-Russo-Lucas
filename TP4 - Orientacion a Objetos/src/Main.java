public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Lucas", "Web Developer", 2500.00);
        Empleado e2 = new Empleado("Juan", "Junior Developer");
        Empleado e3 = new Empleado("Luciana");


        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println("");
        e1.actualizarSalario(50);
        e2.actualizarSalario(500.00);

        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println("");

        System.out.println("Cantidad de empleados: " + Empleado.mostrarTotalEmpleados());

    }
}
