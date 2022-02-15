package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.*; 


import com.toedter.calendar.JDateChooser;



public class UpdateInstructor extends JFrame implements ActionListener {
//	class assisting to update instructor from admin frame
	
	private JLabel heading, bgg, label, label1, label2, label3, label4, label5, label6,label7;
	private JTextField idTextField;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JTextField email;
	private JCheckBox sec1, sec2, sec3, sec4, sec5, sec6;
	private JComboBox courseCombo;
	private JDateChooser dob;
	private JButton submit, cancel,upd;
	
	
	UpdateInstructor(){
		setTitle("Course-Management-System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLayout(null);
		setResizable(false);

		
		heading = new JLabel("Update Instructor");
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
		
		label3 = new JLabel("Teaching Sec.");
		label3.setForeground(Color.ORANGE);
		label3.setFont(new Font("Lucida Bright", Font.BOLD, 36));
		label3.setBounds(10, 338, 300, 56);
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

		
//		textField3 = new JTextField();
//		textField3.setColumns(10);
//		textField3.setBounds(191, 340, 261, 37);
//		add(textField3);
		
		sec1 = new JCheckBox("A");
		sec1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		sec1.setBounds(280, 340, 46, 21);
		add(sec1);
		
		sec2 = new JCheckBox("B");
		sec2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		sec2.setBounds(340, 340, 46, 21);
		add(sec2);
		
		sec3 = new JCheckBox("C");
		sec3.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		sec3.setBounds(400, 340, 46, 21);
		add(sec3);
		
		sec4 = new JCheckBox("D");
		sec4.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		sec4.setBounds(280, 373, 46, 21);
		add(sec4);
		
		sec5 = new JCheckBox("E");
		sec5.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		sec5.setBounds(340, 373, 46, 21);
		add(sec5);
		
		sec6 = new JCheckBox("F");
		sec6.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 24));
		sec6.setBounds(400, 373, 46, 21);
		add(sec6);
		
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
		
		upd = new JButton("update");
		upd.setForeground(Color.BLACK);
		upd.setFont(new Font("Monospaced", Font.BOLD, 20));
		upd.setBackground(Color.LIGHT_GRAY);
		upd.setFocusable(false);
		upd.setBounds(720,100,143,42);
		upd.addActionListener(this);
		add(upd);

		
		bgg = new JLabel("");
		bgg.setIcon(new ImageIcon("resources/bggg.jpg"));
		bgg.setBounds(0, 0, 886, 663);
		add(bgg);
		
	
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new UpdateInstructor();
	}
	
	
	public void actionPerformed(ActionEvent e) {

		
		if(e.getSource() == submit){
            try{
            	ConDb c2 = new ConDb();
        		
//            	taking the input from the respective textArea and storing in variable to use in the query
        		String a = name.getText();
        		String b = address.getText();

        		String d = (String)courseCombo.getSelectedItem();
        		String g = phone.getText();
        		String f = email.getText();
        		String i = idTextField.getText();

        		
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        		String h = sdf.format(dob.getDate());
        		
//        		update query
        		String q = "update instructor set name = ?, address = ?,course = ?, phone = ?, email = ?, dob = ?,section1 = ?,section2= ?,section3= ?,section4= ?,section5= ?,section6= ? where id = ?";
            	PreparedStatement pst = c2.connection.prepareStatement(q);
                
//         		Preparing string for teaching section to input in the table instructor
            	String u = "",v = "",w="",x="",y="",z ="";
            	
            	if(sec1.isSelected()) {
            		u += sec1.getText();
            	}
            	else {
            		u+="0";
            	}
            	
            	
            	if(sec2.isSelected()) {
            		v += sec2.getText();
            	}
            	else {
            		v+="0";
            	}
            	
            	if(sec3.isSelected()) {
            		w += sec3.getText();
            	}
            	else {
            		w+="0";
            	}
            	if(sec4.isSelected()) {
            		x += sec4.getText();
            	}
            	
            	else {
            		x+="0";
            	}
            	
            	if(sec5.isSelected()) {
            		y += sec5.getText();
            	}
            	else {
            		y+="0";
            	}
            	
            	if(sec6.isSelected()) {
            		z += sec6.getText();
            	}
            	else {
            		z+="0";
            	}


//            	specifying the parameter in the query (instructor)
            	pst.setString(1, a);
            	pst.setString(2, b);
            	
            	pst.setString(3, d);
            	pst.setString(4, g);
            	pst.setString(5, f);
            	pst.setString(6, h);
            	
            	pst.setString(7, u);
            	pst.setString(8, v); 	
            	pst.setString(9, w);
            	pst.setString(10, x);
            	pst.setString(11, y);
            	pst.setString(12, z);
            	pst.setString(13, i);
            
            	pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Instructor Details Updated Successfully");
                setVisible(false);
                c2.connection.close();
            }
            catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }
		if(e.getSource() == cancel){
            System.exit(0);
            
        }
		
		if(e.getSource() == upd){
            try{
                ConDb c2 = new ConDb();
//              getting detail of instructor of given id to view in the respective idTextField
                String str = "select * from instructor where id = '"+idTextField.getText()+"'";
                ResultSet rs = c2.statement.executeQuery(str);

//                To set the value of courseCombo from the table 
                if(rs.next()){
                	
                	
                	String z = rs.getString(5);
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
                	Date x = rs.getDate(8);
            		
                	dob.setDate(x);
                    name.setText(rs.getString(3));
                    address.setText(rs.getString(4));
                    
//                    Selecting the teaching section when viewed to update
                    if(rs.getString(9).equals("A")) {
                    	sec1.setSelected(true);;
                    }
                    if(rs.getString(10).equals("B")) {
                    	sec2.setSelected(true);
                    }
                    if(rs.getString(11).equals("C")) {
                    	sec3.setSelected(true);
                    }
                    if(rs.getString(12).equals("D")) {
                    	sec4.setSelected(true);
                    }
                    if(rs.getString(13).equals("E")) {
                    	sec5.setSelected(true);
                    }
                    if(rs.getString(14).equals("F")) {
                    	sec6.setSelected(true);
                    }

                    phone.setText(rs.getString(6));
                    email.setText(rs.getString(7));
                    courseCombo.setSelectedIndex(res);
                    
                    c2.connection.close();
                }

                
            }catch(Exception ex){}
		
		
	}
	
	
	}}
