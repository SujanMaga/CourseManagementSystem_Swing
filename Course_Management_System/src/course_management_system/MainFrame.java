package course_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {
//	This class is the main window that prompt user to select the mode i.e. Student, Instructor and Admin
	private JLabel mode;
	private JPanel topPanel;
	private ImageIcon std, ins, adm;
	private JButton student, instructor, admin;
	
	MainFrame(){
		setTitle("Course-Management-System");
		setSize(450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		
//		top Panel for background color at the top
		topPanel = new JPanel();
		topPanel.setBackground(Color.GRAY);
		topPanel.setBounds(0, 0, 435, 40);
		add(topPanel);
		
		
//		Text in the top Panel at the top
		mode = new JLabel("Select the mode");
		mode.setForeground(Color.WHITE);
		mode.setFont(new Font("Tahoma", Font.BOLD, 27));
		topPanel.add(mode);
		
		
//		icons for the Button 
		std = new ImageIcon(((new ImageIcon("resources/student.png")).getImage()).getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		ins = new ImageIcon(((new ImageIcon("resources/instructor.png")).getImage()).getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		adm = new ImageIcon(((new ImageIcon("resources/admin.png")).getImage()).getScaledInstance(30, 30, Image.SCALE_DEFAULT));

		
		
		//Button for student
		student = new JButton("Student",std);
		student.setForeground(Color.BLACK);
		student.setFont(new Font("Monospaced", Font.BOLD, 18));
		student.setBackground(Color.LIGHT_GRAY);
		student.setFocusable(false);
		student.setBounds(20, 105, 190, 45);
		student.addActionListener(this);
		add(student);
		
		
		
//		Button for instructor
		instructor = new JButton("Instructor",ins);
		instructor.setForeground(Color.BLACK);
		instructor.setFont(new Font("Monospaced", Font.BOLD, 18));
		instructor.setBackground(Color.LIGHT_GRAY);
		instructor.setFocusable(false);
		instructor.setBounds(240, 105,190, 45);
		instructor.addActionListener(this);
		add(instructor);
		
		
//		Button for admin
		admin = new JButton("Admin",adm);
		admin.setForeground(Color.BLACK);
		admin.setFont(new Font("Monospaced", Font.BOLD, 18));
		admin.setBackground(Color.LIGHT_GRAY);
		admin.setFocusable(false);
		admin.setBounds(130, 175, 190, 45);
		
		admin.addActionListener(this);
		add(admin);
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new MainFrame();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==student) {
			new Student();
			dispose();
			
		}
		else if(e.getSource()==instructor) {
			new InstructorLogin();
			dispose();
			
		}
		else if(e.getSource()==admin) {
			new AdminLogin();
			dispose();
		}
		
	}
	
}
