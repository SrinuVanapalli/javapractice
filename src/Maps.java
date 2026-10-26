import java.util.*;

public class Maps{
    public static void main ( String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String, String> student = new  HashMap<String, String>();

        boolean value = true;

        while(value){
            System.out.println("Enter a student name");
            String st = sc.nextLine();
            System.out.println("Enter a father name");
            String fa = sc.nextLine();
            student.put(st,fa);
            System.out.println("Enter 1 to continue and 0 to exit");
            int i = sc.nextInt();
            sc.nextLine();

            if (i ==0){
                value = false;
            }else {
                value = true;
            }
        }
        System.out.println("Enter student name you want");
        String name = sc.nextLine();
        if(student.containsKey(name)){
            System.out.println(student.get(name));
        }else{
            System.out.println("Given name is not present");
        }
        System.out.println(student);
        System.out.println(student.size());
    }
}
