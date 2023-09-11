import java.sql.*;

public class BusDAO {
    public void displayBusinfo() throws SQLException{
        String query="select * from bus";

        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);

        while (rs.next()) {
            System.out.print("Bus No: "+rs.getInt(1));
            if(rs.getBoolean(2)==true)
                System.out.print(" AC: Yes");
            else
                System.out.print(" AC: No");
            System.out.print(" Capacity: "+rs.getInt(3));
            System.out.println();
        }
    }

    public int getCapacity(int id) throws SQLException{
        String query="select capacity from bus where id="+id;

        Connection con=DBConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        
        return rs.getInt(1);

    }
}
