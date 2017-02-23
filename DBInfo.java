package p1;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBInfo
{
   public static Connection con;
   static
   {
	 try
	 {
	 
Class.forName("com.mysql.jdbc.Driver");
 con=DriverManager.getConnection("jdbc:mysql://localhost/magazine1","root","rat");
	 }
	 catch(Exception e)
	 {
	   e.printStackTrace();
	 } 
   }
  
   
}