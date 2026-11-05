package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class PerimeterOfTheCircle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of the circle in cms : ");
        double r = sc.nextDouble();
        if(r<=0){
            System.out.println("Enter positive values ");
        }else{
            double peri = 2*r*Math.PI;
            System.out.println("Perimeter of the circle : "+ peri);
        }
    }
}
