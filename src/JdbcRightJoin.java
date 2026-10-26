import java.util.*;
import java.sql.*;

public class JdbcRightJoin{

    public static void main(String[] args){

        SqlConnection get = new SqlConnection();
        try{

            Connection con = get.getConnection();
            String query = "SELECT * FROM jdbc_practice.student RIGHT JOIN jdbc_practice.department ON student.id = department.id";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int Id = rs.getInt("id");
                String Name = rs.getString("name");
                int Age = rs.getInt("age");
                String Dept = rs.getString("department");
                String Course = rs.getString("course");

                System.out.println("Student id : "+ Id +
                        "\nStudent Name : "+ Name+
                        "\nStudent Age : "+ Age+
                        "\nStudent department : "+ Dept+
                        "\nStudent Course : "+ Course);
                System.out.println("----------------------------");

            }
            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}