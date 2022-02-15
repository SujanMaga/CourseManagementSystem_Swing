package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class InstructorViewSection extends JFrame {
//	This class is used to see the teaching section/s by the instructor
	private JLabel heading;
	private JTextArea detail;

	InstructorViewSection(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 500, 500);
		setLayout(null);


		heading = new JLabel("Teaching Section");
		heading.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		heading.setBackground(Color.BLACK);
		heading.setBounds(157, 10, 170, 72);
		add(heading);

		detail = new JTextArea();
		detail.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		detail.setBounds(20, 92, 441, 308);
		add(detail);

		detailSec(StudentLogin.unique);
		setVisible(true);
	}
	public static void main(String[] args) {
		new InstructorViewSection();
	}


	public void detailSec(String s) {

		try{
			ConDb c = new ConDb();
//			unique is the variable that stores the id of logged in instructor
			ResultSet rs = c.statement.executeQuery("select * from instructor where id="+InstructorLogin.unique);
			
//			Adds the Section if they are selected in the checkbox while registering for the instructor by the admin
			if(rs.next()){
				if(rs.getString("section1").equals("A")) {
					detail.append("A");
					detail.append("\n");
				}
				if(rs.getString("section2").equals("B")) {
					detail.append("B");
					detail.append("\n");
				}
				if(rs.getString("section3").equals("C")) {
					detail.append("C");
					detail.append("\n");
				}
				if(rs.getString("section4").equals("D")) {
					detail.append("D");
					detail.append("\n");
				}
				if(rs.getString("section5").equals("E")) {
					detail.append("E");
					detail.append("\n");
				}
				if(rs.getString("section6").equals("F")) {
					detail.append("F");
					detail.append("\n");
				}
			}
			detail.setEditable(false);

		}
		catch(Exception e){
			e.printStackTrace();
		}


	}
}

