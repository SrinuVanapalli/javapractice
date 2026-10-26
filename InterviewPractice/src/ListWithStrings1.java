/*ListWithStrings.java
Explain storing names in list and searching using contains.*/


import java.util.*;


public class ListWithStrings1 {
    List<String> names = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public void AddName() {

        boolean flag = true;

        while (flag) {
            System.out.println("press 1 to enter name 0 to exit");
            int k = sc.nextInt();
            sc.nextLine();
            if (k == 1) {
                System.out.println("Enter a name");
                String str = sc.nextLine();
                names.add(str);
            } else {
                flag = false;
            }
        }
    }

    public void FindName() {
        System.out.println("Enter a name you want");
        String want = sc.nextLine();

        Iterator<String> entry = names.iterator();
        while (entry.hasNext()) {
            String it = entry.next();
            if (it.equals(want)) {
                System.out.println(want + " found ");
                break;
            }
        }
    }

    public static void main(String[] args) {

        ListWithStrings1 obj = new ListWithStrings1();

        obj.AddName();

        obj.FindName();


    }
}

