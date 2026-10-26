import java.sql.*;
import java.util.*;

public class JdbcDeleteStudent {

    public static void main(String[] args) {

       SqlConnection get = new SqlConnection();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student id:");
        int id = sc.nextInt();


        try {

            Connection con = get.getConnection();
            String query = "DELETE FROM jdbc_practice.student WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Student deleted successfully");
            }else{
                System.out.println("Student deletion failed");
            }
            con.close();
            ps.close();

        } catch (Exception e) {
         e.printStackTrace();
        }
       sc.close();


    }
}