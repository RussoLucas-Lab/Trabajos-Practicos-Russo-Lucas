public class Principal {
    public static void main(String[] args) {
        SistemaSoporte sistema = new SistemaSoporte();

        Usuario u1 = new Usuario("Lucas Russo", "lucasrusso.dev@gmail.com");
        Usuario u2 = new Usuario("Felicitas Gramaglia", "feligramaglia@gmail.com");

        Tecnico t1 = new Tecnico("Cecilia Castellanos", "Sistemas de Informacion");
        Tecnico t2 = new Tecnico("Pablo Arias", "Base de Datos");

        TicketSoporte ticket1= sistema.crearTicket("No anda el Windows 11","10/10/2025", u1);
        TicketSoporte ticket2= sistema.crearTicket("No anda la base de datos","10/10/2025", u2);
        ticket1.asignarTecnico(t1);

        ticket2.asignarTecnico(t2);

        sistema.listarTickets("ABIERTO");

        ticket1.cerrarTicket();

        sistema.listarTickets("CERRADO");
    }

}
