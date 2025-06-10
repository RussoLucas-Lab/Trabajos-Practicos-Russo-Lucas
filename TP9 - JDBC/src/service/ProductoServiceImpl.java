package service;

import dao.ProductoDAOImpl;
import model.Producto;
import java.util.List;

public class ProductoServiceImpl implements GenericService<Producto> {

    private ProductoDAOImpl dao = new ProductoDAOImpl();

    @Override
    public boolean crear(Producto p) {
        if (p.getNombre() == null || p.getNombre().trim().isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return false;
        }
        if (p.getPrecio() <= 0 || p.getCantidad() <= 0) {
            System.out.println("Precio y cantidad deben ser mayores a 0.");
            return false;
        }
        if (!dao.existeCategoria(p.getCategoria().getId())) {
            System.out.println("La categoría no existe.");
            return false;
        }
        return dao.crear(p);
    }

    @Override
    public Producto leer(int id) {
        return dao.leer(id);
    }

    @Override
    public boolean actualizar(Producto p) {
        if (p.getNombre() == null || p.getNombre().trim().isEmpty() || p.getPrecio() <= 0 || p.getCantidad() <= 0) {
            System.out.println("Datos inválidos.");
            return false;
        }
        return dao.actualizar(p);
    }

    @Override
    public boolean eliminar(int id) {
        return dao.eliminar(id);
    }

    @Override
    public List<Producto> listar() {
        return dao.listar();
    }

    public List<Producto> listarPorCategoria(int idCategoria) {
        return dao.listarPorCategoria(idCategoria);
    }
}