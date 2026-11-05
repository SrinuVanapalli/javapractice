package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class RhombusArea {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Diameter1 of the rhombus : ");
        double d1 = sc.nextDouble();
        System.out.println("Enter the Diameter2 of the rhombus : ");
        double d2 = sc.nextDouble();
        if(d1 <=0 || d2 <=0 ){
            System.out.println("Enter the positive values : ");
        }else{
           double area = (d1*d2)/2;
            System.out.println("Area of the Rhombus is : "+ area);
        }
        sc.close();
    }
}
