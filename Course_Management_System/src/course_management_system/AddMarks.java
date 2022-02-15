package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;


import javax.swing.*;


public class AddMarks extends JFrame implements ActionListener{
	JLabel heading, label1, label2, label3,cLabel,yLabel;
	private JTextField idTextField,courseTextField,yearTextField, modu1, modu2, modu3, modu4, modu5, modu6, markA, markB, markC, markD, markE, markF;
	JButton submit;
	AddMarks(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 550);
		setLayout(null);
		setResizable(false);
		
		heading = new JLabel("Enter marks of a student");
		heading.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 45));
		heading.setBounds(33, 0, 471, 71);
		add(heading);
		
		
		
		label1 = new JLabel("Enter id number");
		label1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label1.setBounds(33, 50, 179, 43);
		add(label1);
		
		cLabel = new JLabel("Enter course ");
		cLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		cLabel.setBounds(33, 85, 179, 43);
		add(cLabel);
		
		yLabel = new JLabel("Enter year ");
		yLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		yLabel.setBounds(33, 120, 179, 43);
		add(yLabel);
		
		
		label2 = new JLabel("Enter Subject");
		label2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label2.setBounds(33, 158, 179, 43);
		add(label2);
		
		label3 = new JLabel("Enter Marks");
		label3.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label3.setBounds(331, 158, 179, 43);
		add(label3);
		
//		input course
		courseTextField = new JTextField();
		courseTextField.setBounds(242, 90, 218, 32);
		courseTextField.setColumns(10);
		add(courseTextField);
		
//		input year
		yearTextField = new JTextField();
		yearTextField.setBounds(242, 125, 218, 32);
		yearTextField.setColumns(10);
		add(yearTextField);
		
		idTextField = new JTextField();
		idTextField.setBounds(242, 55, 218, 32);
		idTextField.setColumns(10);
		add(idTextField);
		
		modu1 = new JTextField();
		modu1.setColumns(10);
		modu1.setBounds(33, 210, 218, 32);
		add(modu1);
		
		modu2 = new JTextField();
		modu2.setColumns(10);
		modu2.setBounds(33, 250, 218, 32);
		add(modu2);
		
		modu3 = new JTextField();
		modu3.setColumns(10);
		modu3.setBounds(33, 290, 218, 32);
		add(modu3);
		
		modu4 = new JTextField();
		modu4.setColumns(10);
		modu4.setBounds(33, 330, 218, 32);
		add(modu4);
		
		modu5 = new JTextField();
		modu5.setColumns(10);
		modu5.setBounds(33, 370, 218, 32);
		add(modu5);
		
		modu6 = new JTextField();
		modu6.setColumns(10);
		modu6.setBounds(33, 410, 218, 32);
		add(modu6);
		
		markA = new JTextField();
		markA.setColumns(10);
		markA.setBounds(292, 210, 218, 32);
		add(markA);
		
		markB = new JTextField();
		markB.setColumns(10);
		markB.setBounds(292, 250, 218, 32);
		add(markB);
		
		markC = new JTextField();
		markC.setColumns(10);
		markC.setBounds(292, 290, 218, 32);
		add(markC);
		
		markD = new JTextField();
		markD.setColumns(10);
		markD.setBounds(292, 330, 218, 32);
		add(markD);
		
		markE = new JTextField();
		markE.setColumns(10);
		markE.setBounds(292, 370, 218, 32);
		add(markE);
		
		markF = new JTextField();
		markF.setColumns(10);
		markF.setBounds(292, 410, 218, 32);
		add(markF);
		
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
		new AddMarks();
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == submit){
            try{
//            	connection objects
            	ConDb c3 = new ConDb();
            	ConDb c4= new ConDb();
            	
            	String n = idTextField.getText();
//            	Course Text
            	String cc = courseTextField.getText();
//            	Year Text
            	String yy = yearTextField.getText();
            	
//        		Subject Text
        		String a = modu1.getText();
        		String b = modu2.getText();
        		String c = modu3.getText();
        		String d = modu4.getText();
        		String f = modu5.getText();
        		String g = modu6.getText();
        		
        		
//        		Marks Text
        		String h = markA.getText();
        		String i = markB.getText();
        		String j = markC.getText();
        		String k = markD.getText();
        		String l = markE.getText();
        		String m = markF.getText();
        		
        		
        		
        		
            	String q = "insert into modules(id, module1,module2,module3,module4,module5, module6,course,year) values (?,?,?,?,?,?,?,?,?)";
            	String r = "insert into marks(id, mark1, mark2, mark3, mark4, mark5, mark6) values (?,?,?,?,?,?,?)";
            	PreparedStatement pst = c3.connection.prepareStatement(q);
            	PreparedStatement pstt = c4.connection.prepareStatement(r);
            	
//            	specifying the parameter in the query (modules)
            	pst.setString(1, n);
            	pst.setString(2, a);
            	pst.setString(3, b);
            	pst.setString(4, c);
            	pst.setString(5, d);
            	pst.setString(6, f);
            	pst.setString(7, g);
            	pst.setString(8, cc);
            	pst.setString(9, yy);
            	
            	
//            	specifying the parameter in the query (marks)
            	pstt.setString(1, n);
            	pstt.setString(2, h);
            	pstt.setString(3, i);
            	pstt.setString(4, j);
            	pstt.setString(5, k);
            	pstt.setString(6, l);
            	pstt.setString(7, m);
            
            	pst.executeUpdate();
            	pstt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);
//                closing connection
                c3.connection.close();;
                c4.connection.close();;
            }
            catch(Exception ee) {
            	System.out.println(ee);
            	JOptionPane.showMessageDialog(null,"Invalid");
            	}
            }

		
	}

}
