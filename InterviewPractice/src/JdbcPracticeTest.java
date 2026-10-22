import java.util.*;
import java.sql.*;


public class JdbcPracticeTest {


    public static void main(String [] args){
        SqlConnection1 sql = new SqlConnection1();
        try ( Connection con = sql.getConnection();
            PreparedStatement ps = con.prepareStatement(  "Select name from jdbc_practice.student");
            ResultSet rs = ps.executeQuery();)
        {
            List<String > names = new ArrayList<>();
            while(rs.next()){

                String name = rs.getString("name");
                names.add(name);

            }
            System.out.println(names);
        }catch(Exception se){
            se.printStackTrace();
        }

    }


}
