package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class ChooseModule extends JFrame implements ActionListener{
//	Student can choose 2 optional from the four given modules
	
	private JLabel heading;
	private JRadioButton choose1,choose2,choose3,choose4;
	private JButton submit;
	private ButtonGroup option1,option2;    
	ChooseModule(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);	
		setResizable(false);
		setLayout(null);
		
		
		heading = new JLabel("Choose Modules (any 2)");
		heading.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		heading.setBounds(75, 10, 318, 33);
		add(heading);
		

		
		
		choose1 = new JRadioButton("Big Data");
		choose1.setForeground(Color.BLUE);
		choose1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		choose1.setBounds(29, 76, 133, 33);
		
		
		choose2 = new JRadioButton("ML");
		choose2.setForeground(Color.BLUE);
		choose2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		choose2.setBounds(242, 76, 133, 33);
		
		
		choose3 = new JRadioButton("DMS");
		choose3.setForeground(Color.BLUE);
		choose3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		choose3.setBounds(29, 145, 183, 33);
		
		
		choose4 = new JRadioButton("Networking");
		choose4.setForeground(Color.BLUE);
		choose4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		choose4.setBounds(242, 145, 164, 33);
		
		
		option1 = new ButtonGroup();
		option1.add(choose1);
		option1.add(choose2);
		
		option2 = new ButtonGroup();
		option2.add(choose3);
		option2.add(choose4);
		
		add(choose1);
		add(choose2);
		add(choose3);
		add(choose4);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.GRAY);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		submit.setBounds(155, 207, 118, 35);
		submit.setFocusable(false);
		submit.addActionListener(this);
		add(submit);
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new ChooseModule();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit){
            try{
            	ConDb c2 = new ConDb();
            	String a ="",b="";
            	
//            	Creating String with text of module name selected to insert in the table
            	if(choose1.isSelected()) {
            		a+=choose1.getText();
            	}
            	else if(choose2.isSelected()) {
            		a+=choose2.getText();
            	}
            	
            	if(choose3.isSelected()) {
            		b+=choose3.getText();
            	}
            	else if(choose4.isSelected()) {
            		b+=choose4.getText();
            	}



        		String q = "update modules set optional1 = ?, optional2 = ? where id = ?";
            	PreparedStatement pst = c2.connection.prepareStatement(q);
            	
//            	specifying the parameter in the query (modules)
            	pst.setString(1, a);
            	pst.setString(2, b);
            	pst.setString(3, StudentLogin.unique);
            	

            	pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Optional Details Updated Successfully");
                setVisible(false);
            }
            catch(Exception ee){
            	JOptionPane.showMessageDialog(null,"Unsuccessfull update");
            	System.out.println(ee);
            }
		
		
	}
	
}}
