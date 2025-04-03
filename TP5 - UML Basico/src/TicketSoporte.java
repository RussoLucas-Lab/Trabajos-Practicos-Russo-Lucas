public class TicketSoporte {
    private static int contador = 0;
    private int id;
    private String descripcion;
    private String fechaCreacion;
    private Estado estadoTicket;
    private Usuario usuario;
    private Tecnico tecnico;

    //Constructor SIN usuario
    public TicketSoporte(String descripcion, String fechaCreacion) {
        this.id = ++contador;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        estadoTicket = Estado.ABIERTO;
        this.tecnico = null;
    }

    //constructor CON usuario
    public TicketSoporte(String descripcion, String fechaCreacion, Usuario usuario) {
        this.id = ++contador;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        estadoTicket = Estado.ABIERTO;
        this.tecnico = null;
        this.usuario = usuario;
    }

    public void  cerrarTicket(){
        estadoTicket = Estado.CERRADO;
    }

    public void asignarTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public int getId() {
        return id;
    }

    public Estado getEstadoTicket() {
        return estadoTicket;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void mostrarDetalle() {

        if (usuario == null) {
            System.out.println("TicketSoporte{" +
                    "id=" + id +
                    ", descripcion='" + descripcion + '\'' +
                    ", fechaCreacion='" + fechaCreacion + '\'' +
                    ", estadoTicket=" + estadoTicket +
                    "tecnico=" + tecnico.toString() +
                    '}');
        } else{
            System.out.println("TicketSoporte{" +
                    "id=" + id +
                    ", descripcion='" + descripcion + '\'' +
                    ", fechaCreacion='" + fechaCreacion + '\'' +
                    ", estadoTicket=" + estadoTicket +
                    "TicketSoporte{" +
                    "tecnico=" + tecnico +
                     ", usuario=" + usuario.toString() +
                    '}');
        }
    }


}
