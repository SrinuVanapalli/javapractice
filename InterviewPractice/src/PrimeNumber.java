import java.util.*;

public class PrimeNumber{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int k = sc.nextInt();

        boolean isPrime = true;

         if(k<2){
             isPrime = false;
         }else {
             for (int i = 2; i < k; i++) {
                 if (k % i == 0) {
                     isPrime = false;
                 }
             }
         }

        if(isPrime){
            System.out.println("Number is prime");
        }else{
            System.out.println("Number is not a prime");
        }
    }
}