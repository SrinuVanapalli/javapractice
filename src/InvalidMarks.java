/*InvalidMarksException
Marks should be between 0 and 100.*/

import java.util.*;

class MarksException extends RuntimeException{
    MarksException(String mes){
        super(mes);
    }
}
public class InvalidMarks{

    public static int readMarks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Marks : ");
        int i = sc.nextInt();
        return i;
    }
    public static void validateMarks(int i){
        if(i<0 || i>100){
            throw new MarksException("Enter the marks between 0 and 100");
        }else {
            System.out.println("Given marks :"+ i);
        }
    }

    public static void main(String[] args){

        try{
           int k = readMarks();
           validateMarks(k);
        }catch(MarksException me){
            System.out.println(me.getMessage());
        }finally{
            System.out.println("Execution complete");
        }

    }
}

