package lab5.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection(String url, String name, String pass) throws SQLException {
        return DriverManager.getConnection(url, name, pass);
    }
}