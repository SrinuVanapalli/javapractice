import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/*
Write a JDBC program that displays a report like:

Department | Student Count | Average Age | Min Age | Max Age
*/

public class JdbcPracticeQ11 {

    private String department;
    private Integer studentCount;
    private Float averageAge;
    private Integer minAge;
    private Integer maxAge;

    public JdbcPracticeQ11( String department, Integer studentCount, Float averageAge, Integer minAge, Integer maxAge){

         this.department = department;
         this.studentCount = studentCount;
         this.averageAge = averageAge;
         this.minAge = minAge;
         this.maxAge = maxAge;
    }

   public String getDepartment(){
        return department;
   }

   public Integer getStudentCount(){
        return studentCount;
   }

   public Float getAverageAge(){
        return averageAge;
   }

   public Integer getMinAge(){
        return minAge;
   }

   public Integer getMaxAge(){
        return maxAge;
   }

    @Override
    public String toString() {
        return
                "\n studentCount=" + studentCount +
                "\naverageAge=" + averageAge +
                "\nminAge=" + minAge +
                "\nmaxAge=" + maxAge ;
    }

    public static void main(String[] args){

        SqlConnection1 sql = new SqlConnection1();

        Map<String , JdbcPracticeQ11> departmentBean = new HashMap<>();

        try{
            Connection con = sql.getConnection();

            String query = "select dm.department , count(s.id) as Student_Count , avg(s.age) as Average_age, min(s.age) as Min_age, max(s.age) as Max_age from \n" +
                    "jdbc_practice.departmentmaster dm join jdbc_practice.department d on dm.id = d.department \n" +
                    "join jdbc_practice.student s on s.id = d.id \n" +
                    "group by dm.department ; ";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String str = rs.getString("dm.department");
                Integer sCount = rs.getInt("Student_Count");
                Float avgAge = rs.getFloat("Average_age");
                Integer mAge = rs.getInt("Min_age");
                Integer mxAge = rs.getInt("Max_age");

                JdbcPracticeQ11 bean = new JdbcPracticeQ11(str, sCount,avgAge,mAge,mxAge);

                departmentBean.put(str,bean);
            }

            for(Map.Entry<String, JdbcPracticeQ11> details : departmentBean.entrySet()){

                System.out.println("Department " +details.getKey()+ " "+ details.getValue());
                System.out.println();

            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

