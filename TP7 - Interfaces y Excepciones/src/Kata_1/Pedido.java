package Kata_1;

import java.util.ArrayList;

public class Pedido implements Pagable{

    private ArrayList<Producto> productos = new ArrayList<>();

    public Pedido() {
    }

    public void agregarProducto(Producto p){
        productos.add(p);
    }

    @Override
    public double calcularTotal(){
        double total = 0;
        for(Producto p : productos){
            total += p.calcularTotal();
        }
        return total;
    }
}
