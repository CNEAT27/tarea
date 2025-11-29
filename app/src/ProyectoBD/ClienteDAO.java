package ProyectoBD;

import java.sql.*;

public class ClienteDAO {

    public void insertarCliente(int cod, String nombre, int telefono) {
        String sql = "{CALL SP_INSERTAR_CLIENTE(?, ?, ?)}";
        try (Connection conn = Conexion.conectar();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, cod);
            cs.setString(2, nombre);
            cs.setInt(3, telefono);
            cs.execute();

            System.out.println("Cliente insertado correctamente (procedimiento ejecutado).");

        } catch (Exception e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    public void actualizarCliente(int cod, String nuevoNombre) {
        String sql = "{CALL SP_ACTUALIZAR_CLIENTE(?, ?)}";
        try (Connection conn = Conexion.conectar();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, cod);
            cs.setString(2, nuevoNombre);
            cs.execute();

            System.out.println("Cliente actualizado correctamente (procedimiento ejecutado).");

        } catch (Exception e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    public void eliminarCliente(int cod) {
        String sql = "{CALL SP_ELIMINAR_CLIENTE(?)}";
        try (Connection conn = Conexion.conectar();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, cod);
            cs.execute();

            System.out.println("Cliente eliminado correctamente (procedimiento ejecutado).");

        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
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

    public void mostrarHistorialClientes() {
        String sql = "SELECT * FROM HISTORIAL_CLIENTE ORDER BY ID_LOG";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("-------------------------------------------------------------");
            System.out.printf("| %-7s | %-12s | %-12s | %-20s |\n",
                    "ID_LOG", "COD_CLIENTE", "ACCION", "FECHA");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("| %-7d | %-12d | %-12s | %-20s |\n",
                        rs.getInt("ID_LOG"),
                        rs.getInt("COD_CLIENTE"),
                        rs.getString("ACCION"),
                        rs.getDate("FECHA").toString());
            }

            System.out.println("-------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error al mostrar historial: " + e.getMessage());
        }
    }

    public void mostrarVistaPedidos() {
        String sql = "SELECT * FROM VW_PEDIDOS_COMPLETOS ORDER BY COD_PEDIDO";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("--------------------------------------------------------------------");
            System.out.printf("| %-10s | %-25s | %-12s | %-12s |\n",
                    "COD_PEDIDO", "CLIENTE", "NUMERO_MESA", "FECHA_PEDIDO");
            System.out.println("---------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("| %-10d | %-25s | %-12d | %-12s |\n",
                        rs.getInt("COD_PEDIDO"),
                        rs.getString("CLIENTE"),
                        rs.getInt("NUMERO_MESA"),
                        rs.getDate("FECHA_PEDIDO").toString());
            }

            System.out.println("-------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error al mostrar vista de pedidos: " + e.getMessage());
        }
    }
}