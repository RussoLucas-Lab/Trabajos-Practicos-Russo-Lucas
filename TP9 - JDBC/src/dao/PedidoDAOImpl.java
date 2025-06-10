package dao;

import model.Pedido;

import java.sql.*;
import java.time.LocalDate;

public class PedidoDAOImpl {

    public int insertar(Pedido pedido, Connection conn) throws SQLException {
        String sql = "INSERT INTO pedidos (fecha, total) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, Date.valueOf(pedido.getFecha()));
            stmt.setDouble(2, pedido.getTotal());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }

    public Pedido leer(int id) {
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        try (Connection conn = config.DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(id);
                pedido.setFecha(rs.getDate("fecha").toLocalDate());
                pedido.setTotal(rs.getDouble("total"));
                pedido.setItems(new ItemPedidoDAOImpl().obtenerItemsPorPedido(id));
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
