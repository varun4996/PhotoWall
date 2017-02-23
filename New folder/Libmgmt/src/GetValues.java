import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GetValues 
{
	  public static Vector<String> getAuthor()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from author order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
	  public static Vector<String> getCategory()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from category order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
	  public static Vector<String> getSubject()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from subject order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
	  public static Vector<String> getPublication()
	  {
		  Vector<String> v=new Vector<>();
		  Connection con=DBInfo1.con;
		  String query="select * from publication order by name";
		  try
		  {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
			}
		  }
         catch(Exception e)
		  {
        	 e.printStackTrace();
		  }
		  
		  return v;
	  }
}
