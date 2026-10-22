import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class PracticeJava {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number ");
        int i = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for(int j = 1; j<=i; j++){
            numbers.add(j);
        }

        System.out.println(numbers);

        Iterator<Integer> it = numbers.iterator();
        StringBuilder st = new StringBuilder();
          while(it.hasNext()){
              st.append(it.next());
              if(it.hasNext()){
                  st.append(", ");
              }
          }

        System.out.println(st);

    }

}
