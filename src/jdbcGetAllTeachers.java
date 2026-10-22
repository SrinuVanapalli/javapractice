/*Retrieve All Teachers
1001 - SRINU - Course ID: 101
1002 - KOMAL - Course ID: 101
1003 - VASU - Course ID: 101
...
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Teachers {
    private int TeacherId ;
    private String TeacherName;
    private int CourseID;

    public Teachers(int TeacherId, String TeacherName, int CourseId){
        this.TeacherId = TeacherId;
        this.TeacherName = TeacherName;
        this.CourseID = CourseId;
    }
    public int getTeacherId(){ return TeacherId;}
    public String getTeacherName(){ return TeacherName;}
    public int getCourseID(){ return CourseID;}

    @Override
    public String toString(){ return TeacherId + " - "+ TeacherName + " - Course ID: "+CourseID ;
    }
}



public class jdbcGetAllTeachers {


    public static void main(String[] args){
        SqlConnection get = new SqlConnection();
        try {
            Connection con = get.getConnection();

            String query = "SELECT  t.TID, t.TEACHERNAME FROM jdbc_practice.teacher t;";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int TeId = rs.getInt("TID");
                String TeName = rs.getString("TEACHERNAME");

                System.out.println(TeId+" - "+ TeName);

            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
