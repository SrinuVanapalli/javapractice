public class LargestNumSecLarArray {

    public static void main(String[] args){

        int [] arr = { 10,25,60,80,26,90, 85,87,100};

        int lar= arr[0] ;
        int sec = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){

            if(arr[i]>lar) {
                sec = lar;
                lar = arr[i];
            }else{
                    if(arr[i]>sec){
                        sec = arr[i];
                    }
            }

        }
        System.out.println("Largest number in the array "+ lar + " second largest "+ sec);
    }

}
