import java.util.ArrayList;

public class Fabrica {
    private ArrayList<Sucursal> sucursales = new ArrayList<>();

    public Fabrica(){

    }

    public void agregarSucursal( Sucursal sucursal){
        sucursales.add(sucursal);
    }


}
