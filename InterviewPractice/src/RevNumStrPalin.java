/* reverse a number , sum of digits , string then check if the number and string is a palindrome or not*/

import java.util.*;



public class RevNumStrPalin {

  Scanner sc = new Scanner(System.in);

    public void sumDigits(int original){

        int k = original;
        int sum = 0;

        while(k>0){
            sum += k%10;
            k= k/10;
        }
        System.out.println("Sum of the digits : "+ sum);
    }

    public int revNumber(int original){

        int k = original;

        int rev = 0;
        int temp ;
        while(k>0){

            temp = k%10;
            rev = rev*10+ temp;
            k = k/10;
        }
        return rev;

    }

    public String revString(String strorg){

        String str = strorg;

        String rev = "";

        for(int i = str.length()-1; i>=0; i--){

            rev = rev+ str.charAt(i);

        }
        return rev;
    }

    public boolean isPallindromeNumber(int original, int reversed){
         if(original==reversed){
             return true;
         }else {
         return false;
         }
    }

    public boolean isStringPallindrome(String strorg, String strrev){
        if(strorg.equals(strrev)){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        RevNumStrPalin obj = new RevNumStrPalin();
        System.out.println("Enter a number");


        int original = obj.sc.nextInt();
        int reversed = obj.revNumber(original);
        System.out.println("Original number is " + original);
        System.out.println("Reversed number is " + reversed);

         boolean result = obj.isPallindromeNumber(original,reversed);

         if(result){
             System.out.println("Given number is pallindrome ");
         }else{
             System.out.println("Given number is not pallindrome");
         }
         obj.sumDigits(original);
         obj.sc.nextLine();

        System.out.println("Enter a string ");
        String strorg = obj.sc.nextLine();
        String strrev = obj.revString(strorg);
        System.out.println("Original string is "+ strorg);
        System.out.println("Reversed string is " + strrev);

        boolean StringrevCheck = obj.isStringPallindrome(strorg,strrev);

        if(StringrevCheck){
            System.out.println("Given string is pallindrome");
        }else{
            System.out.println("Given string is not a pallindrome");
        }
    }
}



