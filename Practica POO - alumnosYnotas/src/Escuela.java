import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Escuela {
    private int numero;
    private String denominacion;
    private ArrayList<DivisionCurso> divisionCursos;

    public Escuela() {
    }

    public Escuela(int numero, String denominacion) {
        this.numero = numero;
        this.denominacion = denominacion;
        this.divisionCursos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public ArrayList<DivisionCurso> getDivisionCursos() {
        return divisionCursos;
    }

    public void setDivisionCursos(ArrayList<DivisionCurso> divisionCursos) {
        this.divisionCursos = divisionCursos;
    }

    @Override
    public String toString() {
        return "Escuela{" +
                "numero=" + numero +
                ", denominacion='" + denominacion + '\'' +
                ", divisionCursos=" + divisionCursos +
                '}';
    }

    public void agregarDivision(DivisionCurso divisionCurso) {
        divisionCursos.add(divisionCurso);
    }


    public Alumno getMejorAlumnoEscuela(int anioNacimientoAlumno) {

        Alumno mejorAlumno = null;
        double mejorPromedio = 0.0;

        for (DivisionCurso divisionCurso : divisionCursos) {
            for (Catedra catedra : divisionCurso.getCatedras()) {
                for (Alumno alumno : catedra.getAlumnos()) {
                    if (alumno.getFehcaNacimiento().getYear() == anioNacimientoAlumno && !alumno.haRecuperado()) {
                        double promedio = alumno.promedioNotas(catedra.getCodigo());
                        if (mejorAlumno == null || promedio > mejorPromedio) {
                            mejorAlumno = alumno;
                            mejorPromedio = promedio;
                        }
                    }
                }
            }
        }
        return mejorAlumno;
    }


    public List<Alumno> getMejoresAlumnos(int anioNacimientoAlumno) {
        Alumno mejorAlumno = null;
        double mejorPromedio = 0.0;
        Map<Alumno, Double> mejoresAlumnos = new HashMap<>();


        for (DivisionCurso divisionCurso : divisionCursos) {
            for (Catedra catedra : divisionCurso.getCatedras()) {
                for (Alumno alumno : catedra.getAlumnos()) {
                    if (alumno.getFehcaNacimiento().getYear() == anioNacimientoAlumno && !alumno.haRecuperado()) {
                        double promedio = alumno.promedioNotas(catedra.getCodigo());

                        mejoresAlumnos.put(alumno, promedio);
                    }
                }
            }
        }
            List<Alumno> mejores = mejoresAlumnos.entrySet().stream()
                .sorted(Map.Entry.<Alumno, Double>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        return mejores;
    }
}

