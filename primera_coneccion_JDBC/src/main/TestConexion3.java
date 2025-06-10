package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConexion3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "";

        String sql = "SELECT nombre, descripcion, precio, cantidad FROM productos";
        String sql2 = "SELECT * FROM productos WHERE nombre = \"manzana\"";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql2);
                ResultSet rs = stmt.executeQuery()
        )
        {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                System.out.println(nombre);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar productos:");
            e.printStackTrace();
        }
    }
}