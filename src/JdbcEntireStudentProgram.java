import java.sql.*;
import java.util.*;

public class JdbcEntireStudentProgram {

    public static void main(String[] args) {

       SqlConnection get = new SqlConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("+++++++Student Management System++++++++");
        System.out.println("Press 1 to Insert a student ");
        System.out.println("Press 2 to Update a student ");
        System.out.println("Press 3 to Delete a student");
        System.out.println("Press 4 to Print all students");
        System.out.println("Press 0 to exit");

        int i = sc.nextInt();
        sc.nextLine();

        boolean flag = true;


        while (flag) {


            switch (i) {

                case 1:

                    System.out.println("Enter a Student id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Name :");
                    String name = sc.nextLine();
                    System.out.println("Enter Student Age :");
                    int age = sc.nextInt();
                    sc.nextLine();

                    try {
                        Connection con = get.getConnection();

                        String query = "INSERT INTO jdbc_practice.student(id, name, age) VALUES(?,?,?);";

                        PreparedStatement ps = con.prepareStatement(query);

                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setInt(3, age);

                        int rows = ps.executeUpdate();

                        if (rows > 0) {
                            System.out.println("Student inserted successfully");
                        } else {
                            System.out.println("Student insertion failed");
                        }


                        ps.close();
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:

                    System.out.println("Enter Student id to Update : ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Name :");
                    String uname = sc.nextLine();
                    System.out.println("Enter Student Age :");
                    int uage = sc.nextInt();
                    sc.nextLine();

                    try{

                        Connection con = get.getConnection();

                        String query = "UPDATE jdbc_practice.student SET name =?, age = ? WHERE id = ?;";

                        PreparedStatement ps = con.prepareStatement(query);

                        ps.setString(1,uname);
                        ps.setInt(2,uage);
                        ps.setInt(3,uid);

                        int rows = ps.executeUpdate();

                        if(rows>0){
                            System.out.println("Student Updated successfully");
                        }else{
                            System.out.println("Student Updation failed");
                        }

                        ps.close();
                        con.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;

                case 3:

                    System.out.println("Enter a Student id to Delete");
                    int did = sc.nextInt();
                    sc.nextLine();

                    try{

                        Connection con = get.getConnection();

                        String query = "DELETE FROM jdbc_practice.student WHERE id = ?;";

                        PreparedStatement ps = con.prepareStatement(query);

                        ps.setInt(1,did);

                        int rows = ps.executeUpdate();

                        if(rows>0){
                            System.out.println("Student deleted successfully");
                        }else{
                            System.out.println("Student deletion failed");
                        }

                        ps.close();
                        con.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;

                case 4:

                    try{

                        Connection con = get.getConnection();

                        String query = "SELECT * FROM jdbc_practice.student;";

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(query);

                        while(rs.next()){

                            int Id = rs.getInt("id");
                            String Name = rs.getString("name");
                            int Age = rs.getInt("age");

                            System.out.println("Student Id : "+ Id);
                            System.out.println("Student Name : "+ Name);
                            System.out.println("Student Age : "+ Age);
                            System.out.println("========================");
                        }
                        rs.close();
                        st.close();
                        con.close();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;

                default:
                {
                    System.out.println("Thank You");
                    }

                }
            System.out.println("+++++++Student Management System++++++++");
            System.out.println("Press 1 to Insert a student ");
            System.out.println("Press 2 to Update a student ");
            System.out.println("Press 3 to Delete a student");
            System.out.println("Press 4 to Print all students");
            System.out.println("Press 0 to exit");
            int it = sc.nextInt();
            if(it>0 && it<5){
                i = it;
                flag = true;
            }else {
                flag = false;
            }
        }
        }
    }
