import java.util.*;
import java.util.Map;

     class Books {

         private int id;
         private String name;
         private String author;
         private int price;

         public Books(int id , String name, String Author, int price){
             this.id = id;
             this.name = name;
             this.author = Author;
             this.price = price;
         }
         public int getId(){ return id;}
         public String getName(){ return name;}
         public String getAuthor(){ return author;}
         public int getPrice(){ return price;}

         @Override
         public String toString(){
             return "\n Book id : "+ id +
                                "\n Book name :"+ name+
                                "\n Book Author :"+ author+
                                "\n Book price :"+ price;
         }
     }

    public class BooksData {
         public static void main(String[] args) {

             Map<Integer, List<Books>> booksMap = new HashMap<>();
             Scanner sc = new Scanner(System.in);
             boolean flag = true;
             while (flag) {
                 System.out.println("Enter a book id");

                 int id = sc.nextInt();
                 sc.nextLine();

                 System.out.println("Enter a book name");
                 String name = sc.nextLine();

                 System.out.println("Enter Author name");
                 String Author = sc.nextLine();

                 System.out.println("Enter price");
                 int price = sc.nextInt();

                 Books b = new Books(id, name, Author, price);

                 List<Books> bookdetails = booksMap.get(id);

                 if (bookdetails == null) {
                     bookdetails = new ArrayList<>();
                     booksMap.put(id, bookdetails);
                 }
                 bookdetails.add(b);
                 System.out.println("press 1 to continue and 0 to exit");
                 int i = sc.nextInt();
                 sc.nextLine();
                 if (i == 0) {
                     flag = false;
                 }
             }

             Iterator<Map.Entry<Integer, List<Books>>> mapIterator = booksMap.entrySet().iterator();

             while (mapIterator.hasNext()) {
                 Map.Entry<Integer, List<Books>> entry = mapIterator.next();
                 System.out.println("Book Id : " + entry.getKey());
                 Iterator<Books> booksIterator = entry.getValue().iterator();
                 while (booksIterator.hasNext()) {
                     Books b = booksIterator.next();
                     System.out.println(b);
                 }
             }
             System.out.println("Enter a book id");
             int bid = sc.nextInt();
             sc.nextLine();
             List<Books> list = booksMap.get(bid);

             Iterator<Books> itr = list.iterator();

             while(itr.hasNext()){
                 System.out.println(itr.next());
             }

         }
     }

