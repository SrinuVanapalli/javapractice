import java.util.*;


public class DuplicateNumArray {

    public static void main(String[] args){

        int[] arr = {10, 20, 10, 30, 20, 40, 10};

        for(int i = 0; i<arr.length;i++){
            int count = 0;
            boolean alreadyChecked = false;

             for(int k = 0; k<i ; k++){
                 if( arr[i]== arr[k]){
                     alreadyChecked = true;
                     break;
                 }
             }
            if(alreadyChecked){
                continue;
            }
            for(int j = 0; j<arr.length; j++){

                if(arr[i]== arr[j]){
                    count++;
                }
            }
            if(count>1){
                System.out.println(arr[i]+ " occurs "+ count);
            }

        }

    }

}
