/*NestedHashList.java
Explain Map<String, List<String>>.*/

import java.util.*;


public class NestedHashList1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        HashMap<String , List<String>> countryMap = new HashMap<>();

        boolean flag = true;

        while(flag){

            System.out.println("press 1 to add country 0 to exit");
            int k = sc.nextInt();
            sc.nextLine();
            if (k == 1) {

                System.out.println("Enter a country");
                String con = sc.nextLine();
                System.out.println("Enter a state");
                String sta = sc.nextLine();

                List<String> states = countryMap.get(con);
                if (states == null) {
                    states = new ArrayList<>();
                    countryMap.put(con, states);
                }
                states.add(sta);

            }else{
                System.out.println("thank you");
                flag = false;
            }


        }
        System.out.println(countryMap);
    }
}
