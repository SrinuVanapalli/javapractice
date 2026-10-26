import java.sql.*;

public class SqlConnection {

    private final String url = "jdbc:mysql://localhost:3306/jdbc_practice";
    private final String username = "root";
    public Connection getConnection() throws SQLException{

        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("DB_PASSWORD environment variable is not set");
        }
        return DriverManager.getConnection(url, username, password);
    }

}
