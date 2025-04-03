public class Tecnico {
    private int id = 0;
    private String nombre;
    private String especialidad;

    public Tecnico(String nombre, String especialidad) {
        this.id +=1;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String mostrarTecnico(){
        return this.nombre + ", " + "id: " + this.id;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
