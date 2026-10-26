/*
Write a JDBC program that displays a report like:

Department | Student Count | Average Age | Min Age | Max Age
*/

import java.util.*;
import java.sql.*;


public class JdbcPracticeQ1 {

    private String department;
    private Integer studentCount;
    private Float averageAge;
    private Integer minAge;
    private Integer maxAge;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Float getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Float averageAge) {
        this.averageAge = averageAge;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return "JdbcPracticeQ1{" +
                "department='" + department + '\'' +
                ", studentCount=" + studentCount +
                ", averageAge=" + averageAge +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                '}';
    }

    public static void main(String[] args){

        SqlConnection1 sql = new SqlConnection1();

        Map<String , JdbcPracticeQ1> departmentBean = new HashMap<>();

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

                 JdbcPracticeQ1 bean = new JdbcPracticeQ1();


                 bean.setDepartment(str);
                 bean.setStudentCount(sCount);
                 bean.setAverageAge(avgAge);
                 bean.setMaxAge(mxAge);
                 bean.setMinAge(mAge);

                 departmentBean.put(str,bean);
             }

            System.out.println(departmentBean);

             for(Map.Entry<String, JdbcPracticeQ1> details : departmentBean.entrySet()){
                 System.out.println(details.getKey()+ " "+ details.getValue());
             }
             rs.close();
             ps.close();
             con.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
