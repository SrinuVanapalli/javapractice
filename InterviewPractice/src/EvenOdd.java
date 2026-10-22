import java.util.*;


public class EvenOdd {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ");
         int s = sc.nextInt();

         if(s%2==0){
             System.out.println("given number is even");
         }else{
             System.out.println("given number is odd");
         }
    }
}
