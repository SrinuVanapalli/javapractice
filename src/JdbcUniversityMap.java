import java.sql.*;
import java.util.*;

class Teacher {

    private int TEACHERID;
    private String TEACHERNAME;
    private int COURSEID;
    private String COURSENAME;

    public Teacher(int TID, String TEACHERNAME, int COURSEID, String COURSENAME) {

        this.TEACHERID = TID;
        this.TEACHERNAME = TEACHERNAME;
        this.COURSEID = COURSEID;
        this.COURSENAME = COURSENAME;
    }

    public int getTID() { return this.TEACHERID; }

    public String getTEACHERNAME() { return this.TEACHERNAME; }

    public int getCID() { return this.COURSEID; }

    public String getCOURSENAME() { return this.COURSENAME; }

    @Override
    public String toString() {
        return "Teacher Id: " + TEACHERID +
                ", Teacher Name: " + TEACHERNAME +
                ", Course Id: " + COURSEID +
                ", Course Name: " + COURSENAME;
    }
}

public class JdbcUniversityMap {



    static HashMap<Integer, Map<Integer, List<Teacher>>> universityTeacherMap = new HashMap<>();

    public static void main(String[] args) {
        SqlConnection get = new SqlConnection();
        try {

            Connection con = get.getConnection();
            String query = "SELECT u.UID, " +
                    "c.CID, " +
                    "c.COURSENAME, " +
                    "t.TID, " +
                    "t.TEACHERNAME " +
                    "FROM UNIVERSITY u " +
                    "JOIN COURSE c " +
                    "ON u.UID = c.UID " +
                    "JOIN COURTEACH ct " +
                    "ON c.CID = ct.CID " +
                    "JOIN TEACHER t " +
                    "ON ct.TID = t.TID";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int universityId = rs.getInt("UID");

                int courseId = rs.getInt("CID");

                String courseName = rs.getString("COURSENAME");

                int teacherId = rs.getInt("TID");

                String teacherName = rs.getString("TEACHERNAME");

                Teacher teacher = new Teacher(
                                teacherId,
                                teacherName,
                                courseId,
                                courseName
                        );

                Map<Integer,List<Teacher>> teacherMap = universityTeacherMap.get(universityId);
                if(teacherMap==null) {
                    teacherMap = new HashMap<>();
                    universityTeacherMap.put(universityId, teacherMap);
                }
                    List<Teacher> teachers = teacherMap.get(courseId);
                    if(teachers==null){
                        teachers = new ArrayList<>();
                        teacherMap.put(courseId,teachers);
                    }
                    teachers.add(teacher);

            }

            rs.close();
            ps.close();
            con.close();

            System.out.println("Teacher Course University Map:");
            System.out.println(universityTeacherMap);

           for(Map.Entry<Integer,Map<Integer,List<Teacher>>> university : universityTeacherMap.entrySet()){

               System.out.println(university.getKey()+" -> ");

               Map<Integer,List<Teacher>> course = university.getValue();

               for(Map.Entry<Integer,List<Teacher>> courses : course.entrySet()){

                   System.out.println(courses.getKey()+ " -> "+ courses.getValue());
               }
               System.out.println();
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}