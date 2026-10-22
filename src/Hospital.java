import java.util.*;
import java.util.Map;
public class Hospital {
    public static void main(String[] args){
        Map<String,Map<String,List<String>>> Hospitals = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean value = true;
        while(value){
            System.out.println("Enter a Hospital");
            String h = sc.nextLine();
            System.out.println("Enter a Department");
            String dp = sc.nextLine();
            System.out.println("Enter list of doctors");
            String ds = sc.nextLine();
            Map<String,List<String>> departments = Hospitals.get(h);
            if(departments == null){
                departments = new HashMap<>();
                Hospitals.put(h,departments);
            }
            List<String> doctors = departments.get(dp);
            if(doctors == null);
            {
                doctors = new ArrayList<>();
                departments.put(dp, doctors);
            }
            doctors.add(ds);
            System.out.println("do you want to add more doctors to the list press 1 or else 0");
            int i = sc.nextInt();
            sc.nextLine();
            while(i != 0){
                System.out.println("add a doctor");
                String newdoc = sc.nextLine();
                doctors.add(newdoc);
                System.out.println("do you want to add more press 1 , or 0 to exit");
                i = sc.nextInt();
                sc.nextLine();
                if(i==0){
                    break;
                }
            }
           System.out.println("press 1 to add another hospital or 0 to exit");
            int j = sc.nextInt();
            sc.nextLine();
            if(j==0){
                value = false;
            }
        }
            System.out.println(Hospitals);

        System.out.println("Enter the hospital name you want");
        String hos = sc.nextLine();
        if(Hospitals.containsKey(hos)){
            System.out.println(Hospitals.get(hos));
        }else{
            System.out.println("Enter a valid hospital name");
        }
    }
}
