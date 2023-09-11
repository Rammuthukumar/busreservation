import java.util.Date;
import java.sql.*;

public class BookingDAO {
    public int getbookedcount(int busNo,Date date) throws SQLException{
        String query="select count(pass_name) from booking where busNo=? and travel_date=?";
        Connection con=DBConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setInt(1,busNo);
        pst.setDate(2, sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();

        return rs.getInt(1);

    }

    public void addbooking(Booking book) {
        try{
            String query="insert into booking (pass_name,busNo,travel_date) values(?,?,?)";
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, book.passengerName);
            pst.setInt(2,book.busNo);
            java.sql.Date sqldate=new java.sql.Date(book.date.getTime());
            pst.setDate(3, sqldate);
            pst.executeUpdate();
        }    
        catch(SQLException e){
            System.out.println("Date shouldn't be past");
        }
    }
    public static boolean deletebook(int id) throws SQLException{
        String query="Delete from booking where id="+id;
        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        int row=st.executeUpdate(query);
        if(row==1)
           return true;
        return false;
    }  
}

    



