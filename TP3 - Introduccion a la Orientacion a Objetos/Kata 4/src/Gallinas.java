public class Gallinas {

    private static int contador = 1;
    private int idGallina;
    private int edad;
    private int huevosPuestos;

    public Gallinas(int edad, int huevosPuestos) {
        this.idGallina = contador++;
        if (edad < 0) {
            System.out.println("La gallina no puede tener edad negativa");
            this.edad = 0;
        } else {
            this.edad = edad;
        }
        if (huevosPuestos < 0) {
            System.out.println("La gallina no puede colocar huevos negativos");
            this.huevosPuestos = 0;
        } else {
            this.huevosPuestos = huevosPuestos;
        }
    }

    public int getIdGallina() {
        return idGallina;
    }

    public int getEdad() {
        return edad;
    }

    public int getHuevosPuestos() {
        return huevosPuestos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setHuevosPuestos(int huevosPuestos) {
        this.huevosPuestos = huevosPuestos;
    }

    public int ponerHuevo() {
        return this.huevosPuestos++;
    }

    public int envejecer() {
        return this.edad++;
    }

    public void mostrarEstado() {
        System.out.println("Id: " + this.idGallina
                + "\nEdad: " + this.edad
                + "\nHuevos puestos: " + this.huevosPuestos);
    }
}
