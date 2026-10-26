import java.util.*;

public class Llist {
    public static void main(String[] args) {
        List<String> countries = new LinkedList<String>();
        Scanner sc = new Scanner(System.in);
        boolean value = true;
        while (value) {
            System.out.println("Enter a country name");
            String con = sc.nextLine();
            countries.add(con);
            System.out.println("Enter 1 to continue and 0 to exit");
            int i = sc.nextInt();
            sc.nextLine();
            if (i == 1) {
                value = true;
            } else{
                value = false;
            }

        }
        System.out.println("Enter the country you want");
        String name = sc.nextLine();

            if (countries.contains(name)) {
                System.out.println("Country is present in the list: " +name);
            } else {
                System.out.println("Entered country is not in the list");
            }



    }
}

