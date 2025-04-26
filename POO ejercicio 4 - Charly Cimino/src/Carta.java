public abstract class Carta {


    private boolean tapada;
    public Carta(){}

    public void darVuelta(){
        tapada = !tapada;
    }

    public boolean isTapada() {
        return tapada;
    }

    public String getRepresentacion(){
        return "carta genérica";
    }

    public void mostrar(){
        if(tapada){
            System.out.println("***************");
        } else{
            System.out.println(getRepresentacion());
        }
    }

    //toString() {}

}
