import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public Inventario(){

    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto p){
        productos.add(p);
    }

    public void listarProductos(){
        for (Producto p: productos){
            System.out.println("Nombre: " + p.getNombre() + ", categoría:  " + p.getCategoria() );
        }
    }

    public Producto buscarProductoPorId(String id){
        Producto productoId = null;
        int i = 0;

        while (i < productos.size() && !productos.get(i).getId().equals(id)){
            i++;
        }
        if (i<productos.size()){
            productoId = productos.get(i);
        }
        return productoId;
    }
    public void eliminarProductoPorId(String id){
        int i = 0;

        while (i < productos.size() && !productos.get(i).getId().equals(id)){
            i++;
        }
        if (i<productos.size()){
            productos.remove(i);
        }
    }
    public void actualizarStock(String id, int nuevaCantidad){
        int i = 0;

        while (i < productos.size() && !productos.get(i).getId().equals(id)){
            i++;
        }
        if (i<productos.size()){
            productos.get(i).setCantidad(nuevaCantidad);
        }
    }

    public ArrayList<Producto> filtrarPorCategoria(CategoriaProducto categoria){
        ArrayList<Producto> productosCategoria = new ArrayList<>();
        for(Producto p: productos){
            if (p.getCategoria().equals(categoria)){
                productosCategoria.add(p);
            }
        }
        if (productosCategoria.size() == 0){
            productosCategoria = null;
        }
        return productosCategoria;
    }

    public int obtenerTotalStock(){
        int totalStock = 0;
        for (Producto p : productos) {
            totalStock += p.getCantidad();
        }
        return totalStock;
    }

    public Producto obtenerProductoConMayorStock(){
        Producto productoMayorStock = productos.get(0);

        for (Producto p : productos){
            if (p.getCantidad() > productoMayorStock.getCantidad()){
                productoMayorStock = p;
            }
        }
        return productoMayorStock;
    }

    public ArrayList<Producto> filtrarProductosPorPrecio(double min, double max){
        ArrayList<Producto> listadoProducto = new ArrayList<>();

        for (Producto p : productos){
            if (p.getPrecio()< max && p.getPrecio()> min){
                listadoProducto.add(p);
            }
        }
        return listadoProducto;
    }

    public void mostrarCategoriasDisponibles(){
        Set<CategoriaProducto> categoriasUsadas = new HashSet<>();

        for (Producto p: productos){
            categoriasUsadas.add(p.getCategoria());
        }
        for (CategoriaProducto c : categoriasUsadas){
            System.out.println(c + ": " +c.getDescripcion());
        }

     }
}

