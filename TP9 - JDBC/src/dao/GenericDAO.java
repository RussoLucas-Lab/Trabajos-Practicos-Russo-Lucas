package dao;

import java.util.List;

public interface GenericDAO<T> {
    boolean crear(T t);
    T leer(int id);
    boolean actualizar(T t);
    boolean eliminar(int id);
    List<T> listar();
}
