public class NullPointer {

    public static void main(String[] args) {

       try {
           String str = null;

           System.out.println(str.length());

       }catch(NullPointerException ae){
           System.out.println("Got null pointer exception");

        }
       finally{
           System.out.println("Exception caught");
       }
    }
}
