public class NumberFormat {
    public static void main(String[] args){
       try {
          int num = Integer.parseInt("srinu");
           System.out.println(num);
       }catch(NumberFormatException nfe){
           System.out.println("Got Number Format Exception");
           nfe.printStackTrace();
       }finally {
           System.out.println("Exception caught");
       }
    }
}
