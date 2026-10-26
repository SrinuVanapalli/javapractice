/*ListWithNumbers.java
Explain ArrayList<Integer>, adding numbers from 1 to n.*/

import java.util.*;

public class ArrayListWithNumbers {
    ArrayList<Integer> arr = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addNumbers() {
        System.out.println("Enter a number ");
        int k = sc.nextInt();
        for (int i = 1; i <= k; i++) {
            arr.add(i);
        }
    }

    public void sumNumbers() {
        System.out.println(arr);
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args){

       ArrayListWithNumbers obj = new ArrayListWithNumbers();

       obj.addNumbers();
        obj.sumNumbers();

    }

}
