public class Instrumento {
    private String id;
    private double precio;
    private Enum<TipoInstrumento> tipo;

    public Instrumento(String id, double precio, Enum<TipoInstrumento> tipo) {
        this.id = id;
        this.precio = precio;
        this.tipo = tipo;
    }
    public Instrumento(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Enum<TipoInstrumento> getTipo() {
        return tipo;
    }

    public void setTipo(Enum<TipoInstrumento> tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Instrumento{" +
                "id='" + id + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                '}';
    }
}
