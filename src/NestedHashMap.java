import java.util.*;
import java.util.Map;

public class NestedHashMap {
    public static void main(String[] args) {
        addCapitalsStates();
    }
    public static void addCapitalsStates(){
        Map<String, Map<String, Set<String>>> statesMap = new HashMap<>();
        boolean flag = true;
        while (flag){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a state name");
            String st = sc.nextLine();
            System.out.println("Enter a district name");
            String dt = sc.nextLine();
            System.out.println("Enter a city name");
            String ct = sc.nextLine();

            Map<String, Set<String>> distMap = statesMap.get(st);
            if(distMap == null){
                distMap = new HashMap<>();
                statesMap.put(st,distMap);
            }
            Set<String> cities = distMap.get(dt);
            if(cities == null) {
                cities = new HashSet<>();
                distMap.put(dt, cities);
            }
            cities.add(ct);
            System.out.println("press 1 to continue and 0 to exit");
            int i = sc.nextInt();
            if(i == 0)
                flag = false;
        }
       System.out.println(statesMap);
    }

}
