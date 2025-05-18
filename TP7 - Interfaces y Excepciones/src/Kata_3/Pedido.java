package Kata_3;

public class Pedido {
    private Cliente cliente;
    private String estado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.estado = "Pendiente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void cambiarEstado(String estadoActualizado) {
        this.estado = estadoActualizado;
        cliente.notificar("El estado de tu pedido ha cambiado a " + estadoActualizado);
    }
}
