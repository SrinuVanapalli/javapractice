import java.util.*;
import java.util.Map;

public class MarketList{
    public static void main(String[]args) {
        Map<String, Map<String, List<String>>> Market = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean value = true;
        while (value) {
            System.out.println("Enter a market Place");
            String mp = sc.nextLine();
            System.out.println("Enter a Day");
            String dy = sc.nextLine();
            System.out.println("Enter items");
            String it = sc.nextLine();
            Map<String, List<String>> Day = Market.get(mp);
            if (Day == null) {
                Day = new HashMap<>();
                Market.put(mp, Day);
            }
            List<String> Items = Day.get(dy);
            if (Items == null) {
                Items = new ArrayList<>();
                Day.put(dy, Items);
            }
            Items.add(it);
            System.out.println("do you want to add more items to the list press 1 else 0");
            int i = sc.nextInt();
            sc.nextLine();
            while (i != 0) {
                System.out.println("add item");
                String newItem = sc.nextLine();
                Items.add(newItem);
                System.out.println("do you want to add another item press 1 else 0");
                i = sc.nextInt();
                sc.nextLine();
            }
            System.out.println("do you want to continue adding market places press 1 else 0");
            int k = sc.nextInt();
            sc.nextLine();
            if (k == 0) {
                value = false;
            }
        }
            System.out.println(Market);
            System.out.println("Enter the Market place you want ");
            String p = sc.nextLine();
            if (Market.containsKey(p)) {
                System.out.println(Market.get(p));
            } else {
                System.out.println("Enter an existing market place");
            }
    }
}
