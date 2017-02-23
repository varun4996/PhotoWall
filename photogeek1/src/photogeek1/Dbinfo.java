package photogeek1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbinfo 
{
   static Connection con;
   static
   {
	   try
	   {
		   Class.forName("com.mysql.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","rat");
	   }
	   catch(ClassNotFoundException|SQLException e)
	   {
		   e.printStackTrace();
	   }
   }
}
