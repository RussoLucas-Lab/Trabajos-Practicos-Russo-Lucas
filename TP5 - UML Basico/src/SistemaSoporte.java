import java.util.ArrayList;
import java.util.List;

public class SistemaSoporte {
    private static int contadorTickets = 0;
    private ArrayList<TicketSoporte> tickets;
    public SistemaSoporte() {
        this.tickets = new ArrayList<>();
    }
    public TicketSoporte crearTicket(String descripcion,String fechaCreacion, Usuario usuario) {
        TicketSoporte ticket = new TicketSoporte(descripcion, fechaCreacion, usuario);
        tickets.add(ticket);
        return ticket;
    }
    public TicketSoporte crearTicket(String descripcion, String fechaCreacion) {
        TicketSoporte ticket = new TicketSoporte(descripcion, fechaCreacion);
        tickets.add(ticket);
        return ticket;
    }

    public void asignarTecnicoATicket(int idTicket, Tecnico tecnico) {
        for (TicketSoporte ticket : tickets) {
            if (ticket.getId() == idTicket) {
                ticket.asignarTecnico(tecnico);
                System.out.println("Técnico asignado al ticket #" + idTicket);
                return;
            }
        }
        System.out.println(" Ticket no encontrado.");
    }

    public void listarTickets(String estado) {
        System.out.println("Total de tickets: " + tickets.size());
        System.out.println("\n Lista de tickets " + estado.toLowerCase() + "s:");
        for (TicketSoporte ticket : tickets) {
            if (ticket.getEstadoTicket() == Estado.valueOf(estado.toUpperCase())) {
                System.out.println("ticket id:"+ticket.getId() + " "+ticket.getUsuario());
            }
        }
    }
    public static int getCantidadTickets() {
        return contadorTickets;
    }

}
