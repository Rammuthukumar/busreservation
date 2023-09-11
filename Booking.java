import java.util.*;
import java.util.Date;
import java.sql.SQLException;
import java.text.*;

public class Booking{
    String passengerName;
    int busNo;
    Date date;
    int booked = 0;

    Scanner in = new Scanner(System.in);

    Booking(){
        System.out.println("Enter Name of the Passenger :");
        passengerName = in.next();
        System.out.println("Enter the Busno : ");
        try{
          busNo = in.nextInt();
        }
        catch(Exception e){
            System.out.println("You entered Bad data");
        }
        
        if(busNo<1 || busNo>3){
           System.out.println("Sorry. Bus isnt Available");
           System.exit(0);
        }
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = in.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try{
            date = dateFormat.parse(dateInput);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
    }

    public boolean isAvailable() throws SQLException{
        BusDAO busdao=new BusDAO();
        BookingDAO bookdao=new BookingDAO();
        int capacity=busdao.getCapacity(busNo);
        int booked=bookdao.getbookedcount(busNo,date);     
        return booked<capacity;
    }

    public void confirmation(){
        System.out.println("Enter OK to confirm or CANCEL to cancel the process ");
        String conf= in.next();
        if(conf.equals("OK"))
            System.out.println("Your Booking is Confirmed");
        else
            System.out.println("Cancled...");
    }

     public static void deletion() throws SQLException{
        Scanner sc=new Scanner(System.in); 
        System.out.println("Enter your booking id ");
        int id=sc.nextInt();
        if(BookingDAO.deletebook(id)){
            System.out.println("Your booking is canceled");
        }
        else System.out.println("Sorry! There is no id in the database");
        sc.close();
    } 

}