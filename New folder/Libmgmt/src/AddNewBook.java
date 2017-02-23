import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class AddNewBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewBook frame = new AddNewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String _getID()
	{
		String bid="";
		for(int i=0;i<7;i++)
		{
			bid+=(int)(Math.random()*9)+1; 
			System.out.println(bid);
		}
		return bid;
	}
	public AddNewBook() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 764);
		setLocationRelativeTo(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAddNew = new JMenu("Add New");
		menuBar.add(mnAddNew);
		
		JMenuItem mntmAuthor = new JMenuItem("Author");
		mntmAuthor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
		      String str=arg0.getActionCommand();
		      System.out.println(str);
		      String value=JOptionPane.showInputDialog(getParent(), "Enter "+str+" Name");
		      System.out.println(value);
		      Connection con=DBInfo1.con;
		      int flag=0;
		      String query="insert into "+str+"(name) values(?)";
		      try
		      {
		    	 PreparedStatement ps=con.prepareStatement(query);
		    	 ps.setString(1, value.toUpperCase());
		    	 flag=ps.executeUpdate();
		      }
		      catch(Exception e)
		      {
		    	  e.printStackTrace();
		      }
		      if(flag==1)
		      {
		    	  JOptionPane.showMessageDialog(getParent(),str+" added successfully!");
		    	  dispose();new AddNewBook().setVisible(true);
		      }
		      if(flag==0)
		    	  JOptionPane.showMessageDialog(getParent(),"Value not inserted !");
			}
		});
		mnAddNew.add(mntmAuthor);
		
		JMenuItem mntmCategory = new JMenuItem("Category");
		mntmCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=arg0.getActionCommand();
			      System.out.println(str);
			      String value=JOptionPane.showInputDialog(getParent(), "Enter "+str+" Name");
			      System.out.println(value);
			      Connection con=DBInfo1.con;
			      int flag=0;
			      String query="insert into "+str+"(name) values(?)";
			      try
			      {
			    	 PreparedStatement ps=con.prepareStatement(query);
			    	 ps.setString(1, value.toUpperCase());
			    	 flag=ps.executeUpdate();
			      }
			      catch(Exception e)
			      {
			    	  e.printStackTrace();
			      }
			      if(flag==1)
			      {
			    	  JOptionPane.showMessageDialog(getParent(),str+" added successfully!");
			    	  dispose();new AddNewBook().setVisible(true);
			      }
			      if(flag==0)
			    	  JOptionPane.showMessageDialog(getParent(),"Value not inserted !");
			}
		});
		mnAddNew.add(mntmCategory);
		
		JMenuItem mntmSubject = new JMenuItem("Subject");
		mntmSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=arg0.getActionCommand();
			      System.out.println(str);
			      String value=JOptionPane.showInputDialog(getParent(), "Enter "+str+" Name");
			      System.out.println(value);
			      Connection con=DBInfo1.con;
			      int flag=0;
			      String query="insert into "+str+"(name) values(?)";
			      try
			      {
			    	 PreparedStatement ps=con.prepareStatement(query);
			    	 ps.setString(1, value.toUpperCase());
			    	 flag=ps.executeUpdate();
			      }
			      catch(Exception e)
			      {
			    	  e.printStackTrace();
			      }
			      if(flag==1)
			    	  JOptionPane.showMessageDialog(getParent(),str+" added successfully!");
			      if(flag==0)
			    	  JOptionPane.showMessageDialog(getParent(),"Value not inserted !");
			      
			      
			      dispose();new AddNewBook().setVisible(true);
			}
		});
		mnAddNew.add(mntmSubject);
		
		JMenuItem mntmPublication = new JMenuItem("Publication");
		mntmPublication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  String str=arg0.getActionCommand();
			      System.out.println(str);
			      
			      String value=JOptionPane.showInputDialog(getParent(), "Enter "+str+" Name");
			      System.out.println(value);
			      
			      Connection con=DBInfo1.con;
			      int flag=0;
			      String query="insert into "+str+"(name) values(?)";
			      try
			      {
			    	 PreparedStatement ps=con.prepareStatement(query);
			    	 ps.setString(1, value.toUpperCase());
			    	 flag=ps.executeUpdate();
			      }
			      catch(Exception e)
			      {
			    	  e.printStackTrace();
			      }
			      if(flag==1)
			    	  JOptionPane.showMessageDialog(getParent(),str+" added successfully!");
			      if(flag==0)
			    	  JOptionPane.showMessageDialog(getParent(),"Value not inserted !");
			      
			      dispose();new AddNewBook().setVisible(true);
			}
		});
		mnAddNew.add(mntmPublication);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblBookid = new JLabel("BookID");
		
		
		
		textField = new JTextField(_getID());
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		
		JLabel lblCategory = new JLabel("Category");
		
		JLabel lblSubject = new JLabel("Subject");
		
		JLabel lblPublication = new JLabel("Publication");
		
		JLabel lblIsbn = new JLabel("ISBN");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblEdition = new JLabel("Edition");
		
		JLabel lblPrice = new JLabel("Price");
		
		JLabel lblQuantity = new JLabel("Quantity");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox(GetValues.getAuthor());
		comboBox.insertItemAt("Select", 0);
		comboBox.setSelectedIndex(0);
	
		
		JComboBox comboBox_1 = new JComboBox(GetValues.getCategory());
		comboBox_1.insertItemAt("Select", 0);
		comboBox_1.setSelectedIndex(0);
		
		JComboBox comboBox_2 = new JComboBox(GetValues.getSubject());
		comboBox_2.insertItemAt("Select", 0);
		comboBox_2.setSelectedIndex(0);
		
		
		JComboBox comboBox_3 = new JComboBox(GetValues.getPublication());
		comboBox_3.insertItemAt("Select", 0);
		comboBox_3.setSelectedIndex(0);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String id=textField.getText();
				String title=textField_1.getText();
				String author=(String)comboBox.getSelectedItem();
				String category=(String)comboBox_1.getSelectedItem();
				String subject=(String)comboBox_2.getSelectedItem();
				String pub=(String)comboBox_3.getSelectedItem();
				String isbn=textField_2.getText();
				String edition=textField_3.getText();
				String price=textField_4.getText();
				String quantity=textField_5.getText();
				String query="insert into book values(?,?,?,?,?,?,?,?,?,?)";
				Connection con=DBInfo1.con;
				int flag=0;
				try
				{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, id);
				ps.setString(2, title);
				ps.setString(3, author);
				ps.setString(4, category);
				ps.setString(5, subject);
				ps.setString(6, pub);
				ps.setString(7, isbn);
				ps.setString(8, edition);
				ps.setString(9, price);
				ps.setString(10, quantity);
				flag=ps.executeUpdate();
				con.close();
				DBInfo1.con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(flag==1)
				{
					JOptionPane.showMessageDialog(getParent(), "Book Added", "Success",JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					textField.setText(_getID());
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Book Not Added", "Failed!",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			
		});
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField.setText(_getID());
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(306)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(183)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookid)
								.addComponent(lblTitle)
								.addComponent(lblIsbn)
								.addComponent(lblEdition)
								.addComponent(lblPrice)
								.addComponent(lblQuantity)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAuthor)
								.addComponent(lblCategory)
								.addComponent(lblSubject)
								.addComponent(lblPublication))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
									.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
									.addComponent(textField_3)
									.addComponent(textField_2)
									.addComponent(textField_1)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
									.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubject)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublication)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIsbn)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEdition)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnSave))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
