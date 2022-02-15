package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.*; 


import com.toedter.calendar.JDateChooser;



public class StudentRegister extends JFrame implements ActionListener {
//	adding students record to student table
	JLabel heading, bgg, label1, label2, label3, label4, label5, label6,label7;
	private JTextField name;
	private JTextField address;
	private JTextField neb_marks;
	private JTextField phone;
	private JTextField email;
	private JComboBox courseCombo;
	JDateChooser dob;
	JButton submit, cancel;
	
	
	StudentRegister(){
		setTitle("Course-Management-System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLayout(null);
		setResizable(false);

		
		
		heading = new JLabel("Student Registration Form");
		heading.setForeground(Color.ORANGE);
		heading.setBackground(Color.WHITE);
		heading.setFont(new Font("Juice ITC", Font.BOLD, 77));
		heading.setBounds(129, 0, 662, 87);
		add(heading);
		
		label1 = new JLabel("Name");
		label1.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label1.setForeground(Color.ORANGE);
		label1.setBounds(10, 168, 159, 56);
		add(label1);
		
		label2 = new JLabel("Address");
		label2.setForeground(Color.ORANGE);
		label2.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label2.setBounds(10, 253, 159, 56);
		add(label2);
		
		label3 = new JLabel("+2 GPA");
		label3.setForeground(Color.ORANGE);
		label3.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label3.setBounds(10, 338, 159, 56);
		add(label3);
		
		label4 = new JLabel("Course");
		label4.setForeground(Color.ORANGE);
		label4.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label4.setBounds(10, 423, 159, 56);
		add(label4);
		
		label5 = new JLabel("Phone");
		label5.setForeground(Color.ORANGE);
		label5.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label5.setBounds(473, 168, 122, 56);
		add(label5);
		
		label6 = new JLabel("Email");
		label6.setForeground(Color.ORANGE);
		label6.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label6.setBounds(473, 253, 114, 56);
		add(label6);
		
		label7 = new JLabel("DOB");
		label7.setForeground(Color.ORANGE);
		label7.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label7.setBounds(473, 338, 114, 56);
		add(label7);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(191, 182, 261, 37);
		add(name);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(191, 261, 261, 37);
		add(address);

		
		neb_marks = new JTextField();
		neb_marks.setColumns(10);
		neb_marks.setBounds(191, 340, 261, 37);
		add(neb_marks);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(598, 182, 261, 37);
		add(phone);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(598, 261, 261, 37);
		add(email);
		
		
		String course[]={"BIT","BBIM","MBA"}; 
		courseCombo = new JComboBox(course);
		courseCombo.setBounds(191, 430, 261, 37);
		add(courseCombo);
		
//		requires external jar file
		dob = new JDateChooser();
		dob.setBounds(598, 338, 261, 39);
		add(dob);
		

		
		submit = new JButton("submit");
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Monospaced", Font.BOLD, 20));
		submit.setBackground(Color.LIGHT_GRAY);
		submit.setFocusable(false);
		submit.setBounds(156, 532, 143, 42);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("cancel");
		cancel.setForeground(Color.BLACK);
		cancel.setFont(new Font("Monospaced", Font.BOLD, 20));
		cancel.setBackground(Color.LIGHT_GRAY);
		cancel.setFocusable(false);
		cancel.setBounds(528, 532, 143, 42);
		cancel.addActionListener(this);
		add(cancel);
		

		
		bgg = new JLabel("");
		bgg.setIcon(new ImageIcon("resources/bgg.jpg"));
		bgg.setBounds(0, 0, 886, 663);
		add(bgg);
		
	
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new StudentRegister();
	}
	
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource() == submit){
            try{
            	ConDb c2 = new ConDb();
//            	Randomly generated 8 digits password is assigned with unique id that can taken from the admin if registered and can log in to Student Window
            	GenerateRandomPw gp = new GenerateRandomPw();
            	String RPassword = gp.generatePw();
        		
        		String a = name.getText();
        		String b = address.getText();
        		String c = neb_marks.getText();
        		String d = (String)courseCombo.getSelectedItem();
        		String f = phone.getText();
        		String g = email.getText();


        		
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        		String h = sdf.format(dob.getDate());
                
            	String q = "insert into student(name,pw, address, gpa_neb, course, phone, email, dob, section) values (?,?,?,?,?,?,?,?,?)";
//            	specifying the parameter in the query (marks)
            	PreparedStatement pst = c2.connection.prepareStatement(q);
            	
            	pst.setString(1, a);
            	pst.setString(2, RPassword);
            	pst.setString(3, b);
            	pst.setString(4, c);
            	pst.setString(5, d);
            	pst.setString(6, f);
            	pst.setString(7, g);
            	pst.setString(8, h);
//            	By default while registering section becomes A which is changed by the administrator
            	pst.setString(9, "A");
            	
            
            	pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                setVisible(false);
                c2.connection.close();
            }
            catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }
		else if(e.getSource() == cancel){
            System.exit(0);
            
        }
		
		
	}
	
	
}
