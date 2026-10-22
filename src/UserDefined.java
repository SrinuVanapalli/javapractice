/*InvalidSalaryException
Salary cannot be less than 0.*/

import java.util.*;

class SalaryException extends RuntimeException {
    SalaryException(String i) {
        super(i);
    }
}

public class UserDefined {


    public static int readSalary() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter salary : ");
        int i = sc.nextInt();
        return i;
    }

    public static void validateSalary(int i) {
        if (i < 0) {
            throw new SalaryException("Enter salary above 0");
        } else {
            System.out.println("Given salary : " + i);
        }

    }


    public static void main(String[] args) {

        try {
            int k = readSalary();
            validateSalary(k);
        } catch (SalaryException s) {

            System.out.println(s.getMessage());
        } finally {
            System.out.println("Salary program executed");
        }

    }
}
