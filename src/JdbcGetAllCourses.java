/*Retrieve all records from COURSE using JDBC and print:
101 - MARINE BIOLOGY - University ID: 1
102 - GEOLOGY - University ID: 1
...
 */

import java.sql.*;

class Course{
    private int courseId ;
    private String courseName;
    private int uId;

    public Course(int courseId,String courseName, int uId){
        this.courseId = courseId;
        this.courseName = courseName;
        this.uId = uId;
    }
    public int getCourseId(){ return courseId;}
    public String getCourseName(){ return courseName;}
    public int getuId() { return uId;}

    @Override
    public String toString(){ return courseId + " - "+ courseName + " - University Id : "+ uId; }
}

public class JdbcGetAllCourses{


    public static void main(String[]args){
        SqlConnection get = new SqlConnection();
        try {
            Connection con = get.getConnection();

            String query = "SELECT c.CID, c.COURSENAME, c.UID from jdbc_practice.course c";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int CoID = rs.getInt("CID");
                String CoName = rs.getString("COURSENAME");
                int UnID = rs.getInt("UID");

                System.out.println(CoID + " - " + CoName + " - University Id : "+ UnID);

            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}