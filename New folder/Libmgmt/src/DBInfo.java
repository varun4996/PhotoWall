import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInfo
{
         static
         {
        	//Drivers
     		try
     		{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded");
			} catch (ClassNotFoundException e) 
     		{
				e.printStackTrace();
			}
         }
         
         public static  Connection getConn()
         {
        	//Establish a connection
     		Connection con=null;
     		
     		try 
     		{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libmgmt", "root", "rat");
			} catch (SQLException e) 
     		{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
     		return con;
         }
}















