/**
 Move All Zeros to the End
 */


public class MoveZeroEnd {

    public static void main(String[] args){

        int[] arr = {10, 0, 0, 20, 30, 0, 40};
        int j =0;
        for(int i = 0; i<arr.length;i++){
            int temp = 0 ;

               if(arr[i] !=0 ){
                   temp = arr[i];
                   arr[i]= arr[j];
                   arr[j]= temp;
                   j++;
               }
        }
        for(int i : arr) {
            System.out.print(i+ " ");
        }
    }

}