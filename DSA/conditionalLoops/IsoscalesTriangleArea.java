package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class IsoscalesTriangleArea {

    public static void main (String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base in cms : " );
        double base = sc.nextDouble();
        System.out.println("Enter the side in cms : ");
        double side = sc.nextDouble();
        if(side <=0 || base <= 0 || 2*side<=base){
            System.out.println("Enter the positive value :");
        }else{
            double height = Math.sqrt( (side*side)-(base/2)*(base/2));
            double area = (base * height)/2;
            System.out.println("Area of the triangle is :" + area);
        }

        sc.close();

    }
}
