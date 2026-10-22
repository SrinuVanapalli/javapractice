import java.util.*;


public class ReverseOutput {

public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter 0 or 1");
    int k = sc.nextInt();

    if(k==0){
         System.out.println(1);
     }else {
        if (k == 1) {
            System.out.println(0);
        }

        System.out.println(1 - k);

        System.out.println(k ^ 1);
    }
}
}
