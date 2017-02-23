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
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook frame = new SearchBook();
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
	public SearchBook() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1106, 764);
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
		    	  dispose();new SearchBook().setVisible(true);
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
			    	  dispose();new SearchBook().setVisible(true);
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
			      
			      
			      dispose();new SearchBook().setVisible(true);
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
			      
			      dispose();new SearchBook().setVisible(true);
			}
		});
		mnAddNew.add(mntmPublication);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel lblBookid = new JLabel("BookID");
		
		
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0)
			{
				String bid=textField.getText();
				 String query="select * from book where id=?";
				 Connection con=DBInfo1.con;
				 try
				 {
					 PreparedStatement ps=con.prepareStatement(query);
					 ps.setString(1, bid);
	                 ResultSet res=ps.executeQuery();
	                 while(res.next())
	                 {
	                	 textField_1.setText(res.getString(2));
	                	 textField_2.setText(res.getString(3));
	                	 textField_3.setText(res.getString(4));
	                	 textField_4.setText(res.getString(5));
	                	 textField_5.setText(res.getString(6));
	                	 textField_6.setText(res.getString(7));
	                	 textField_7.setText(res.getString(8));
	                	 textField_8.setText(res.getString(9));
	                	 textField_9.setText(res.getString(10));
	                 }
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 }
					
			}
		});
		
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
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String str=(String)comboBox.getSelectedItem();
				textField_2.setText(str);
			}
		});
		comboBox.insertItemAt("Select", 0);
		comboBox.setSelectedIndex(0);
	
		
		JComboBox comboBox_1 = new JComboBox(GetValues.getCategory());
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String str=(String)comboBox_1.getSelectedItem();
				textField_3.setText(str);
			}
		});
		comboBox_1.insertItemAt("Select", 0);
		comboBox_1.setSelectedIndex(0);
		
		JComboBox comboBox_2 = new JComboBox(GetValues.getSubject());
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String str=(String)comboBox_2.getSelectedItem();
				textField_4.setText(str);
			}
		});
		comboBox_2.insertItemAt("Select", 0);
		comboBox_2.setSelectedIndex(0);
		
		
		JComboBox comboBox_3 = new JComboBox(GetValues.getPublication());
		comboBox_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String str=(String)comboBox_3.getSelectedItem();
				textField_5.setText(str);
			}
		});
		comboBox_3.insertItemAt("Select", 0);
		comboBox_3.setSelectedIndex(0);
		
		JButton btnSave = new JButton("SEARCH");
		btnSave.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
			 String bid=textField.getText();
			 String query="select * from book where id=?";
			 Connection con=DBInfo1.con;
			 try
			 {
				 PreparedStatement ps=con.prepareStatement(query);
				 ps.setString(1, bid);
                 ResultSet res=ps.executeQuery();
                 while(res.next())
                 {
                	 textField_1.setText(res.getString(2));
                	 textField_2.setText(res.getString(3));
                	 textField_3.setText(res.getString(4));
                	 textField_4.setText(res.getString(5));
                	 textField_5.setText(res.getString(6));
                	 textField_6.setText(res.getString(7));
                	 textField_7.setText(res.getString(8));
                	 textField_8.setText(res.getString(9));
                	 textField_9.setText(res.getString(10));
                 }
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
				
				
			}
			
			
			
		});
		
		JButton btnReset = new JButton("UPDATE");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField.getText();
				String title=textField_1.getText();
				String author=textField_2.getText();
				String category=textField_3.getText();
				String subject=textField_4.getText();
				String pub=textField_5.getText();
				String isbn=textField_6.getText();
				String edition=textField_7.getText();
				String price=textField_8.getText();
				String quantity=textField_9.getText();
				String query="update book set name=?,author=?,category=?,subject=?,publication=?,isbn=?,edition=?,price=?,quantity=? where id=?";
				Connection con=DBInfo1.con;
				int flag=0;
				try
				{
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, title);
				ps.setString(2, author);
				ps.setString(3, category);
				ps.setString(4, subject);
				ps.setString(5, pub);
				ps.setString(6, isbn);
				ps.setString(7, edition);
				ps.setString(8, price);
				ps.setString(9, quantity);
				ps.setString(10, id);
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
					JOptionPane.showMessageDialog(getParent(), "Book Updated", "Success",JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					textField.setText(_getID());
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_7.setText(null);
					textField_8.setText(null);
					textField_9.setText(null);
					
					comboBox.setSelectedIndex(0);
					comboBox_1.setSelectedIndex(0);
					comboBox_2.setSelectedIndex(0);
					comboBox_3.setSelectedIndex(0);
				}
				if(flag==0)
				{
					JOptionPane.showMessageDialog(getParent(), "Book Not Updated", "Failed!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bid=textField.getText();
				String query="delete from book where id=?";
				try
				{
				  PreparedStatement ps=DBInfo1.con.prepareStatement(query);
				  ps.setString(1, bid);;
				  ps.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(getParent(), "Book deleted", "success!",JOptionPane.INFORMATION_MESSAGE);
				textField.setText(null);
				
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
			}
		});
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
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
						.addComponent(lblPublication)
						.addComponent(lblSubject)
						.addComponent(lblCategory)
						.addComponent(lblAuthor))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
												.addComponent(textField_1))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
												.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
												.addComponent(textField_3)
												.addComponent(textField_2)))
										.addGap(47)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(comboBox_3, 0, 263, Short.MAX_VALUE)
											.addComponent(comboBox_2, 0, 263, Short.MAX_VALUE)
											.addComponent(comboBox_1, 0, 263, Short.MAX_VALUE)
											.addComponent(comboBox, Alignment.TRAILING, 0, 263, Short.MAX_VALUE))
										.addGap(141))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(306)
					.addComponent(lblNewLabel)
					.addContainerGap(699, Short.MAX_VALUE))
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAuthor)
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCategory)
									.addGap(18)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSubject)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPublication)
								.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIsbn)
							.addGap(18)
							.addComponent(lblEdition)
							.addGap(18)
							.addComponent(lblPrice)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblQuantity))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnSave)
						.addComponent(btnDelete))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
