/*Create a Java program using a TreeSet<Integer> to store the following numbers:

        45, 12, 78, 23, 12, 56, 89, 34, 23, 10

Your program should:

Add all the numbers to the TreeSet.
Print the elements.
Print the smallest element.
Print the largest element.
Check whether 56 exists.
        Remove 23.
Print the final TreeSet.*/


import java.util.Scanner;
import java.util.TreeSet;

public class TreeSet1 {

    public static void main(String[] args){

        TreeSet<Integer> numbers = new TreeSet<>();
        Scanner sc = new Scanner(System.in);


        boolean flag = true;
        while(flag){
            System.out.println("Enter number to the set");
            int k = sc.nextInt();
            numbers.add(k);
            System.out.println("press 1 to continue 0 to exit");
            int i = sc.nextInt();
            if(i==0){
                flag = false;
            }else{
                flag  = true;
            }
        }

        System.out.println(numbers);
        System.out.println("smallest element :" + numbers.first());
        System.out.println("largest element :" + numbers.last());

             if(numbers.contains(56)){
                 System.out.println(56);
             }

         numbers.remove(23);
        System.out.println(numbers);
        System.out.println(numbers.higher(40));
        System.out.println(numbers.lower(40));
        System.out.println(numbers.ceiling(40));
        System.out.println(numbers.floor(40));
    }

}
