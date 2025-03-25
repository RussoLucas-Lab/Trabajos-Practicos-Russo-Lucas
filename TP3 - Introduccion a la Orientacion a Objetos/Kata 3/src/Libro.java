public class Libro {
    private String titulo;
    private String autor;
    private int anoPublicacion;

    public Libro(String titulo, String autor, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        if (anoPublicacion < 1900 || anoPublicacion > 2025) {
            System.out.println("El año ingresado no puede ser menor que 1900 ni mayor que 2025");
        } else {
            this.anoPublicacion = anoPublicacion;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacion(int anoNuevo) {
        if (anoNuevo < 1900) {
            System.out.println("El año de publicación no puede ser menor a 1900");
        } else if (anoNuevo > 2025) {
            System.out.println("El año de publicación no puede ser mayor al actual (2025)");
        } else {
            this.anoPublicacion = anoNuevo;
        }
    }

    public void mostrarInfo() {
        System.out.println("Título: " + this.titulo
                + "\nAutor: " + this.autor
                + "\nAño de publicación: " + this.anoPublicacion+"\n");
    }
}
