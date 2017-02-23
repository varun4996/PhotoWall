import java.awt.FlowLayout;

import javax.swing.JFrame;

public class StudentSection extends JFrame {

	public StudentSection(String title)
	{
		super(title);
		
		setSize(500,200);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());
	}
	

}
