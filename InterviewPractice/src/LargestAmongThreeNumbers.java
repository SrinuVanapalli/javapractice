import java.util.*;

public class LargestAmongThreeNumbers{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ente first number ");
        int a  = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter second number");
        int b = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter third number");
        int c = sc.nextInt();

        if(a>=b){
            if( a>=c){
                System.out.println("Largest number is "+ a);
            }
        }else{
            if(b>=c){
                System.out.println("Largest number is "+ b);
            }else{
                System.out.println("Largest number is "+c);
            }
        }


    }

}

