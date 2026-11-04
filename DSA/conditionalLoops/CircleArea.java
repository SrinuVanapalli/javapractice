//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Main.java.firstjavapractice.DSA.conditionalLoops;

import java.util.Scanner;

public class CircleArea {
    public CircleArea() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Radius of the circle in centimeters : ");
        double r = sc.nextDouble();
        double Area = 3.14 * r * r;
        System.out.println("Area of the circle in sq centimeters : " + Area);
    }
}
