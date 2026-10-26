import java.util.*;

public class DuplicateChar1{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();

        for(int i = 0; i<str.length();i++){

            int count = 0;
            boolean checked = false;
            for(int k = 0;k<i; k++){
                if(str.charAt(k)==str.charAt(i)){
                    checked= true;
                    break;
                }
            }
            if(checked){
                continue;
            }
             for(int j = 0; j<str.length();j++){

                 if(str.charAt(i)==str.charAt(j)){
                     count ++;

                 }
             }
            if(count>=1){
                System.out.println(str.charAt(i)+ " -> "+ count);
            }

        }

    }
}