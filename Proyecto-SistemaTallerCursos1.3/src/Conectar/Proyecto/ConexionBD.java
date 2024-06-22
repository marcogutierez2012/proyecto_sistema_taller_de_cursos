package Conectar.Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexionBD {
    // URL de conexión con especificación de juego de caracteres
    String url = "jdbc:mysql://localhost:3306/bdtallerverano?characterEncoding=UTF-8";
    String usuario = "root";
    String password = "992478429xX@";
    Connection con;
    
    // Método para establecer la conexión
    public Connection ConexionMysql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            
            if (con != null) {
                System.out.println("Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Error al conectarse a la base de datos!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return con;
    }
    
    // Método main para probar la conexión (opcional)
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        Connection con = conexionBD.ConexionMysql();
        
        // Cerrar la conexión al finalizar (importante para liberar recursos)
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}