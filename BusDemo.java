import java.util.*;

class BusDemo {
    public static void main(String[] args) {

        BusDAO busdao=new BusDAO();

        try{
            busdao.displayBusinfo();
            int userin=1 ;
            Scanner sc = new Scanner(System.in);

            while(userin==1){
                System.out.println("Enter 1 to start booking and 2 to start cancelation process and 0 to exit");
                userin = sc.nextInt();
                if(userin == 1){
                    Booking book = new Booking();
                    if(book.isAvailable()){
                        BookingDAO bookingdao=new BookingDAO();
                        bookingdao.addbooking(book);
                        book.confirmation();
                    }
                    else{
                        System.out.println("Sorry. Bus is full.Try Another Bus or Date");
                    }
                }
               /*  else if(userin==2){
                    Booking.deletion();
                }    
                else if(userin==0) break; */
            }
            sc.close();
    }
    catch(Exception e){
        System.out.println( e);
    }
        System.out.println("Thank You");   
    }
}