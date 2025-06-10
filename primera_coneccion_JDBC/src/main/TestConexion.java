package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}
