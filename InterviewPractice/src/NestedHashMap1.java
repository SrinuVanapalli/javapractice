/*NestedHashMap.java
Explain nested map: state -> district -> cities.*/


import java.util.*;



public class NestedHashMap1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        HashMap<String, HashMap<String, List<String>>> stateMap = new HashMap<>();

        boolean flag = true;

        while(flag){

            System.out.println("Enter 1 to enter a state and 0 to exit");
            int k= sc.nextInt();
            sc.nextLine();

            if(k==1){

                System.out.println("Enter state name");
                String st = sc.nextLine();
                System.out.println("Enter district name");
                String dt = sc.nextLine();
                System.out.println("Enter cities name");
                String ct = sc.nextLine();

                HashMap<String, List<String>> districts= stateMap.get(st);
                if(districts==null){
                    districts= new HashMap<>();
                    stateMap.put(st,districts);
                }
                List<String> cities = districts.get(dt);
                if(cities==null) {
                    cities = new ArrayList<>();
                    districts.put(dt, cities);
                }
                cities.add(ct);

            }
            else{
                System.out.println("thank you");
                flag = false;
            }
        }
        System.out.println(stateMap);
    }
}
