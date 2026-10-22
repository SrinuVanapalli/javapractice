/*

 */


import java.util.*;



public class UserDefinedException {

    static class ExceptionInSalary extends RuntimeException {

        ExceptionInSalary(String message) {
            super(message);
        }
    }

  public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
      System.out.println("Enter employee salary");
      int sl = sc.nextInt();

      try{
          if(sl>0 && sl<1000){
              System.out.println("given salary of the employee : "+sl );
          }else{
              throw new ExceptionInSalary( "Enter valid salary between 1 to 999");
          }
      }catch(ExceptionInSalary e){
          System.out.println(e.getMessage());
      }
  }

}
