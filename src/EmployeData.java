import java.util.*;
import java.util.Map;

public class EmployeData {

    public static void main(String[] args) {

        addEmployeeDetails();
    }
    public static void addEmployeeDetails(){
        Map<Integer, Map<String, List<String>>> EmployeeData = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag){

            System.out.println("Enter an Employee Id");
            Integer id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Employee name");
            String na = sc.nextLine();
            System.out.println("Enter Employee city name");
            String ct = sc.nextLine();
            System.out.println("Enter Employee type name");
            String tp = sc.nextLine();


            Map<String, List<String>> details = EmployeeData.get(id);
            if(details == null){
                details = new HashMap<>();
                EmployeeData.put(id,details);
            }
            List<String> obj  = details.get(na);
            if(obj == null) {
                obj = new ArrayList<>();
                details.put(na, obj);
            }
            obj.add(ct);
            obj.add(tp);

            System.out.println("press 1 to continue and 0 to exit");
            int i = sc.nextInt();
            if(i == 0)
                flag = false;
        }
        System.out.println(EmployeeData);
        System.out.println("Enter an employee id you want");
        int i = sc.nextInt();
        sc.nextLine();

         if (EmployeeData.containsKey(i)){
             System.out.println(EmployeeData.get(i));
         }else{
             System.out.println("id is not present");
         }
    }

}
