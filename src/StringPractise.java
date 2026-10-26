

/*Given a string, print only the characters that appear exactly once*/

import java.util.*;

 public class StringPractise{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();

        for(int i =0; i<str.length(); i++){
            int count = 0;

            for(int k=0;k<str.length();k++){
                if(str.charAt(i)==str.charAt(k)){
                    count++;
                }
            }
            if(count==1){
                System.out.println(str.charAt(i));

            }
        }

    }
}
