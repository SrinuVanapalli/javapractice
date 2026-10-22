import java.sql.*;

public class JdbcConnectionTest{

    public static void main(String[] args) {

        String url = ("jdbc:mysql://localhost:3306/jdbc_practice");
        String username = "root";
        String password = System.getenv("DB_PASSWORD");
        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("DB_PASSWORD environment variable is not set");
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("connection successful");


        }catch(Exception e){
            e.printStackTrace();
        }


    }
}