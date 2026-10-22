import java.sql.*;
import java.util.Scanner;


public class JdbcUpdateStudent{

    public static void main(String[] args){

        SqlConnection get = new SqlConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student id :");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter New Student Name :");
        String name = sc.nextLine();
        System.out.println("Enter New Student Age :");
        int age = sc.nextInt();


        String query = "UPDATE student SET name =?, age =? WHERE id = ?;";

        try{
            Connection con = get.getConnection();

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1,name);
        ps.setInt(2,age);
        ps.setInt(3,id);

        int rows = ps.executeUpdate();

        if(rows > 0){
            System.out.println("Student updated successfully");
        }else{
            System.out.println("Student updation failed");
        }
        con.close();
        ps.close();
        sc.close();

    }catch(Exception e ){
            e.printStackTrace();
        }

}
}
