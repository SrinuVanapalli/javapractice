/*
Write a JDBC program that accepts:
Enter university name:
For example:
Enter university name: AU
and displays:
University | Course | Teacher
 */

import java.sql.*;
import java.util.*;


public class JdbcPracticeQ3 {

    private String univeristy_name;
    private String course_name;
    private String teacher_name;

    public  JdbcPracticeQ3(String univeristy_name, String course_name, String teacher_name){

        this.univeristy_name= univeristy_name;
        this.course_name= course_name;
        this.teacher_name= teacher_name;
    }

    public String getUniveristy_name(){
        return univeristy_name;
    }
    public String getCourse_name(){
        return course_name;
    }
    public String getTeacher_name(){
        return teacher_name;
    }

    public String toString(){
        return univeristy_name+ " | "+ course_name + " | "+ teacher_name;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SqlConnection1 sql = new SqlConnection1();
        Map<String , Map<String, List<String>>> universityCourseTeacher = new HashMap<>();
        try{
            Connection con = sql.getConnection();
            String query = "select  u.universityname as UniversityName, c.coursename as CourseName, t.teachername as TeacherName from university u\n" +
                    " left join course c on u.uid = c.uid\n" +
                    " left join courteach ct on ct.cid = c.cid\n" +
                    " left join teacher t on t.tid = ct.tid " +
                    "where u.universityname = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter the universityname ");
            String uname = sc.nextLine();
            ps.setString(1,uname);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String universityName = rs.getString("UniversityName");
                String courseName = rs.getString("CourseName");
                String teacherName = rs.getString("TeacherName");

                Map<String, List<String>> courseTeacher = universityCourseTeacher.get(universityName);
                if(courseTeacher== null){
                    courseTeacher = new HashMap<>();
                }
                universityCourseTeacher.put(universityName,courseTeacher);
                List<String> teachers = courseTeacher.get(courseName);
                if(teachers==null){
                    teachers= new ArrayList<>();
                }
                courseTeacher.put(courseName,teachers);
               teachers.add(teacherName);

            }

            for(Map.Entry<String, Map<String,List<String>>> finalMap : universityCourseTeacher.entrySet()){
                System.out.println(finalMap.getKey() + "\n " );

                Map<String,List<String>> finalMap1 = finalMap.getValue();

                for(Map.Entry<String,List<String>> courteachMap : finalMap1.entrySet()){
                    System.out.println(courteachMap.getKey() + " " + courteachMap.getValue());

                }
            }

            rs.close();
            ps.close();
            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
