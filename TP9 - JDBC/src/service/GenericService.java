package service;

import java.util.List;

public interface GenericService<T> {
    boolean crear(T t);
    T leer(int id);
    boolean actualizar(T t);
    boolean eliminar(int id);
    List<T> listar();
}
