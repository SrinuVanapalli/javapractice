import java.util.*;
import java.text.SimpleDateFormat;


public class StudentBean {

    private Integer id;
    private String name;
    private Date doj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doj=" + doj +
                '}';
    }

    public static void main(String[] args){

        Map<Integer,StudentBean> studentBeanMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter 1 to add student 0 to exit");
            int i = sc.nextInt();
            boolean flag = true;
            if (i == 1) {
                while (flag) {
                    System.out.println("Enter student id ");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter student name");
                    String name = sc.nextLine();
                    System.out.println("Enter date of joining");
                    String dt = sc.next();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
                    Date date = sdf.parse(dt);

                    StudentBean bean = new StudentBean();
                    bean.setId(id);
                    bean.setName(name);
                    bean.setDoj(date);

                    studentBeanMap.put(id,bean);
                    System.out.println("Enter 1 to add another student or 0 to exit");
                    int k = sc.nextInt();
                    if(k==1){
                        flag = true;
                    }else{
                        flag = false;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(studentBeanMap);
    }

}
