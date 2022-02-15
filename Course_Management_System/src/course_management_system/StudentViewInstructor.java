package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;



public class StudentViewInstructor extends JFrame {
//	Instructor detail when instructor is viewed by the student
	private JLabel heading;
	private JTextArea detail;
	
	StudentViewInstructor(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setLayout(null);
		

		heading = new JLabel("Instructor Detail");
		heading.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		heading.setBackground(Color.BLACK);
		heading.setBounds(157, 10, 170, 72);
		add(heading);
		
		detail = new JTextArea();
		detail.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 26));
		detail.setBounds(20, 92, 441, 308);
		add(detail);
		
		detailIns(StudentLogin.unique);
		setVisible(true);
	}
	
	
public void detailIns(String s) {
	
	try{
		ConDb c = new ConDb();
		ResultSet rs = c.statement.executeQuery("select * from student where id="+StudentLogin.unique);
//		storing the section of a student in a variable section
		String section ="";
		if(rs.next()){
            section += rs.getString(10);
        }

		ResultSet rs1 = c.statement.executeQuery("select * from instructor");
		while(rs1.next()){
//			checking if the section taught by the instructor matches the section of a logged in student or not
            if(rs1.getString(9).equals(section)|| rs1.getString(10).equals(section)|| rs1.getString(11).equals(section)|| rs1.getString(12).equals(section)|| rs1.getString(13).equals(section)|| rs1.getString(14).equals(section) ) {
//            	adding the name of instructor to the textArea if the section matches
            	detail.append(rs1.getString("name"));
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

