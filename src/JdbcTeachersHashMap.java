/*Course → Teachers using HashMap
MARINE BIOLOGY -> [SRINU, KOMAL, VASU, MANI]
GEOLOGY        -> [RAVI, SURESH, ANITA, DEEPA]
...*/

import java.sql.*;
import java.util.*;

class CourseT{
    private String course;
    private String teacher;

    public CourseT(String course, String teacher){
        this.course= course;
        this.teacher= teacher;
    }
    public String getCourse() { return course;}
    public String getTeacher() { return teacher;}

    @Override
    public String toString(){
        return course+ " - "+ teacher;
    }
}

public class JdbcTeachersHashMap{



    public static void main(String[] args){
          SqlConnection get  = new SqlConnection();
        HashMap<String , List<String>> teacherMap = new HashMap<>();
            try {

                Connection con = get.getConnection();
                String query = "SELECT\n" +
                        "    c.COURSENAME,\n" +
                        "    t.TEACHERNAME\n" +
                        "FROM COURSE c\n" +
                        "JOIN COURTEACH ct\n" +
                        "    ON c.CID = ct.CID\n" +
                        "JOIN TEACHER t\n" +
                        "    ON ct.TID = t.TID; ";

                PreparedStatement ps = con.prepareStatement(query);

                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    String tName = rs.getString("TEACHERNAME");
                    String cName = rs.getString("COURSENAME");

                    List<String> teachName = teacherMap.get(cName);
                    if(teachName==null){
                        teachName= new ArrayList<>();
                        teacherMap.put(cName,teachName);
                    }
                    teachName.add(tName);
                }
                System.out.println(teacherMap);
            }catch (Exception e){
                e.printStackTrace();
            }

    }

}