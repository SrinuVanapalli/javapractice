package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class TriangleArea {

    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length in cms : " );
        double length = sc.nextDouble();
        System.out.println("Enter the height in cms : ");
        double height = sc.nextDouble();

        if( length <= 0 || height <= 0 ){
            System.out.println("Enter the positive values");
        }else{
            double area = (length * height)/2;
            System.out.println("Area of the triangle is :" + area);
        }
        sc.close();

    }

}
