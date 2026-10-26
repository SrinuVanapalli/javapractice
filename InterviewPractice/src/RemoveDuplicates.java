/*
Remove Duplicates from an Array
*/

import java.util.*;


public class RemoveDuplicates {

    public static void main(String[] args){

        int[] arr = {10, 20, 10, 30, 20, 40, 10};

        for(int i =0; i<arr.length; i++){
            boolean alreadyChecked = false;

                for(int j=0; j<i; j++){
                    if(arr[i]==arr[j]){
                       alreadyChecked = true;
                       break;
                    }
                }
                if(alreadyChecked){
                    continue;
                }
            System.out.print(arr[i]+ " ");

        }

    }

}
