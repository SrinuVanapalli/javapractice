
/*Print every distinct character and how many times it occurs.

Each character should be printed only once.*/

import java.util.*;

public class StringPractise2{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String str = sc.nextLine();
        boolean checked = false;
        for( int i = 0; i<str.length(); i++){
            checked = false;
            int count = 0;
            for(int k=0; k<i ; k ++){
                if(str.charAt(k)==str.charAt(i)){
                    checked = true;
                    continue;
                }
            }
            if(checked){
                continue;
            }
            for(int j = 0; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
                checked = true;
            }
         if(count>=0) {
                 System.out.println(str.charAt(i) + " " + count);
         }

        }

    }
}
