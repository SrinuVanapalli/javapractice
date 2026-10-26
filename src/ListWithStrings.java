import java.util.*;
public class ListWithStrings {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        boolean value = true;
        while (value) {
            System.out.println("Enter a name");
            String str = sc.nextLine();
            names.add(str);

            System.out.println("Enter 1 to continue and 0 to stop");
            int i = sc.nextInt();
            sc.nextLine();
            if (i == 0) {
                value = false;
                break;
            }
        }

        System.out.println("Enter a name you want");
        String na = sc.nextLine();
        if (names.contains(na)) {
            System.out.println("name is presnt in the list: " + na);
        } else {
            System.out.println("name is not presnt in the list ");
        }
    }

}

