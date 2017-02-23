import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class Mail extends HttpServlet
{
	public static String from="varunjin222@gmail.com";// provide the sender's email address here
	public static String password="varun@4996";// provide the sender's password here
	

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		 PrintWriter out=res.getWriter();
	 		String to[]=req.getParameterValues("To");
	 		String msg=req.getParameter("Content");
	 		String subject=req.getParameter("Subject");
			System.out.println("to:->"+to);
			int i = 0;
			
			Properties properties = System.getProperties();
			properties.put("mail.smtp.starttls.enable", "true"); 
			properties.put("mail.smtp.host", "smtp.gmail.com");
	     
	     
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.auth", "true");
	  
	  
	  
			Session session = Session.getInstance(properties, new javax.mail.Authenticator()
			{
			protected PasswordAuthentication getPasswordAuthentication()
			{
			return new PasswordAuthentication(from, password);
			} 
			}
			);
      
	  
	  try
	  {
         final MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int j = 0; j < to.length; j++)
            {
                addressTo[j] = new InternetAddress(to[j]);
            }
            message.setRecipients(Message.RecipientType.BCC, addressTo); 
			message.setSubject(subject);  //set subject
        
		
			message.setText(msg);  //set message
		
        
			new Thread(new Runnable()
			{
			public void run() 
			{
				try
				{
					Transport.send(message);
				}
				catch (Exception e){e.printStackTrace();}
			}
			}).start();
		
		
			out.println(" message sent successfully ....will reach in 10 or 15 seconds");
        
			session = null;
			i = 1;
        }
		  catch (MessagingException mex) 
		  {
	         mex.printStackTrace();
			// return i;
	      }
		   //return i;
   }
   
   
  

}