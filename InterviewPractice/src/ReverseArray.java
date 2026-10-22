import java.util.*;


public class ReverseArray {

    public static void main(String[] args){

        int[] arr = {10, 20, 30, 40, 50,60};
        int temp = 0;
        int j = arr.length-1;
        int i = 0;

                while(j>i) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i++;
                    j--;
                }

         for(int k = 0 ; k<arr.length; k++) {
             System.out.print(arr[k]+ " ");
         }

        }

    }


