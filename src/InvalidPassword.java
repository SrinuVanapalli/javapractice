/*InvalidPasswordException
Password must contain at least 8 characters.*/

import java.util.*;

class InvalidPasswordException extends RuntimeException{
    InvalidPasswordException(String message){
        super(message);
    }
}
public class InvalidPassword{
    public static String readPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a password : ");
        String password = sc.nextLine();
        return password;
    }
    public static void validatePassword(String password){
        if(password.length()<8){
         throw new InvalidPasswordException("Enter a password of minimum 8 characters");
        }
        else{
            System.out.println("Given password :"+ password);
        }
    }
    public static void main(String[] args){
        try{
            String p = readPassword();
            validatePassword(p);
        }catch(InvalidPasswordException ie){
            System.out.println(ie.getMessage());
        }finally {
            System.out.println("Exception program executed");
        }
    }
}