/*University → Courses using HashMap
        ...*/

import java.sql.*;
import java.util.*;

class university{
    private String UniversityName ;
    private String CourseName ;

    public university(String UniversityName, String CourseName){

        this.UniversityName = UniversityName;
        this.CourseName = CourseName;
    }
    public String getUniversityName(){ return UniversityName;}
    public String getCourseName(){ return CourseName ;}

    @Override
    public String toString(){
        return UniversityName+ " - "+ CourseName;
    }

}

public class JdbcUniCourHashMap{


    public static void main (String[] args) {
        SqlConnection get = new SqlConnection();
        HashMap<String, List<String>> courseMap = new HashMap<>();

        try {
            Connection con = get.getConnection();
            String query = "SELECT u.UNIVERSITYNAME, c.COURSENAME FROM UNIVERSITY u JOIN COURSE c ON u.UID = c.UID";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String Uname = rs.getString("UNIVERSITYNAME");
                String Cname = rs.getString("COURSENAME");

               List<String> courses = courseMap.get(Uname);
               if(courses== null){
                   courses = new ArrayList<>();
                   courseMap.put(Uname,courses);
               }
               courses.add(Cname);
            }
            System.out.println(courseMap);

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }
