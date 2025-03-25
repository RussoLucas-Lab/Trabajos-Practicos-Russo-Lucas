public class main {
    public static void main(String[] args) {
        Libro l1 = new Libro("Titanic", "Desconocido", 1990);

        l1.mostrarInfo();

        l1.setAnoPublicacion(1899);
        l1.mostrarInfo();

        l1.setAnoPublicacion(2003);
        l1.mostrarInfo();
    }
}
