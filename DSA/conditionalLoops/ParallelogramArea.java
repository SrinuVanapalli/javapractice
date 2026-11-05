package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class ParallelogramArea {
    public static void main(String args []){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base of parallelogram in cms ");
        double base = sc.nextDouble();
        System.out.println("Enter height of the parallelogram in cms ");
        double height = sc.nextDouble();
        if(base <=0 || height <=0){
            System.out.println("Enter the positive values ");
        }else{
            double area = base * height;
            System.out.println("Area of the parallelogram is "+ area);
        }
        sc.close();
    }

}
