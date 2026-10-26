import java.sql.*;
import java.util.*;


public class JdbcPracticeQ2 {

    private Integer student_id;
    private String student_name;
    private Integer student_age;

    public JdbcPracticeQ2( Integer student_id, String student_name, Integer student_age){
        this.student_id= student_id;
        this.student_age= student_age;
        this.student_name= student_name;
    }
    public Integer getStudent_id(){
        return student_id;
    }

    public String getStudent_name(){
        return student_name;
    }
    public Integer getStudent_age(){
        return student_age;
    }

    public String toString(){
        return  student_id+
                " "+ student_name+
                " "+ student_age;
    }

    public static void main(String[] agrs){

        SqlConnection1 sql = new SqlConnection1();
        Scanner sc = new Scanner(System.in);
        try{
            Connection con = sql.getConnection();
            String query = "select s.id , s.age, s.name from jdbc_practice.student s where s.age >( select avg(s.age) from student s) and s.age >=?;";
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("Enter the age limit you want ");
            int i = sc.nextInt();
            ps.setInt(1,i);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){


                Integer id = rs.getInt("s.id");
                Integer age = rs.getInt("s.age");
                String name = rs.getString("s.name");

                JdbcPracticeQ2 bean = new JdbcPracticeQ2(id, name, age );

                System.out.println(bean);

            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
