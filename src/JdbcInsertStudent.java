import java.sql.*;
import java.util.*;
 class InsertStudent {

    public static void main(String[] args) {

        SqlConnection get = new SqlConnection();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        String query = "INSERT INTO jdbc_practice.student(name, age) VALUES ( ?, ?)";

        try {
            Connection con = get.getConnection();
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.getGeneratedKeys();
            ps.setString(1, name);
            ps.setInt(2, age);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                    if(rs.next()){
                        int generatedId = rs.getInt(1);
                      System.out.println("Student inserted successfully.");
                      System.out.println("Generated Id : "+  generatedId );
                    }
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
