import java.util.*;

class Private{
    private int id;
    private String name;
    private String fathername;

    public Private(int id,String name,String fathername){
        this.id = id;
        this.name = name;
        this.fathername= fathername;
    }
    public int getId(){ return this.id ;}
    public String getName(){ return this.name;}
    public String getFathername(){ return this.fathername ;}

    public void setInt(int id){  this.id = id ;}
    public void setName(String name){ this.name = name ;}
    public void setFathername(String fathername){ this.fathername = fathername;}

    @Override
    public String toString(){
        return " Id : "+ id+ "\n Name : "+ name + "\n Fathername : "+ fathername;
    }
}

public class UsingPrivate1{

    public static void main(String[] args){


       Scanner sc = new Scanner(System.in);
        System.out.println("Enter id :");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter name :");
        String name = sc.nextLine();
        System.out.println("Enter fathername : ");
        String fathername = sc.nextLine();

        Private pri = new Private(id, name, fathername);




    }
}

