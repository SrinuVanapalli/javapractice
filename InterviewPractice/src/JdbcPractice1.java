import java.sql.*;
import java.util.*;


public class JdbcPractice1 {



    public static void main(String[] args){
         String url = ("jdbc:mysql://localhost:3306/jdbc_practice");
         String username = "root";
         String password = System.getenv("DB_PASSWORD");
         if (password == null || password.isEmpty()) {
             throw new IllegalStateException("DB_PASSWORD environment variable is not set");
         }
        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            String query =
                    "select u.universityname , count(c.cid) as Max from course c join university u on u.uid = c.uid group by u.universityname having Max;  ";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String uName = rs.getString("universityname");
                Integer cNum = rs.getInt("Max");

                System.out.println(uName + " -> "+ cNum);
            }



            rs.close();
            ps.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
