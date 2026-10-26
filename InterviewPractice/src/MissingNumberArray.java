/*Given an array containing numbers from 1 to n, with one number missing, find the missing number*/

import java.util.*;

public class MissingNumberArray {

    public static void main(String[] args){

        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10,11};
         int sum = 0;
        for(int i = 0; i<arr.length; i++){
             sum += arr[i];
        }
        int n = arr.length+1;
        int Expected = n*(n+1)/2;
       int result = Expected-sum;
           System.out.println("Missing number is "+ result);
    }

}
