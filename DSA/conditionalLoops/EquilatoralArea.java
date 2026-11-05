package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class EquilatoralArea {
    public static void main(String agrs[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the side in cms : ");
        double s = sc.nextDouble();
        if(s<=0){
            System.out.println("Enter the positive values ");
        }else{
            double area = (Math.sqrt(3)/4)*s*s;
            System.out.println("Area of the Equilateral triangle is : "+ area);
        }
        sc.close();
    }
}
