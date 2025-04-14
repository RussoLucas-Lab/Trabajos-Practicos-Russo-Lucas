public class Principal {
    public static void main(String[] args) {

        Producto p1 = new Producto("1", "Pava Eléctrica", 50000.00, 1, CategoriaProducto.ELECTRONICA );
        Producto p2 = new Producto("2", "Secador de Pelo", 75000.00, 1, CategoriaProducto.ELECTRONICA );
        Producto p3 = new Producto("3", "Jean", 80000.00, 1, CategoriaProducto.ROPA );
        Producto p4 = new Producto("4", "lampara", 25000.00, 5, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("5", "sofa", 1000000.00,1, CategoriaProducto.HOGAR);

        Inventario I1 = new Inventario();
        I1.agregarProducto(p1);
        I1.agregarProducto(p2);
        I1.agregarProducto(p3);
        I1.agregarProducto(p4);
        I1.agregarProducto(p5);

        System.out.println("Stock total: " + I1.obtenerTotalStock());
        System.out.println("Producto con mayor stock: "+ I1.obtenerProductoConMayorStock().getNombre() + " con " + I1.obtenerProductoConMayorStock().getCantidad() + " undad/es" );
        System.out.println(I1.filtrarProductosPorPrecio(50000.00,1200000.00));
        System.out.println("Categorías disponibles:");
        I1.mostrarCategoriasDisponibles();

    }
}
