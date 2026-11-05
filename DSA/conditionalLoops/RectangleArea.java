package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class RectangleArea {
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the rectangle in cms :");
        double length = sc.nextDouble();
        System.out.println("Enter the breadth of the rectangle in cms : ");
        double  breadth = sc.nextDouble();
        if(length <=0 || breadth <=0 ){
            System.out.println("Enter the positive values ");
        }else{
            double area = length*breadth;
            System.out.println("Area of the rectangle is : "+ area);
        }
        sc.close();

    }
}
