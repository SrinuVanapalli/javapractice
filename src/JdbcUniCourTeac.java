/*University → Course → Teachers
"AU"
   ↓
{
   "MARINE BIOLOGY" → [SRINU, KOMAL, VASU, MANI],
   "GEOLOGY"        → [RAVI, SURESH, ANITA, DEEPA]
} */

import java.sql.*;
import java.util.*;

class UniCourTeacher{
    private String universityName ;
    private String courseName;
    private String teacherName;

    public UniCourTeacher(String universityName, String courseName, String teacherName){

        this.universityName = universityName;
        this.courseName= courseName;
        this.teacherName= teacherName;
    }

    public String getUniversityName(){ return universityName ;}
    public String getCourseName(){ return courseName ;}
    public String getTeacherName(){ return teacherName ;}

    @Override
    public String toString(){
        return universityName +"\n"+
                courseName + " -> " +teacherName;
    }

}


public class JdbcUniCourTeac {


    public static void main(String[] args){
        SqlConnection get = new SqlConnection();

        Map<String, HashMap<String, List<String>>> UniCourTeachMap = new HashMap<>();
        try{
            Connection con = get.getConnection();
            String query =
                    "SELECT u.UNIVERSITYNAME, c.COURSENAME, t.TEACHERNAME " +
                            "FROM jdbc_practice.UNIVERSITY u " +
                            "JOIN jdbc_practice.COURSE c ON u.UID = c.UID " +
                            "JOIN jdbc_practice.COURTEACH ct ON c.CID = ct.CID " +
                            "JOIN jdbc_practice.TEACHER t ON ct.TID = t.TID";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String uName = rs.getString("UNIVERSITYNAME");
                String cName = rs.getString("COURSENAME");
                String tName = rs.getString("TEACHERNAME");

                HashMap<String, List<String>> courTeach = UniCourTeachMap.get(uName);

                if(courTeach == null) {

                    courTeach = new HashMap<>();

                    List<String> teachers = new ArrayList<>();

                    teachers.add(tName);

                    courTeach.put(cName, teachers);

                    UniCourTeachMap.put(uName, courTeach);

                } else {

                    List<String> teachers = courTeach.get(cName);

                    if(teachers == null) {

                        teachers = new ArrayList<>();

                        teachers.add(tName);

                        courTeach.put(cName, teachers);

                    } else {

                        teachers.add(tName);
                    }
                }

            }

            System.out.println(UniCourTeachMap);

            for(Map.Entry<String,HashMap<String,List<String>>> university : UniCourTeachMap.entrySet()){
                System.out.println(university.getKey());
                System.out.println(" -> ");
                HashMap<String,List<String>> courseMap = university.getValue();

                 for(Map.Entry<String,List<String>> course : courseMap.entrySet()){

                     System.out.println(course.getKey() +" -> "+ course.getValue());
                 }
                System.out.println();
            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
