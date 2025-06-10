package dao;

import config.DBConnection;

import model.Categoria;
import model.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements GenericDAO<Producto> {

    private CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl();

    @Override
    public boolean crear(Producto p) {
        if (!existeCategoria(p.getCategoria().getId())) return false;
        String sql = "INSERT INTO productos (nombre, descripcion, precio, cantidad, id_categoria) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getDescripcion());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getCantidad());
            stmt.setInt(5, p.getCategoria().getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Producto leer(int id) {
        String sql = "SELECT p.*, c.nombre as cat_nombre, c.descripcion as cat_desc FROM productos p JOIN categorias c ON p.id_categoria = c.id WHERE p.id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Categoria cat = new Categoria(rs.getInt("id_categoria"), rs.getString("cat_nombre"), rs.getString("cat_desc"));
                return new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"),
                        rs.getDouble("precio"), rs.getInt("cantidad"), cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean actualizar(Producto p) {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, cantidad = ?, id_categoria = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getDescripcion());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getCantidad());
            stmt.setInt(5, p.getCategoria().getId());
            stmt.setInt(6, p.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT p.*, c.nombre as cat_nombre, c.descripcion as cat_desc FROM productos p JOIN categorias c ON p.id_categoria = c.id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria cat = new Categoria(rs.getInt("id_categoria"), rs.getString("cat_nombre"), rs.getString("cat_desc"));
                Producto p = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"),
                        rs.getDouble("precio"), rs.getInt("cantidad"), cat);
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Producto> listarPorCategoria(int idCategoria) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE id_categoria = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria cat = categoriaDAO.leer(idCategoria);
                Producto p = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"),
                        rs.getDouble("precio"), rs.getInt("cantidad"), cat);
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean existeCategoria(int idCategoria) {
        return categoriaDAO.leer(idCategoria) != null;
    }
}