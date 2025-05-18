import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DivisionCurso {
    private int codigo;
    private int anio;
    private int division;
    private Escuela escuela;
    private ArrayList<Catedra> catedras;

    public DivisionCurso(int codigo, int anio, int division, Escuela escuela) {
        this.codigo = codigo;
        this.anio = anio;
        this.division = division;
        this.escuela = escuela;
        this.catedras = new ArrayList<>();
    }

    public DivisionCurso(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public ArrayList<Catedra> getCatedras() {
        return catedras;
    }

    public void setCatedras(ArrayList<Catedra> catedras) {
        this.catedras = catedras;
    }

    @Override
    public String toString() {
        return "DivisionCurso{" +
                "codigo=" + codigo +
                ", anio=" + anio +
                ", division=" + division +
                ", escuela=" + escuela +
                ", catedras=" + catedras +
                '}';
    }

    public void agregarCatedra(Catedra catedra) {
        catedras.add(catedra);
    }

    public Map.Entry<Alumno, Double> mejorAlumnoDivisionCurso(){

        //Hashmap que contiene los promedios de cada catedra, de cada alumno
        Map<Alumno, ArrayList<Double>> promediosPorAlumno = new HashMap<>();

        for (Catedra catedra : catedras){
            for (Alumno alumno : catedra.getAlumnos()){
                if (alumno.haRecuperado() == false && alumno.cantidadNotas()>=5){
                    double promedio = alumno.promedioNotas(catedra.getCodigo());
                    promediosPorAlumno
                            .computeIfAbsent(alumno, k -> new ArrayList<>())
                            .add(promedio);
                }
            }
        }
        //elimina los alumnos que han desaprobado del hashmap
        promediosPorAlumno.entrySet().removeIf(entry -> entry.getKey().haRecuperado());

        Alumno mejorAlumno = null;
        double mejorPromedioTotal = 0.0;

        for (Map.Entry<Alumno, ArrayList<Double>> entry : promediosPorAlumno.entrySet()) {
            Alumno alumno = entry.getKey();
            ArrayList<Double> promedios = entry.getValue();

            // Calcular el promedio total de los promedios
            double suma = 0.0;
            for (double promedio : promedios) {
                suma += promedio;
            }
            double promedioTotal = suma / promedios.size();

            // Comparar con el mejor promedio hasta ahora
            if (mejorAlumno == null || promedioTotal > mejorPromedioTotal) {
                mejorAlumno = alumno;
                mejorPromedioTotal = promedioTotal;
            }
        }

        return new AbstractMap.SimpleEntry<>(mejorAlumno, mejorPromedioTotal);
    }


}
