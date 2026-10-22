import java.util.*;


public class CharacterFrequency1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string ");
        String str = sc.nextLine();

        Map<Character,Integer> freq = new HashMap<>();
        for(int i = 0 ; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(freq.get(ch)==null){
                freq.put(ch,1);
            }else{
                freq.put(ch,freq.get(ch)+1);
            }

        }
        System.out.println(freq);

        for(Map.Entry<Character,Integer> entry: freq.entrySet()){

            System.out.println(entry.getKey() +" -> "+ entry.getValue() );

        }

    }
}
