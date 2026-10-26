import java.util.*;
import java.text.SimpleDateFormat;


public class EmployeeBean {
    private Integer id;
    private String name;
    private Float salary;
    private Date dob;

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

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dob=" + dob ;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Map<Integer,EmployeeBean> employeeBeanMap = new HashMap<>();
        boolean flag = true;

        try{
            System.out.println("Enter 1 to add employee 0 to exit");
            int k = sc.nextInt();
            if(k==1){
                while(flag){
                    System.out.println("Enter an employee id ");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter an employee name");
                    String name = sc.nextLine();
                    System.out.println("Enter salary of an employee");
                    Float salary = sc.nextFloat();
                    System.out.println("Enter date of birth of an employee(dd-mm-yy)");
                    String dt = sc.next();
                   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
                   Date date = sdf.parse(dt);
                    EmployeeBean bean = new EmployeeBean();
                    bean.setId(id);
                    bean.setName(name);
                    bean.setSalary(salary);
                    bean.setDob(date);

                    employeeBeanMap.put(id, bean);

                    System.out.println("Enter 1 to add another employee 0 to exit");
                    int i = sc.nextInt();
                    if(i==1){
                        flag = true;
                    }else{
                        flag = false;
                    }

                }
                System.out.println(employeeBeanMap);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
