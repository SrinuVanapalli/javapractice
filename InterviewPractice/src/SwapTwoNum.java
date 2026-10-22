import java.util.*;

public class SwapTwoNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number");
        int a = sc.nextInt();
        int orgA = a;
        System.out.println("Enter second number");
        int b = sc.nextInt();
        int orgB = b;

        a = a + b;
        b = a- b;
        a = a - b;

        System.out.println("orginal numbers "+ orgA+ " "+ orgB+ " swapped numbers " + a + " "+ b);
    }

}
