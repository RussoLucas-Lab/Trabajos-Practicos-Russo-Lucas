public class Usuario {
    private int id = 0;
    private String nombre;
    private String mail;

    public Usuario(String nombre, String mail) {
        this.id += 1;
        this.nombre = nombre;
        this.mail = mail;
    }
    public String mostrarUsuario(){
       return this.nombre + ", " + "id: " + this.id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
