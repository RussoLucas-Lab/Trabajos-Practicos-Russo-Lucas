package dao;

import model.ItemPedido;
import model.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDAOImpl {

    public void insertar(ItemPedido item, int pedidoId, Connection conn) throws SQLException {
        String sql = "INSERT INTO items_pedido (pedido_id, producto_id, cantidad, subtotal) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            stmt.setInt(2, item.getProducto().getId());
            stmt.setInt(3, item.getCantidad());
            stmt.setDouble(4, item.getSubtotal());
            stmt.executeUpdate();
        }
    }

    public List<ItemPedido> obtenerItemsPorPedido(int pedidoId) {
        List<ItemPedido> items = new ArrayList<>();
        String sql = """
            SELECT i.*, p.nombre as prod_nombre, p.descripcion as prod_desc, 
                   p.precio, p.id_categoria 
            FROM items_pedido i
            JOIN productos p ON i.producto_id = p.id
            WHERE i.pedido_id = ?
        """;
        try (Connection conn = config.DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pedidoId);
            ResultSet rs = stmt.executeQuery();
            ProductoDAOImpl productoDAO = new ProductoDAOImpl();
            while (rs.next()) {
                Producto producto = productoDAO.leer(rs.getInt("producto_id"));
                ItemPedido item = new ItemPedido(rs.getInt("id"), producto,
                        rs.getInt("cantidad"), rs.getDouble("subtotal"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
