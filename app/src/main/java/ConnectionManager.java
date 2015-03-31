import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
    {
        String url = "jdbc:oracle:thin:@141.216.24.31:1521:fsdb";
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String username = "fsuser";
        String password = "fsuser";
        Connection con;
    }

    public Connection getConnection(String url,String username, String driverName,String password,Connection con) {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }
}


