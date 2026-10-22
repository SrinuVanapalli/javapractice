import java.util.Scanner;

public class DuplicateCharacters {


    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        System.out.println("Duplicate characters are:");

        for (int i = 0; i < str.length(); i++) {

            int count = 1;
            boolean alreadyChecked = false;
            for(int k = 0 ; k<i; k++){
                if(str.charAt(i)==str.charAt(k)){
                    alreadyChecked = true;
                    break;
                }
            }
            if(alreadyChecked){
                continue;
            }
            if (str.charAt(i) == ' ') {
                continue;
            }
            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }
            if (count > 1) {
                System.out.println(str.charAt(i) + " : " + count);
            }
        }
    }
}

