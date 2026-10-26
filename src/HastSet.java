import java.util.*;

public class HastSet {

    public static void main(String[] args){
        HashSet<String> names = new HashSet<String>();

        names.add("Volvo");
        names.add("BMW");
        names.add("Ford");
        names.add("BMW");  // Duplicate
        names.add("Mazda");
        System.out.println(names.contains("Mazda"));

        Iterator it = names.iterator();
         while (it.hasNext()){
             System.out.println(it.next());

         }
    }
}
