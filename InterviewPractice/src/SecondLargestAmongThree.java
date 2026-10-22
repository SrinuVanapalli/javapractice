import java.util.*;



public class SecondLargestAmongThree {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ente first number ");
        int a  = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter second number");
        int b = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter third number");
        int c = sc.nextInt();

        if(a>b && a>c){
            if (b > c) {
                System.out.println("Second largest is"+ b);
            }else{
                System.out.println("Second largest is "+ c);
            }
        }else{
            if(b>c){

                if(a>=c){
                    System.out.println("second largest is "+ a);
                }else{
                    System.out.println("second largest is "+ c);
                }
            }else{
                if(a>b){
                    System.out.println("second largest is" + a);
                }else{
                    System.out.println("second largest is "+ b);
                }
            }
        }


    }
}
