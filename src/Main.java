import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        ReverseNumber rn = new ReverseNumber();

        int reversedNumber = rn.reverse(number);
        int digitSum = rn.addDigits(number);

        PalindromeCheck pc = new PalindromeCheck();
        boolean isPallendrome = pc.isPalindrome(number);

        System.out.println("\nOriginal Number : " + number);
        System.out.println("Reversed Number : " + reversedNumber);
        System.out.println("Sum of Digits   : " + digitSum);
        System.out.println("isPalendrome  : " + isPallendrome);

        sc.nextLine();

        System.out.print("\nEnter a string: ");
        String text = sc.nextLine();

        String reversedString = rn.reverseString(text);

        System.out.println("Original String : " + text);

        System.out.println("Reversed String : " + reversedString);

        if (pc.isStringPalindrome(text)) {
            System.out.println("\"" + text + "\" is a Palindrome String.");
        } else {
            System.out.println("\"" + text + "\" is not a Palindrome String.");
        }
        sc.close();
    }
}

class ReverseNumber {

    public int reverse(int number) {
        int reversed = 0;


        while (number != 0) {
            int lastDigit = number % 10;
            reversed = (reversed * 10) + lastDigit;
            number = number / 10;
        }

        return reversed;
    }

    public int addDigits(int number) {
        int sum = 0;
        int numb = Math.abs(number);

        while (numb != 0) {
            sum += numb % 10;
            numb = numb / 10;
        }

        return sum;
    }

    public String reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return reversed;
    }
}

class PalindromeCheck {


    public boolean isPalindrome(int num) {
        ReverseNumber reverseNumber = new ReverseNumber();
        int reverseNum =  reverseNumber.reverse(num);
        return num == reverseNum;
    }


    public boolean isStringPalindrome(String str) {
        ReverseNumber reverseNumber = new ReverseNumber();
        String reverseString = reverseNumber.reverseString(str);
        return str.equals(reverseString);
    }
}