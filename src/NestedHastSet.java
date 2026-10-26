import java.util.*;

public class NestedHastSet {
    public static void main(String[] args) {
        addStatesCapitals();
    }

    public static void addStatesCapitals () {
        HashMap<String, HashSet<String>> state = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Enter a state name");
            String st = sc.nextLine();

            System.out.println("Enter a capital name");
            String ct = sc.nextLine();
            HashSet<String> capital = new HashSet<>();
            capital.add(ct);
            state.put(st, capital);
            System.out.println("Enter 1 to continue and 0 to exit");
            int i = sc.nextInt();
            sc.nextLine();
            if (i == 0) {
                flag = false;
            }

        }
        System.out.println(state);

    }
}


