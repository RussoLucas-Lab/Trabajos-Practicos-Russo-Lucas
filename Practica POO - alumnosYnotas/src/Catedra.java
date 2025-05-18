import java.util.ArrayList;

public class Catedra {

    private int codigo;
    private String denominacion;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Nota> notas;
    private DivisionCurso divisionCurso;

    public Catedra(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.alumnos = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.divisionCurso = divisionCurso;
    }

    public Catedra(){

    }

    public int getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public DivisionCurso getDivisionCurso() {
        return divisionCurso;
    }

    public void setDivisionCurso(DivisionCurso divisionCurso) {
        this.divisionCurso = divisionCurso;
    }

    public void agregarAlumno(Alumno alumno){
        alumnos.add(alumno);
    }
    public void agregarNota(Nota nota){
        notas.add(nota);
    }

    public Alumno mejorAlumnoCatedra(){
        Alumno mejorAlumno = alumnos.get(0);

        for (Alumno alumno : alumnos){

            if (alumno.mejorNota(this.codigo).getValor() > mejorAlumno.mejorNota(this.codigo).getValor()){
                mejorAlumno = alumno;
            }
        }
        return mejorAlumno;
    }

    @Override
    public String toString() {
        return "Catedra{" +
                "codigo=" + codigo +
                ", denominacion='" + denominacion + '\'' +
                ", alumnos=" + alumnos +
                ", notas=" + notas +
                ", divisionCursos=" + divisionCurso +
                '}';
    }
}
