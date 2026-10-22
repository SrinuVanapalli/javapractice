import java.util.Scanner;

public class Test{

    static class SalaryException extends RuntimeException{
        SalaryException (String message){
            super(message);
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary of person");
        Double salary = sc.nextDouble();

        try{

            if(salary<1000){
                throw new SalaryException("Enter salary above 1000");
            }else{
                System.out.println("Given salary is "+ salary );
            }

        }catch(SalaryException se){
            System.out.println(se.getMessage());
        }

    }
}