package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;


public class UpdateModules extends JFrame implements ActionListener{
	JLabel heading, label1, label2, label3,cLabel,yLabel;
	JButton submit, upd;
	private JTextField courseTextField,yearTextField, modu1, modu2, modu3, modu4, modu5, modu6;
	UpdateModules(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 550);
		setLayout(null);
		setResizable(false);
		
		heading = new JLabel("Update modules ");
		heading.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 45));
		heading.setBounds(130, 0, 320, 71);
		add(heading);
		
		
		
		
		cLabel = new JLabel("Enter course ");
		cLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		cLabel.setBounds(20,60, 179, 43);
		add(cLabel);
		
		yLabel = new JLabel("Enter year ");
		yLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		yLabel.setBounds(20, 110, 179, 43);
		add(yLabel);
		
		

		
		label2 = new JLabel("Enter individual module");
		label2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		label2.setBounds(115, 158, 300, 71);
		add(label2);
		
		
		
//		input course
		courseTextField = new JTextField();
		courseTextField.setBounds(180, 65, 218, 32);
		courseTextField.setColumns(10);
		add(courseTextField);
		
//		input year
		yearTextField = new JTextField();
		yearTextField.setBounds(180, 120, 218, 32);
		yearTextField.setColumns(10);
		add(yearTextField);

		
		modu1 = new JTextField();
		modu1.setColumns(10);
		modu1.setBounds(130, 210, 270, 32);
		add(modu1);
		
		modu2 = new JTextField();
		modu2.setColumns(10);
		modu2.setBounds(130, 250, 270, 32);
		add(modu2);
		
		modu3 = new JTextField();
		modu3.setColumns(10);
		modu3.setBounds(130, 290, 270, 32);
		add(modu3);
		
		modu4 = new JTextField();
		modu4.setColumns(10);
		modu4.setBounds(130, 330, 270, 32);
		add(modu4);
		
		modu5 = new JTextField();
		modu5.setColumns(10);
		modu5.setBounds(130, 370, 270, 32);
		add(modu5);
		
		modu6 = new JTextField();
		modu6.setColumns(10);
		modu6.setBounds(130, 410, 270, 32);
		add(modu6);
		
		upd = new JButton("update");
		upd.setForeground(Color.BLACK);
		upd.setFont(new Font("Monospaced", Font.BOLD, 18));
		upd.setBackground(Color.LIGHT_GRAY);
		upd.setFocusable(false);
		upd.setBounds(420,80,110,42);
		upd.addActionListener(this);
		add(upd);
		
		submit = new JButton("Submit");
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Monospaced", Font.BOLD, 20));
		submit.setBackground(Color.LIGHT_GRAY);
		submit.setFocusable(false);
		submit.setBounds(200, 465, 110, 30);
		submit.addActionListener(this);
		add(submit);
		
		
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new UpdateModules();
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == submit){
            try{
//            	connection object
            	ConDb c3 = new ConDb();

            	
//        		Subject Text
        		String a = modu1.getText();
        		String b = modu2.getText();
        		String c = modu3.getText();
        		String d = modu4.getText();
        		String f = modu5.getText();
        		String g = modu6.getText();
        		
        		
//        		update query
            	String q = "update modules set module1 = ?, module2 = ?, module3 = ?,module4 = ?, module5 = ?, module6 = ? where id is NULL";
            	PreparedStatement pst = c3.connection.prepareStatement(q);
        		
            	
//            	specifying the parameter in the query (modules)
            	pst.setString(1, a);
            	pst.setString(2, b);
            	pst.setString(3, c);
            	pst.setString(4, d);
            	pst.setString(5, f);
            	pst.setString(6, g);
            	
            	pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Modules Updated Successfully");
                setVisible(false);
                
//                closing connection
                c3.connection.close();;
            }
            catch(Exception ee) {
            	System.out.println(ee);
            	JOptionPane.showMessageDialog(null,"Invalid");
            	}
            }
		
		
		if(e.getSource() == upd){
            try{
                ConDb c2 = new ConDb();
                
                

                
                
//        		select query
            	String q = "select * from modules where course = ? and year = ? and id is NULL";
            	PreparedStatement pst = c2.connection.prepareStatement(q);
            	 
            	
            	pst.setString(1, courseTextField.getText());
            	pst.setString(2, yearTextField.getText());
            	

            	
            	ResultSet rs1=pst.executeQuery();
                if(rs1.next()){
            		
                	
                    modu1.setText(rs1.getString(2));
                    modu2.setText(rs1.getString(3));
                    modu3.setText(rs1.getString(4));
                    modu4.setText(rs1.getString(5));
                    modu5.setText(rs1.getString(6));
                    modu6.setText(rs1.getString(7));
                    
                }

                
            }catch(Exception ex){
            	System.out.println(ex);
            }
		

		
	}

	}}
