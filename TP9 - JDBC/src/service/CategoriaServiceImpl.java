package service;

import dao.CategoriaDAOImpl;
import model.Categoria;
import java.util.List;

public class CategoriaServiceImpl implements GenericService<Categoria> {
    private CategoriaDAOImpl dao = new CategoriaDAOImpl();

    @Override
    public boolean crear(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return false;
        }
        if (dao.existeNombre(categoria.getNombre())) {
            System.out.println("Ya existe una categoría con ese nombre.");
            return false;
        }
        return dao.crear(categoria);
    }

    @Override
    public Categoria leer(int id) {
        return dao.leer(id);
    }

    @Override
    public boolean actualizar(Categoria categoria) {
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            System.out.println("Nombre no puede estar vacío.");
            return false;
        }
        return dao.actualizar(categoria);
    }

    @Override
    public boolean eliminar(int id) {
        return dao.eliminar(id);
    }

    @Override
    public List<Categoria> listar() {
        return dao.listar();
    }
}
