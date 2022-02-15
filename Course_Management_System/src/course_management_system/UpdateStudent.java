package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



public class UpdateStudent extends JFrame implements ActionListener {
//	class assisting to update student detail from admin frame
//	Now the section can be updated of the student which was by default "A" when registered
	JLabel heading, bgg, label, label1, label2, label3, label4, label5, label6,label7,label8;
	JTextField idTextField;
	JTextField name;
	JTextField address;
	JTextField neb_marks;
	JTextField phone;
	JTextField email;
	JTextField section;
	JComboBox courseCombo;
	JDateChooser dob;
	JButton upd, submit, cancel;
	
	
	UpdateStudent(){
		setTitle("Course-Management-System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLayout(null);
		setResizable(false);

		
		heading = new JLabel("Update Student");
		heading.setForeground(Color.ORANGE);
		heading.setBackground(Color.WHITE);
		heading.setFont(new Font("Juice ITC", Font.BOLD, 77));
		heading.setBounds(250, 0, 662, 87);
		add(heading);
		
		label = new JLabel("Enter id number to update ");
        label.setBounds(50,100,500,30);
        label.setFont(new Font("Lucida Bright", Font.BOLD, 30));
		label.setForeground(Color.ORANGE);
        add(label);
        
        
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
		
		label8 = new JLabel("Section");
		label8.setForeground(Color.ORANGE);
		label8.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label8.setBounds(473, 423, 159, 56);
		add(label8);
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		idTextField.setBounds(500,100,190,37);
		add(idTextField);
		
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
		
		section = new JTextField();
		section.setColumns(10);
		section.setBounds(610,430, 255, 37);
		add(section);
		
		
		String course[]={"BIT","BBIM","MBA"}; 
		courseCombo = new JComboBox(course);
		courseCombo.setBounds(191, 430, 261, 37);
		add(courseCombo);
		
//		needs external jar file
		dob = new JDateChooser();
		dob.setBounds(598, 338, 261, 39);
		add(dob);
		
		upd = new JButton("update");
		upd.setForeground(Color.BLACK);
		upd.setFont(new Font("Monospaced", Font.BOLD, 20));
		upd.setBackground(Color.LIGHT_GRAY);
		upd.setFocusable(false);
		upd.setBounds(720,100,143,42);
		upd.addActionListener(this);
		add(upd);
		

		
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
		new UpdateStudent();
	}
	
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource() == submit){
            try{
            	ConDb c2 = new ConDb();
        		
        		String a = name.getText();
        		String b = address.getText();
        		String c = neb_marks.getText();
        		String d = (String)courseCombo.getSelectedItem();
        		String g = phone.getText();
        		String f = email.getText();
        		String i = idTextField.getText();
        		String j = section.getText();

        		
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        		String h = sdf.format(dob.getDate());
                
//        		update query
            	String q = "update student set name = ?, address = ?, gpa_neb = ?,course = ?, phone = ?, email = ?, dob = ?,section =? where id = ?";
            	PreparedStatement pst = c2.connection.prepareStatement(q);
            	
//            	specifying the parameter in the query (student)
            	pst.setString(1, a);
            	pst.setString(2, b);
            	pst.setString(3, c);
            	pst.setString(4, d);
            	pst.setString(5, f);
            	pst.setString(6, g);
            	pst.setString(7, h);
            	pst.setString(8, j);
            	pst.setString(9, i);
            	
            	
            
            	pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
                setVisible(false);
            }
            catch(Exception ee){
            	JOptionPane.showMessageDialog(null,"Please Enter all the value");
                System.out.println("The error is:"+ee);
            }
        }
		if(e.getSource() == cancel){
            System.exit(0);
            
        }
		
		if(e.getSource() == upd){
            try{
                ConDb c2 = new ConDb();
//              getting detail of student of given id to view in the respective idTextField
                String str = "select * from student where id = '"+idTextField.getText()+"'";
                ResultSet rs = c2.statement.executeQuery(str);

//              To set the value of courseCombo from the table 
                if(rs.next()){
 	
                	String z = rs.getString(6);
                	int res = 0;
                	
                	if(z.equals("BIT")) {
                		res = 0;
                	}
                	else if(z.equals("BBIM")) {
                		res = 1;
                		
                	}
                	else if(z.equals("MBA")) {
                		res = 2;
                	}
                	
                	
//                	String x = sdf.format(dob.getDate());
                	Date x = rs.getDate(9);
            		
                	dob.setDate(x);
                    name.setText(rs.getString(3));
                    address.setText(rs.getString(4));
                    neb_marks.setText(rs.getString(5));
                    phone.setText(rs.getString(7));
                    email.setText(rs.getString(8));
                    section.setText(rs.getString(10));
                    courseCombo.setSelectedIndex(res);
                    
                    
                }

                
            }catch(Exception eee){
//            	System.out.println(eee);
            	JOptionPane.showMessageDialog(null,"no records");
            }
		
		
	}
	
	
	}
	}
