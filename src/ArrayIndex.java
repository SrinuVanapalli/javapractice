public class ArrayIndex {

    public static void main(String[] args){
        try{
            int[] arr = new int[3];
            System.out.println(arr[4]);
        }catch(ArrayIndexOutOfBoundsException k){
            System.out.println("Got ArryaIndexOutOfBoundsException");
        }
        finally {
            System.out.println("Exception caught");
        }
    }
}

