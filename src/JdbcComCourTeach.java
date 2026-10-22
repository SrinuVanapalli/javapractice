/* teachers having common courses from the data base*/

import java.sql.*;
import java.util.*;

class courTeach{

    private int tid;
    private String teacherName;
    private String courseNames;

    public courTeach( int tid, String teacherName, String courseNames){

        this.tid = tid;
        this.teacherName= teacherName;
        this.courseNames= courseNames;

    }

    public int getTid(){ return this.tid ;}
    public String getTeacherName(){ return this.teacherName ;}
    public String getCourseNames(){ return this.courseNames ;}

    public void setTid(int tid){ this.tid = tid ;}
    public void setTeacherName(String teacherName){ this.teacherName= teacherName ;}
    public void setCourseNames(String courseNames){ this.courseNames= courseNames;}

    @Override
    public String toString(){
        return tid+ " -> "+ teacherName + " -> "+ courseNames;
    }
}


public class JdbcComCourTeach {



    public static void main(String[] args){
         SqlConnection get =  new SqlConnection();
        HashMap<Integer, HashMap<String, List<String>>> teachIdMap = new HashMap<>();

        try{
            Connection con = get.getConnection();

            String query = "SELECT t.TID, t.TEACHERNAME, c.COURSENAME FROM jdbc_practice.COURTEACH ct JOIN jdbc_practice.TEACHER t " +
                    "ON ct.TID = t.TID JOIN jdbc_practice.COURSE c " +
                    "ON ct.CID = c.CID ORDER BY t.TID;";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int Tid = rs.getInt("TID");
                String Tname = rs.getString("TEACHERNAME");
                String Cname = rs.getString("COURSENAME");

                HashMap<String, List<String>> courses = teachIdMap.get(Tid);

                if(courses == null){
                    courses = new HashMap<>();
                    teachIdMap.put(Tid, courses);
                }

                List<String> names = courses.get(Tname);

                if(names == null){
                    names = new ArrayList<>();
                    courses.put(Tname, names);
                }
                names.add(Cname);
            }

            for(Integer tid : teachIdMap.keySet()){

                HashMap<String, List<String>> courses = teachIdMap.get(tid);

                for(String teacherName : courses.keySet()){

                    List<String> courseNames = courses.get(teacherName);

                    if(courseNames.size() > 1){
                        System.out.println(
                                tid + " -> " + teacherName + " -> " + courseNames
                        );
                    }
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
