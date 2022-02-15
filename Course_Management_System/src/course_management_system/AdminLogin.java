package course_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class AdminLogin extends JFrame implements ActionListener {
	private JLabel label1,label2, bg;
	private JButton login;
	private JTextField id;
	private JPasswordField password;

	
	AdminLogin(){
		setTitle("Course-Management-System");
		setSize(450,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		
		
		label1 = new JLabel("Id");
		label1.setFont(new Font("Monospaced", Font.BOLD, 23));
		label1.setBounds(24, 10, 67, 42);
		add(label1);
		
		
		label2 = new JLabel("Password");
		label2.setFont(new Font("Monospaced", Font.BOLD, 23));
		label2.setBounds(24, 62, 120, 42);
		add(label2);
		
		id = new JTextField();
		id.setBounds(165, 24, 232, 25);
		add(id);
		id.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(165, 76, 232, 25);
		add(password);
		
		
		
		
		
//		Button for login
		login = new JButton("login");
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Monospaced", Font.BOLD, 20));
		login.setBackground(Color.LIGHT_GRAY);
		login.setFocusable(false);
		login.setBounds(140, 111, 140, 40);
		login.addActionListener(this);
		add(login);
		
		
//		adding background image
		bg = new JLabel("");
		bg.setIcon(new ImageIcon("resources/greyBg.jpg"));
		bg.setBounds(0, 0, 436, 163);
		add(bg);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new AdminLogin();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			try{
//				connection object
	            ConDb c1 = new ConDb();
	            
	            String i = id.getText();
	            String p = password.getText();
	            
//	            checks from admin table in the columns id and pw with the values entered in the textfield
	            String q = "select * from admin where id='"+i+"' and pw='"+p+"'";
	            
	            ResultSet rs = c1.statement.executeQuery(q); 
	            if(rs.next()){
	                new AdminTab();
	                setVisible(false);
//	                closing connection
	                c1.connection.close();
	            }else{
	                JOptionPane.showMessageDialog(null, "Invalid login");
	                setVisible(false);
	            }
	        }catch(Exception e1){
	            System.out.println(e1);
	        }
			
		}
		
	}
	

}
