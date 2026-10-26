/*Find the Second Smallest Element*/

import java.util.*;


public class SmallestArray {

  public static void main(String[] args){

      int[] arr = {40, 10, 25, 5, 7, 30, 15};

      int small = arr[0];
      int second = Integer.MAX_VALUE;
      for(int i = 0; i<arr.length;i++){

          if(small>arr[i]){
              second = small;
              small = arr[i];
          }else{
              if(second>arr[i] && arr[i]>small){
                  second = arr[i];
              }
          }

      }
      System.out.println(" smallest "+ small+ " second smallest "+ second);
  }
}
