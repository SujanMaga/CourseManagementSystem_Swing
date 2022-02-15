package course_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Student extends JFrame implements ActionListener {
//	This class prompts student to register or login
	private JPanel topPanel;
	private JLabel heading, bg;
	private JButton login, register;

	
	Student(){
		setTitle("Course-Management-System");
		setSize(450,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
//		topPanel for background color at the top
		topPanel = new JPanel();
		topPanel.setBackground(Color.lightGray);
		topPanel.setBounds(0, 0, 436, 42);
		add(topPanel);
		
//		Text in the top Panel at the top
		heading = new JLabel("Would you like to login or register?");
		heading.setBounds(46, 0, 380, 42);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma", Font.BOLD, 22));
		topPanel.add(heading);
		
		
//		Button for login
		login = new JButton("login");
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Monospaced", Font.BOLD, 20));
		login.setBackground(Color.LIGHT_GRAY);
		login.setFocusable(false);
		login.setBounds(23, 90, 143, 42);
		login.addActionListener(this);
		add(login);
		
//		Button for register
		register = new JButton("register");
		register.setForeground(Color.BLACK);
		register.setFont(new Font("Monospaced", Font.BOLD, 18));
		register.setBackground(Color.LIGHT_GRAY);
		register.setFocusable(false);
		register.setBounds(268, 90, 143, 42);
		register.addActionListener(this);
		add(register);
		
		
//		adding background image
		bg = new JLabel("");
		bg.setIcon(new ImageIcon("resources/greyBg.jpg"));
		bg.setBounds(0, 40, 436, 123);
		add(bg);
	}
	public static void main(String[] args) {
		new Student();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			new StudentLogin();
			
		}
		else if(e.getSource()==register) {
			new StudentRegister();
			
			
		}
		
	}

}
