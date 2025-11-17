package ProyectoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClienteDAO {

    public void insertarCliente(int cod, String nombre, int telefono) {
        String sql = "INSERT INTO CLIENTE (COD_CLIENTE, NOMBRE, TELEFONO) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cod);
            ps.setString(2, nombre);
            ps.setInt(3, telefono);
            ps.executeUpdate();
            System.out.println("Cliente insertado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    public void actualizarCliente(int cod, String nuevoNombre) {
        String sql = "UPDATE CLIENTE SET NOMBRE = ? WHERE COD_CLIENTE = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nuevoNombre);
            ps.setInt(2, cod);
            ps.executeUpdate();
            System.out.println("Cliente actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    public void mostrarClientes() {
        String sql = "SELECT * FROM CLIENTE ORDER BY COD_CLIENTE";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("-------------------------------------------------------------");
            System.out.printf("| %-10s | %-30s | %-10s |\n", "COD_CLIENTE", "NOMBRE", "TELEFONO");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("| %-11d | %-30s | %-10d |\n",
                        rs.getInt("COD_CLIENTE"),
                        rs.getString("NOMBRE"),
                        rs.getInt("TELEFONO"));
            }

            System.out.println("-------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error al mostrar clientes: " + e.getMessage());
        }
    }

    public void eliminarCliente(int cod) {
        String sql = "DELETE FROM CLIENTE WHERE COD_CLIENTE = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cod);
            ps.executeUpdate();
            System.out.println("Cliente eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }
    }
}