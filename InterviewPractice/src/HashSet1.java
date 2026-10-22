import java.util.*;



public class HashSet1 {

  public static void main(String[]args){

      HashSet<Integer> student = new HashSet<>();
      boolean flag = true;
      Scanner sc = new Scanner(System.in);
      while(flag){
          System.out.println("Press 1 to enter a student id and 0 to exit");
          int k = sc.nextInt();
          sc.nextLine();
          if(k==1) {
              System.out.println("Enter a student id: ");
              int i = sc.nextInt();
              sc.nextLine();
              student.add(i);
          }else{
              flag = false;
          }
      }
      System.out.println(student);

      Iterator<Integer> it = student.iterator();
      while(it.hasNext()){
          Integer id = it.next();
          System.out.println(id);
      }
      System.out.println("Enter a student id you want : ");
      int k = sc.nextInt();
      sc.nextLine();

          if (student.contains(k)) {
              System.out.println("given id is present in set" + k);
          } else {
              System.out.println("given id is not present in set");
          }



  }
}
