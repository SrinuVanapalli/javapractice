/*NestedHastSet.java
Explain HashMap<String, HashSet<String>>: state -> capitals.*/

import java.util.*;

public class NestedHashSet1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, HashSet<String>> stateMap = new HashMap<>();

        boolean flag = true;
        while (flag) {

            System.out.println("press 1 to enter a state and 0 to exit");
            int k = sc.nextInt();
            sc.nextLine();
            if (k == 1) {

                System.out.println("Enter  a state ");
                String st = sc.nextLine();
                System.out.println("Enter a capital");
                String cp = sc.nextLine();

                HashSet<String> capitals = stateMap.get(st);
                if(capitals==null){
                    capitals = new HashSet<>();

                    capitals.add(cp);
                }
                stateMap.put(st,capitals);
            }else{
                System.out.println(stateMap);
                System.out.println("thank you");
                flag = false;
            }
        }

       Iterator<HashSet<String>> it = stateMap.values().iterator();
        while(it.hasNext()){
            HashSet<String> kk = it.next();
            System.out.println(kk);
        }

    }

}
