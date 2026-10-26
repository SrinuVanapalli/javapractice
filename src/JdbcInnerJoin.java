import java.util.*;
import java.sql.*;

public class JdbcInnerJoin{

    public static void main(String[] args){

        SqlConnection get = new SqlConnection();
        try{

             Connection con = get.getConnection();

            String query = "SELECT jdbc_practice.student.id, jdbc_practice.student.name, jdbc_practice.department.course FROM jdbc_practice.student INNER JOIN jdbc_practice.department ON student.id = department.id";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int Id = rs.getInt("id");
                String Name = rs.getString("name");
                String Course = rs.getString("course");

                System.out.println("Student id : "+ Id +
                        "\nStudent Name : "+ Name+
                        "\nStudent Course : "+ Course);
                System.out.println("----------------------------");

            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}