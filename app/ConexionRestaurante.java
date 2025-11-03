package Proyecto_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionRestaurante {
    public static void main(String[] args) {
        String URL = "jdbc:oracle:thin:@localhost:1521:XE";
        String USER = "system";
        String PASS = "ORACLE";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            System.out.println("Conexión exitosa a la base de datos 'proyecto_restaurante'\n");

            // Mostrar CLIENTE
            System.out.println("Tabla: CLIENTE");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("| %-10s | %-30s | %-10s |\n", "COD_CLIENTE", "NOMBRE", "TELEFONO");
            System.out.println("-------------------------------------------------------------");

            ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTE ORDER BY COD_CLIENTE");
            while (rs.next()) {
                System.out.printf("| %-10d | %-30s | %-10d |\n",
                        rs.getInt("COD_CLIENTE"),
                        rs.getString("NOMBRE"),
                        rs.getInt("TELEFONO"));
            }
            System.out.println("------------------------------------------------------------\n");

            // Mostrar PLATO
            System.out.println("Tabla: PLATO");
            System.out.println("------------------------------------------------------------");
            System.out.printf("| %-10s | %-30s | %-10s |\n", "COD_PLATO", "NOMBRE", "PRECIO");
            System.out.println("------------------------------------------------------------");

            rs = stmt.executeQuery("SELECT * FROM PLATO ORDER BY COD_PLATO");
            while (rs.next()) {
                System.out.printf("| %-10s | %-30s | %-10.2f |\n",
                        rs.getString("COD_PLATO"),
                        rs.getString("NOMBRE"),
                        rs.getDouble("PRECIO"));
            }
            System.out.println("------------------------------------------------------------\n");

            // Mostrar MESA
            System.out.println("Tabla: MESA");
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("| %-10s | %-12s | %-10s | %-20s |\n", "COD_MESA", "NUMERO_MESA", "CAPACIDAD", "ESTADO");
            System.out.println("-----------------------------------------------------------------");

            rs = stmt.executeQuery("SELECT * FROM MESA ORDER BY COD_MESA");
            while (rs.next()) {
                System.out.printf("| %-10d | %-12d | %-10d | %-20s |\n",
                        rs.getInt("COD_MESA"),
                        rs.getInt("NUMERO_MESA"),
                        rs.getInt("CAPACIDAD"),
                        rs.getString("ESTADO"));
            }
            System.out.println("-----------------------------------------------------------------\n");

            // Mostrar PEDIDO
            System.out.println("Tabla: PEDIDO");
            System.out.println("------------------------------------------------------------");
            System.out.printf("| %-10s | %-15s | %-12s | %-10s |\n", "COD_PEDIDO", "FECHA_PEDIDO", "COD_CLIENTE", "COD_MESA");
            System.out.println("------------------------------------------------------------");

            rs = stmt.executeQuery("SELECT * FROM PEDIDO ORDER BY COD_PEDIDO");
            while (rs.next()) {
                System.out.printf("| %-10d | %-15s | %-12d | %-10d |\n",
                        rs.getInt("COD_PEDIDO"),
                        rs.getDate("FECHA_PEDIDO"),
                        rs.getInt("COD_CLIENTE"),
                        rs.getInt("COD_MESA"));
            }
            System.out.println("------------------------------------------------------------\n");

            // Mostrar DETALLE_PEDIDO
            System.out.println("Tabla: DETALLE_PEDIDO");
            System.out.println("----------------------------------------");
            System.out.printf("| %-10s | %-10s | %-10s |\n", "COD_PEDIDO", "COD_PLATO", "CANTIDAD");
            System.out.println("----------------------------------------");

            rs = stmt.executeQuery("SELECT * FROM DETALLE_PEDIDO ORDER BY COD_PEDIDO");
            while (rs.next()) {
                System.out.printf("| %-10d | %-10s | %-10d |\n",
                        rs.getInt("COD_PEDIDO"),
                        rs.getString("COD_PLATO"),
                        rs.getInt("CANTIDAD"));
            }
            System.out.println("----------------------------------------\n");

            rs.close();
            System.out.println("Datos mostrados correctamente.\n");

        } catch (Exception e) {
            System.out.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}