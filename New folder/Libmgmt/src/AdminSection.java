import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSection extends JFrame {

	public AdminSection(String title)
	{
		super(title);
		System.out.println("Admin page called");
		setSize(724,423);
		setLocationRelativeTo(this);
		getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btnAddNewBook = new JButton("Add New Book");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AddNewBook().setVisible(true);
			}
		});
		getContentPane().add(btnAddNewBook);
		
		JButton btnUpdatedeleteBook = new JButton("Update/Delete Book");
		btnUpdatedeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBook obj=new SearchBook();
				obj.setVisible(true);
			}
		});
		getContentPane().add(btnUpdatedeleteBook);
		
		JButton btnSearchbook = new JButton("SearchBook");
		btnSearchbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBook obj=new SearchBook();
				obj.setVisible(true);
			}
		});
		getContentPane().add(btnSearchbook);
		
		JButton btnAddNewUser = new JButton("Add New User");
		getContentPane().add(btnAddNewUser);
		
		JButton btnChangeSelfPassword = new JButton("Change self password");
		getContentPane().add(btnChangeSelfPassword);
		
		JButton btnIssuebook = new JButton("IssueBook");
		getContentPane().add(btnIssuebook);
		
		JButton btnSubmitBook = new JButton("Submit Book");
		getContentPane().add(btnSubmitBook);
		
		JButton btnAddNewNotice = new JButton("Add New Notice");
		getContentPane().add(btnAddNewNotice);
		
		JButton btnUpdatedeletenotice = new JButton("Update/DeleteNotice");
		getContentPane().add(btnUpdatedeletenotice);
	}
	

}
