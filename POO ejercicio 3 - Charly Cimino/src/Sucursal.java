import java.util.ArrayList;

public class Sucursal {
    private String nombre;
    private ArrayList<Instrumento> instrumentos = new ArrayList<>();

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarInstrumento(Instrumento instrumento){
        instrumentos.add(instrumento);
    }

    public ArrayList<Instrumento> instrumetnosPorTipo( TipoInstrumento tipo){

        ArrayList<Instrumento> listaInstrumento = new ArrayList<>();

        for (Instrumento ins : instrumentos){
            if (ins.getTipo().equals(tipo)){
                listaInstrumento.add(ins);
            }
        }
        return listaInstrumento;
    }
    public void mostrarInstrumentos(){
        for (Instrumento instrumento : instrumentos){
            System.out.println(instrumento.getId());
        }
    }

    public void borrarInstrumento(String id){
        int i = 0;
        while(i < instrumentos.size() && !this.instrumentos.get(i).getId().equals(id)){
            i++;
        }
        if (i < instrumentos.size()){
            System.out.println("instrumento encontrado en la posicion " + i + ", eliminando...");
            instrumentos.remove(i);
        }

    }
}
