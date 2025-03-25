public class Mascota {
    private String nombre;
    private String especie;
    private Integer edad;

    public Mascota(String nombre, String especie, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer cumplirAnios() {
        this.edad++;
        System.out.println("¡Feliz cumpleaños "+nombre+"!\n");
        return this.edad;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre
                + "\nEspecie: " + this.especie
                + "\nEdad: " + this.edad +"\n");
    }
}
