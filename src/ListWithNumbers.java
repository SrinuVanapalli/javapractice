import java.util.*;
public class ListWithNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);
        Iterator<Integer> it = numbers.iterator();
        StringBuilder output = new StringBuilder();
        while (it.hasNext()) {
            output.append(it.next());
            if (it.hasNext()) {
                output.append(", ");
            }
        }
        System.out.println(output.toString());
    }
}

