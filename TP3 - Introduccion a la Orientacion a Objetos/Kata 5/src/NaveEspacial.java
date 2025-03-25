public class NaveEspacial {
    private String nombre;
    private int combustible;

    public NaveEspacial(String nombre, int combustible) {
        this.nombre = nombre;
        if (combustible < 0) {
            System.out.println("No se puede colocar un número negativo");
            this.combustible = 0;
        } else {
            this.combustible = combustible;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCombustible() {
        return combustible;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCombustible(int combustibleNuevo) {

        if (combustibleNuevo < 0) {
            System.out.println("No se puede colocar un número negativo");
            this.combustible = 0;
        } else {
            this.combustible = combustible;
        }
    }

    public int despegar() {
        if (this.combustible < 10) {
            System.out.println("No se puede despegar, combustible insuficiente");
        } else {
            this.combustible = this.combustible - 10;
        }
        return this.combustible;
    }

    public int avanzar(int distancia) {
        int combustibleConsumidoDistancia = 1;
        int combustibleAvance = distancia * combustibleConsumidoDistancia;

        if (combustibleAvance > this.combustible) {
            System.out.println("No hay suficiemte combustible para avanzar " + distancia + " unidades de distancia");
        } else {
            this.combustible = this.combustible - combustibleAvance;
            System.out.println("Has avanzado " + distancia + " unidades");
        }
        return this.combustible;
    }

    public int recargarCombustible(int cantidad) {

        if (this.combustible + cantidad > 100) {
            System.out.println("No se puede sobrecargar el tanque, capacidad máxima de 100 unidades");
            System.out.println("Combustible actual: " + this.combustible + "unidades");
        } else {
            this.combustible = this.combustible + cantidad;
            System.out.println("Has recargado " + cantidad + " unidades");
        }
        return this.combustible;
    }

    public void mostrarEstado() {
        System.out.println("Nombre de la nave: " + this.nombre + "\nCombustible actual: " + this.combustible);
    }
}
