import java.util.*;
import java.util.Map;

class Student{

     private int Id;
     private String name;
     private String course;
     private int marks;

         public Student(int Id, String name, String course, int marks) {
             this.Id = Id;
             this.name = name;
             this.course = course;
             this.marks = marks;
         }
        public int getId() { return Id;}
        public String getName(){ return name;}
        public String getCourse(){ return course;}
        public int getMarks(){ return marks;}

        public void setId(int Id){ this.Id = Id;}
        public void setname(String name){ this.name = name;}
        public void setcourse(String course){ this.course = course;}
        public void setmarks(int marks){ this.marks= marks;}

        @Override
        public String toString(){
         return"\n Student id: "+ Id+
                 "\n Student name : "+ name+
                 "\n Student course :"+ course+
                 "\n Student marks :"+ marks;
         }
}
     public class StudentData{
          public static void main(String[]args){
              Scanner sc = new Scanner(System.in);
              Map<Integer, Student> StudentMap = new HashMap<>();

              boolean flag = true;

              while(flag){

                  System.out.println("============ Student Management System ===========");

                  System.out.println("Add a Student: 1");
                  System.out.println("Display a Students: 2");
                  System.out.println("Remove a Student: 3");
                  System.out.println("Update a Student id: 4");
                  System.out.println("Search a Student: 5");
                  System.out.println("Exit: 6");

                  System.out.println("Enter your choice : ");

                  int i = sc.nextInt();

                  switch(i){

                      case 1:
                          System.out.println("Enter student id");
                          int Id = sc.nextInt();
                          sc.nextLine();
                          System.out.println("Enter student name");
                          String name = sc.nextLine();
                          System.out.println("Enter student course");
                          String course = sc.nextLine();
                          System.out.println("Enter student marks");
                          int marks = sc.nextInt();
                          sc.nextLine();

                          Student student = new Student(Id, name, course, marks);

                          StudentMap.put(Id, student);

                          System.out.println("Student added successfully");
                          break;

                      case 2:

                          if(StudentMap.isEmpty()){
                              System.out.println("No Student is Available");
                              break;
                          }
                          Iterator<Map.Entry<Integer,Student>> mapIterator = StudentMap.entrySet().iterator();

                          while(mapIterator.hasNext()){
                              Map.Entry<Integer,Student> entry = mapIterator.next();
                              System.out.print("\n Student ID key: "+ entry.getKey());
                              System.out.println(entry.getValue());
                          }
                          break;

                      case 3:
                          System.out.println("Enter a student id: ");
                          int del = sc.nextInt();
                          sc.nextLine();

                          if(StudentMap.containsKey(del)){
                              StudentMap.remove(del);
                              System.out.println("Student Deleted successfully");
                          }else{
                              System.out.println("Student not found");
                          }
                          break;

                      case 4:
                          System.out.println("Enter Student id :");
                          int upd = sc.nextInt();
                          sc.nextLine();
                          if(StudentMap.containsKey(upd)) {
                              System.out.println("Enter new id");
                              int newid = sc.nextInt();
                              sc.nextLine();

                              Student s = StudentMap.get(upd);
                              s.setId(newid);

                              System.out.println("Student Id Updated Successfully");
                          }else {
                              System.out.println("Id not found ");
                          }
                          break;

                      case 5:
                          System.out.println("Enter Student Id:");
                          int srid = sc.nextInt();
                          sc.nextLine();
                          if(StudentMap.containsKey(srid)) {
                              System.out.println(StudentMap.get(srid));
                          }else {
                              System.out.println("Student not found");
                          }
                          break;
                      case 6:
                          flag = false;
                          System.out.println("Thank you");
                          break;
                      default:
                          System.out.println("Invalid choice");


                  }
              }


            sc.close();

              }

          }


