package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteCourse extends JFrame implements ActionListener {
	private JLabel heading, cLabel;
	private JButton submit;
	private JTextField courseTextField;
	DeleteCourse(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 250);
		setLayout(null);
		setResizable(false);
		
		heading = new JLabel("Delete Course");
		heading.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 45));
		heading.setBounds(130, 0, 320, 71);
		add(heading);
		
		
		
		cLabel = new JLabel("Enter course ");
		cLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		cLabel.setBounds(20,60, 179, 43);
		add(cLabel);
		
//		input course
		courseTextField = new JTextField();
		courseTextField.setBounds(250, 65, 218, 32);
		courseTextField.setColumns(10);
		add(courseTextField);
		
		submit = new JButton("Delete");
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Monospaced", Font.BOLD, 20));
		submit.setBackground(Color.LIGHT_GRAY);
		submit.setFocusable(false);
		submit.setBounds(200, 125, 110, 30);
		submit.addActionListener(this);
		add(submit);

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DeleteCourse();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submit) {
			try{
				ConDb c5 = new ConDb();
//				delete from subjects where course = BIT/BBIM/MBA;
				String q = "delete from modules where course = ? and id is NULL";
	        	PreparedStatement pst = c5.connection.prepareStatement(q);
	        	pst.setString(1, courseTextField.getText());
	        	
	        	pst.executeUpdate();
	            JOptionPane.showMessageDialog(null,"Deleted Successfully");
	            c5.connection.close();;
	            
	        }
	        catch(Exception ee){
	        	JOptionPane.showMessageDialog(null,"Deletion Unsuccessful");
	        }
		}

		
	}
	

}
