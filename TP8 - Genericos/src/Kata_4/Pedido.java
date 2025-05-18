package Kata_4;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Comparable<Pedido>, Identificable<Integer> {
    private int id;
    private List<Producto<?>> productos;
    private LocalDate fecha;

    public Pedido(int id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto<?> producto) {
        productos.add(producto);
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public Integer getID() {
        return id; // ¡OJO! Tiene que devolver Integer, no int
    }

    @Override
    public boolean tieneMismoID(Integer id) {
        return this.id == id;
    }

    @Override
    public int compareTo(Pedido otro) {
        return Double.compare(this.calcularTotal(), otro.calcularTotal());
    }

    @Override
    public String toString() {
        return "Pedido{id=" + id + ", total=" + calcularTotal() + ", fecha=" + fecha + "}";
    }
}

