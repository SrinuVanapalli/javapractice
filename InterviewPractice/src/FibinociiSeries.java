/* Input: 8
Output:
0 1 1 2 3 5 8 13
*/
import java.util.*;
public class FibinociiSeries {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n =sc.nextInt();
        int first=0;
        int second=1;
        int third;
        System.out.print(first + " "+ second + " ");
       for(int i=0; i<n-2;i++){

           third = first+second;
           first = second;
           second = third;
           System.out.print(third+" ");

       }

    }
}
