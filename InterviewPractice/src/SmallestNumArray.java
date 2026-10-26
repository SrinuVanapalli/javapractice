import java.util.*;


public class SmallestNumArray {

    public static void main(String[] args){

        int[] arr ={ 10,35,90,50,41,20,7,100};

        int small = arr[0];

        for(int i = 0; i<arr.length; i++){

            if(arr[i]<small){
                small = arr[i];
            }

        }
        System.out.println("Smallest number in array "+ small);

        int sum = 0;

        for(int j = 0; j< arr.length; j++){

            sum += arr[j];
        }
        System.out.println("sum of the numbers in the array "+ sum);
            int evenCount = 0;
            int oddCount = 0;
        for(int i = 0 ; i<arr.length; i++){



            if(arr[i]%2==0){
                evenCount++;
            }else{
                oddCount++;
            }

        }
        System.out.println("Number of even numbers "+ evenCount+" Number of odd numbers "+ oddCount);
         int [] rev= new int[8];
         int j = 0;
        for(int i = arr.length-1; i>=0; i--) {
                rev[j] = arr[i];
                j++;
        }
        for(int i =0; i<rev.length; i++){
        System.out.print( rev[i]+ " ");
        }

    }
}

