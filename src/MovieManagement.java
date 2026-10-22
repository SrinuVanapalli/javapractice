import java.util.*;
import java.util.Map;

class Movies {
    private int id;
    private String name;
    private String hero;
    private float rating;

    public Movies (int id, String name, String hero, float rating){
        this.id = id;
        this.name = name;
        this.hero = hero;
        this.rating = rating;
    }
    public int getId(){return id;}
    public String getName(){return name;}
    public String getHero(){return hero;}
    public float getRating(){return rating;}

    public void setId(int id){ this.id = id;}
    public void setName(String name){this.name = name;}
    public void setHero(String hero){this.hero= hero;}
    public void setRating(float rating){this.rating = rating;}

    @Override
    public String toString(){
        return "\n Movie id :"+ id+
               "\n Movie Name :"+ name+
                "\n Movie Hero :"+ hero+
                "\n Movie Rating :"+ rating;
    }
}

public class MovieManagement{

    public static int readInterger(Scanner sc){
       while(true)
       {
           try{
               int number = sc.nextInt();
               sc.nextLine();
               return number;
           }catch(InputMismatchException e) {
               System.out.println("Enter valid number ");
               sc.nextLine();
           }
       }
    }

    public static void addMovie(Map<Integer, Movies> moviesMap, Scanner sc ){

        System.out.println("Enter a Movie id");
        int id = readInterger(sc);

        if(id<=0){
            System.out.println("Movie id must be positive");
            return;
        }

        System.out.println("Enter movie name");
        String name = sc.nextLine();
        if(moviesMap.containsKey(id)){
            System.out.println("Movie already exists");
        }
        System.out.println("Enter hero name ");
        String hero = sc.nextLine();
        if(name.trim().isEmpty()){
            System.out.println("Movie name is mandatory");
            return;
        }

        System.out.println("Enter rating");
        float rating = sc.nextFloat();
        sc.nextLine();
        if(rating<0 || rating >5){
            System.out.println("Enter the rating within the range of 0 to 5");
        }

    }

}


