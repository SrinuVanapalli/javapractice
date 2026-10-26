/* Write a Java program to count how many times a particular character appears in a String.*/

import java.util.Scanner;

public class Practice{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();

                for (int i = 0; i<str.length(); i++){
                    boolean alreadyChecked = false;
                    int count = 0;
                     for(int k =0; k<i; k++){
                         if(str.charAt(k)==str.charAt(i)){
                             alreadyChecked= true;
                             break;
                         }
                     }
                     if(alreadyChecked){
                         continue;
                     }
                    for(int j = 0; j<str.length();j++){

                        if(str.charAt(i)==str.charAt(j)){
                            count++;
                        }
                    }
                    System.out.println(str.charAt(i) + " is " + count);
                }

    }

}