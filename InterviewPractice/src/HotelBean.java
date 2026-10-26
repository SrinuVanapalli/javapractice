/*create a java hotel bean and put that as a value for the map using hotel id as a key */

import java.util.*;

public class HotelBean{

    static class Hotel {
        private Integer id;
        private String name;
        private String owner;
        private String city;
        private Float rating;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Float getRating() {
            return rating;
        }

        public void setRating(Float rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Hotelid=" + id +
                    "\n name=" + name +
                    "\n owner=" + owner +
                    "\n city=" + city +
                    "\n rating=" + rating ;
        }
    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Map<Integer, Hotel> hotelMap = new HashMap<>();

           try {

               boolean flag = true;

               while(flag) {

                   System.out.println("Enter a hotel id");
                   Integer hotelId = sc.nextInt();
                   sc.nextLine();
                   System.out.println("Enter a hotel name");
                   String hotelName = sc.nextLine();
                   System.out.println("Enter a hotel owner ");
                   String hotelOwner = sc.nextLine();
                   System.out.println("Enter a hotel city ");
                   String hotelCity = sc.nextLine();
                   System.out.println("Enter hotel rating ");
                   Float hotelRating = sc.nextFloat();


                   Hotel hotel = new Hotel();
                   hotel.setId(hotelId);
                   hotel.setName(hotelName);
                   hotel.setCity(hotelCity);
                   hotel.setRating(hotelRating);
                   hotel.setOwner(hotelOwner);
                   hotelMap.put(hotelId, hotel);
                       System.out.println("Enter 1 to add a hotel and 0 to exit");
                       int k = sc.nextInt();
                       if(k==1){
                           flag = true;
                       }else{
                           flag = false;
                       }

               }


           }catch(Exception e){
               e.printStackTrace();
           }


            System.out.println(hotelMap);

        }


}
