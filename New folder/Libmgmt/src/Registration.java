import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblEnterNam = new JLabel("Enter Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterContactNo = new JLabel("Enter Contact no.");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblEnterEmailAddress = new JLabel("Enter Email address");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblEnterUsername = new JLabel("Enter username");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		
		passwordField = new JPasswordField();
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		
		passwordField_1 = new JPasswordField();
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			   String name=textField.getText();
			   String contact=textField_1.getText();
			   String email=textField_2.getText();
			   String uname=textField_3.getText();
			   String pass=String.copyValueOf(passwordField.getPassword());
			   String repass=String.copyValueOf(passwordField_1.getPassword());
			   System.out.println(name+":"+contact+":"+email+":"+uname+":"+pass+":"+repass);
			   
			   if(name.length()==0 || contact.length()==0 || email.length()==0 || uname.length()==0 || pass.length()==0 || repass.length()==0)
			   {
				 JOptionPane.showMessageDialog(getParent(), "Pls fill all fields","Error",JOptionPane.ERROR_MESSAGE);  
			   }
			   else
			   {
				    if(!pass.equals(repass)) //to check the equality of pass and repass
				    {
				    	JOptionPane.showMessageDialog(getParent(), "password and re password are different","Error",0);
				    }
				    else
				    {
				    	String query="insert into registration values(?,?,?,?)";
				    	Connection con=DBInfo1.con;
				    	int flag=0;
				    	try
				    	{
				    		PreparedStatement ps=con.prepareStatement(query);
				    		ps.setString(1, name);
				    		ps.setString(2, contact);
				    		ps.setString(3, email);
				    		ps.setString(4, uname);
				    		flag=ps.executeUpdate();
				    	}
				    	catch(Exception e)
				    	{
				    		e.printStackTrace();
				    	}
				    	
				    	
				    	String query1="insert into login values(?,?,?)";
				    	Connection con1=DBInfo1.con;
				    	int flag1=0;
				    	try
				    	{
				    		PreparedStatement ps=con.prepareStatement(query1);
				    		ps.setString(1, uname);
				    		ps.setString(2, pass);
				    		ps.setString(3, "student");
				    		
				    		flag1=ps.executeUpdate();
				    	}
				    	catch(Exception e)
				    	{
				    		e.printStackTrace();
				    	}
				    	
				    	if(flag!=0  && flag1!=0)
				    	{
				    		JOptionPane.showMessageDialog(getParent(), "Record inserted");
				    	}
				    	else
				    	{
				    		JOptionPane.showMessageDialog(getParent(), "registration failed","Error",JOptionPane.ERROR_MESSAGE);	
				    	}
				    }
			   }
			   
			}
		});
		
		JButton btnReset = new JButton("RESET");
		
		JButton btnLoginNow = new JButton("Login Now");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(207, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(203))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSave)
							.addGap(27)
							.addComponent(btnReset)
							.addGap(18)
							.addComponent(btnLoginNow)
							.addGap(113))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterNam)
								.addComponent(lblEnterContactNo)
								.addComponent(lblEnterEmailAddress)
								.addComponent(lblEnterUsername)
								.addComponent(lblEnterPassword)
								.addComponent(lblRetypePassword))
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField_1)
								.addComponent(passwordField)
								.addComponent(textField_3)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
							.addGap(61))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterNam)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterContactNo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterEmailAddress)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterUsername)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRetypePassword)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnReset)
						.addComponent(btnLoginNow))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
