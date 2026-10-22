import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class JdbcInsertDepartment {

    public static void main(String[] args) {

        SqlConnection get = new SqlConnection();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student department: ");
        String dept = sc.nextLine();

        System.out.println("Enter Student course : ");
        String cou = sc.nextLine();

        String query = "INSERT INTO jdbc_practice.department(id, name, department, course) VALUES (?, ?, ?,?)";

        try {
            Connection con = get.getConnection();

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.setString(4,cou);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted successfully.");
            } else {
                System.out.println("Student insertion failed.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

