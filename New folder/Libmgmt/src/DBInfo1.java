import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBInfo1
{
	 static Connection con;
         static
         {
        	//Drivers
     		try
     		{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libmgmt", "root", "rat");
			}
     		catch (ClassNotFoundException | SQLException e) 
     		{
				e.printStackTrace();
			}
         }
}















