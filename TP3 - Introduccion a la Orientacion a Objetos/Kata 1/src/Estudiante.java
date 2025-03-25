public class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public Estudiante(String nombre, String apellido, String curso, double calificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        if (calificacion < 0.0 || calificacion > 10.0) {
            this.calificacion = 0.0;
        } else {
            this.calificacion = calificacion;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCurso() {
        return curso;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nCurso: " + this.curso + "\nCalificacion: " + this.calificacion);
    }

    public void subirCalificacion(double puntos) {
        if (this.calificacion + puntos <= 10) {
            this.calificacion += puntos;
        } else {
            this.calificacion = 10.0;
        }
    }

    public void bajarCalificacion(double puntos) {
        if (this.calificacion - puntos >= 0) {
            this.calificacion -= puntos;
        } else {
            this.calificacion = 0.0;
        }
    }
}

