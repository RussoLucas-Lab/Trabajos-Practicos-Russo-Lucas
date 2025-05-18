
import java.util.ArrayList;
import java.util.Date;

public class Alumno {
    private long legajo;
    private String nombre;
    private String apellido;
    private Date fehcaNacimiento;
    private ArrayList<Nota> notas;
    private Catedra catedra;

    public Alumno() {

    }

    public Alumno(long legajo, String nombre, String apellido, Date fehcaNacimiento, Catedra catedra) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fehcaNacimiento = fehcaNacimiento;
        this.notas = new ArrayList<>();
        this.catedra = catedra;
    }
//getter & setters
    public long getLegajo() {
        return legajo;
    }
    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFehcaNacimiento() {
        return fehcaNacimiento;
    }
    public void setFehcaNacimiento(Date fehcaNacimiento) {
        this.fehcaNacimiento = fehcaNacimiento;
    }
    public Catedra getCatedra(){
        return catedra;
    }
    public void setCatedra(Catedra catedra){
        this.catedra=catedra;
    }


    public void agregarNota(Nota nota) {
        notas.add(nota);
    }


    public Nota mejorNota(Integer codigoCatedra){

        Nota mejorNota = null;

        for(Nota nota : notas){
            if (!nota.isEsRecuperatorio() && (codigoCatedra == null || nota.getCatedra().getCodigo() == codigoCatedra)){
                if (mejorNota == null || nota.getValor() > mejorNota.getValor()) {
                    mejorNota = nota;
            }
        }
    }
        return mejorNota;
    }

    public double promedioNotas(Integer codigoCatedra){
        int promedio = 0;
        int contador1 = 0;
        int promedioTotal =0;
        int contador2 = 0;

        for (Nota nota : notas){
            if (codigoCatedra != null && nota.getCatedra().getCodigo() == codigoCatedra){
                promedio += nota.getValor();
                contador1++;
            } else {
                promedioTotal += nota.getValor();
                contador2++;
            }
        }
        if (codigoCatedra == null){
            return promedioTotal / contador2;
        } else {
            return promedio / contador1;
        }


    }

    //Retorna true si ha recuperado algun examen, false si nunca ha desaprobado
    public boolean haRecuperado(){
        for(Nota nota : notas){
            if (nota.isEsRecuperatorio()){
                return true;
            }
        }
        return false;
    }

    public int cantidadNotas(){
        return notas.size();
    }

}
