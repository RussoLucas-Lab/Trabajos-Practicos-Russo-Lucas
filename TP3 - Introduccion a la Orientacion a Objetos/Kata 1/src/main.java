
public class main {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("Lucas", "Russo", "Programación II", 9);

        e1.mostrarInformacion();

        e1.bajarCalificacion(2);
        e1.mostrarInformacion();

        e1.subirCalificacion(3);
        e1.mostrarInformacion();
    }
}
