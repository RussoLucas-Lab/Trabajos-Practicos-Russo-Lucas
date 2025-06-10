package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConexion2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "";

        String sql = "SELECT nombre, descripcion, precio, cantidad FROM productos";
        String sql2 = "SELECT * FROM productos WHERE nombre = \"manzana\"";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        )
        {
            System.out.println("📦 Lista de productos:");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");

                System.out.println("Nombre: " + nombre +
                        " | Descripción: " + descripcion +
                        " | Precio: $" + precio +
                        " | Cantidad: " + cantidad);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar productos:");
            e.printStackTrace();
        }
    }
}

