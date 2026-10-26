import java.util.*;

public class NestedHashList {

    public static void main(String[] args) {
        addItems();
    }
    public static void addItems(){
        Map<String, List<String>> marketlist = new HashMap<>();
        List<String> list = new ArrayList<>();
        marketlist.put("items", list);

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Enter an item for list");
            String li = sc.nextLine();

            list.add(li);

            System.out.println("press 1 to continue and 0 to exit");
            int i = sc.nextInt();
            sc.nextLine();

            if (i == 0) {
                flag = false;
            }
        }
        System.out.println(marketlist);
    }
}

