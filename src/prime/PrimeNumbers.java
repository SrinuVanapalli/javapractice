import java.util.*;
public class  PrimeNumbers {

        public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number");
            int number = sc.nextInt();

            boolean isPrime = true;

            if (number < 2) {
                isPrime = false;
            } else {

                for (int i = 2; i < number; i++) {

                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.println(number + " is a Prime Number");
            } else {
                System.out.println(number + " is Not a Prime Number");
            }
        }
}

