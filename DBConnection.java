import java.sql.*;

public class DBConnection {
    private static final String url="jdbc:mysql://localhost:3306/busresvdemo1";
    private static final String username="root";
    private static final String password="ramsnth@18";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);

    }
}
