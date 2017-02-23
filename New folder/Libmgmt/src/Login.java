import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2,b3;
	public Login(String title)
	{
		super(title);
		setSize(500,200);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
		l1=new JLabel("Enter username");
		l2=new JLabel("Enter password");
		t1=new JTextField(10);
		p1=new JPasswordField(10);
		b1=new JButton("Login Now");
		b2=new JButton("RESET");
		b3=new JButton("Sign Up");
		add(l1);add(t1);
		add(l2);add(p1);
		add(b1);add(b2);add(b3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
	   if(ae.getSource()==b1)
	   {
		   String s1=t1.getText();
		   char ch[]=p1.getPassword();
		   String s2=String.copyValueOf(ch);
		   
		   Connection con=DBInfo1.con;
		   String query="select * from login where username=? and password =?";
		   int flag=0;
		   String usertype="";
		   try
		   {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, s1);
			ps.setString(2, s2);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				flag=1;
				usertype=res.getString(3);
				break;
			}
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   
		   if(flag==1 && usertype.equalsIgnoreCase("admin"))
		   {
			   AdminSection obj=new AdminSection("Admin section");
			   obj.setVisible(true);
			   dispose();
		   }
		   
		   if(flag==1 && usertype.equalsIgnoreCase("student"))
		   {
			   StudentSection obj=new StudentSection("Student section");
			   obj.setVisible(true);
			   dispose();
		   }
		   if(flag==1 && usertype.equalsIgnoreCase("faculty"))
		   {
			   FacultySection obj=new FacultySection("Faculty section");
			   obj.setVisible(true);
			   dispose();
		   }
		   if(flag==0)
		   {
			   JOptionPane.showMessageDialog(this, "Wrong username or password!", "Error", JOptionPane.ERROR_MESSAGE);
			  t1.setText(null);
			  p1.setText(null);
		   }
		   
		   
		   
	   }
	   if(ae.getSource()==b2)
	   {
		   
	   }
	   if(ae.getSource()==b3)
	   {
		   
	   }
	}
	public static void main(String[] args) 
	{
	   Login obj=new Login("Login page");
	   obj.setVisible(true);

	}

}
