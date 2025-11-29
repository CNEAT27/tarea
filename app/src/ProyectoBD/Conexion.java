package ProyectoBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
    private static final String PASS = "ORACLE";

    public static Connection conectar() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}