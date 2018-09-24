
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rian Alves
 */
public class DataBaseLocator {
    
     private static DataBaseLocator instance = new DataBaseLocator();

    public static DataBaseLocator getInstance() {
        return instance;
    }

    private DataBaseLocator() {
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/mineragit", "root", "");
        return conn;
    }
    
}
