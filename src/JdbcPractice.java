/*University ID → Course Name → Teacher Name
1
  MARINE BIOLOGY -> [SRINU, KOMAL, VASU, MANI]
  GEOLOGY        -> [RAVI, SURESH, ANITA, DEEPA]
  BIO TECH       -> [KIRAN, MADHU, PRIYA, NAVEEN]
  MATHS          -> [ARUN, SINDHU, RAJESH, PAVANI]

2
  POL SCI -> [...]
  ANTHRO  -> [...]

 */

import java.sql.*;
import java.util.*;

class teacher{
    private int uid;
    private String cname;
    private String tname;

    public teacher(int uid, String cname, String tname){
        this.uid=uid;
        this.cname= cname;
        this.tname=tname;
    }
    public int getUid(){ return this.uid ;}
    public String getCname(){ return this.cname ;}
    public String getTname(){ return this.tname ;}

    @Override
    public String toString(){
        return uid+"\n"+
                cname+ "->"+ tname;
    }
}

public class JdbcPractice{



    public static void main(String[] args){
        SqlConnection get = new SqlConnection();
        Map<Integer, HashMap<String, List<String>>> uidMap = new HashMap<>();
         try{
             Connection con = get.getConnection();

        String query  = "select c.UID, c.COURSENAME, t.TEACHERNAME from jdbc_practice.course c join jdbc_practice.teacher t on t.CID = c.CID; ";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            int UnId = rs.getInt("UID");
            String CrName = rs.getString("COURSENAME");
            String TeName = rs.getString("TEACHERNAME");


                HashMap<String,List<String>> courseName = uidMap.get(UnId);

                if(courseName==null){

                    courseName = new HashMap<>();

                    uidMap.put(UnId,courseName);

                    List<String> teacher = courseName.get(CrName);

                    if(teacher== null){

                        teacher = new ArrayList<>();

                        teacher.add(TeName);
                        courseName.put(CrName,teacher);

                    }

                }else{
                    courseName = uidMap.get(UnId);

                    List<String> teacher = courseName.get(CrName);

                    if(teacher == null){

                        teacher = new ArrayList<>();

                        teacher.add(TeName);
                        courseName.put(CrName,teacher);
                        uidMap.put(UnId, courseName);

                    }else{
                        teacher.add(TeName);
                    }

                }
        }
             System.out.println(uidMap);

         for(Map.Entry<Integer,HashMap<String,List<String>>> university : uidMap.entrySet()){

             System.out.println(university.getKey());

             for(Map.Entry<String,List<String>> course: university.getValue().entrySet()){

                 System.out.println(" " + course.getKey()+ " -> "+ course.getValue());


             }
             System.out.println();
         }

             rs.close();
             ps.close();
             con.close();
    }catch(Exception e){
            e.printStackTrace();
         }
}}