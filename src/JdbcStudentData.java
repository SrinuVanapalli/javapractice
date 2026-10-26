import java.sql.*;
import java.util.Scanner;

public class JdbcStudentData {

    public static void main(String[] args) {

        SqlConnection get = new SqlConnection();
        try {

            Connection con = get.getConnection();
            Statement stmt = con.createStatement();

            String que = ("SELECT * FROM jdbc_practice.student;");

            ResultSet rs = stmt.executeQuery(que);

            while (rs.next()) {

                int Id = rs.getInt("id");
                String Name = rs.getString("name");
                int Age = rs.getInt("age");

                System.out.println("Student age : " + Id);
                System.out.println("Student name : " + Name);
                System.out.println("Student age : " + Age);
                System.out.println("=======================");

            }
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
