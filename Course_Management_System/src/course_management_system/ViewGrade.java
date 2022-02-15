package course_management_system;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ViewGrade extends JFrame {
//	This frame shows the grade of a student, Both student and admin uses this class but the difference is Student can only view their marks and admin can select from the student detail to view marks
//	This class takes the id as a parameter
	private JLabel heading, label1, label2, label3;
	private JTextField modu1,modu2,modu3,modu4,modu5,modu6,markA,markB,markC,markD,markE,markF,percen;



	ViewGrade(String i){
		setTitle("Course-Management-System");
		setBounds(100, 100, 550, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		//		setLocationRelativeTo(null);
		setResizable(false);

		heading = new JLabel("Marks");
		heading.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 45));
		heading.setBounds(211, 0, 148, 71);
		add(heading);

		label1 = new JLabel("Marksheet of id no. ");
		label1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label1.setBounds(33, 93, 364, 43);
		add(label1);

		label2 = new JLabel("Subject");
		label2.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label2.setBounds(33, 158, 179, 43);
		add(label2);

		label3 = new JLabel("Marks");
		label3.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label3.setBounds(331, 158, 66, 43);
		add(label3);

		modu2 = new JTextField();
		modu2.setColumns(10);
		modu2.setBounds(33, 250, 218, 32);
		add(modu2);

		markB = new JTextField();
		markB.setColumns(10);
		markB.setBounds(292, 250, 218, 32);
		add(markB);

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

		modu1 = new JTextField();
		modu1.setColumns(10);
		modu1.setBounds(33, 210, 218, 32);
		add(modu1);

		markA = new JTextField();
		markA.setColumns(10);
		markA.setBounds(292, 210, 218, 32);
		add(markA);

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

		JLabel label4 = new JLabel("Percentage");
		label4.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label4.setBounds(33, 482, 179, 43);
		add(label4);

		percen = new JTextField();
		percen.setColumns(10);
		percen.setBounds(292, 490, 218, 32);
		add(percen);
		viewMark(i);




		setVisible(true);
	}

	public void viewMark(String i){
		try{
			ConDb c9 = new ConDb();

			ResultSet rs = c9.statement.executeQuery("select * from modules where id="+i);
//			setting the textfield with necessary details retrieved from the table modules
			if(rs.next()){
				modu1.setText(rs.getString("module1"));
				modu1.setEditable(false);
				modu2.setText(rs.getString("module2"));
				modu2.setEditable(false);
				modu3.setText(rs.getString("module3"));
				modu3.setEditable(false);
				modu4.setText(rs.getString("module4"));
				modu4.setEditable(false);
				modu5.setText(rs.getString("module5"));
				modu5.setEditable(false);
				modu6.setText(rs.getString("module6"));
				modu6.setEditable(false);
				label1.setText("Marksheet of id no: "+i);

			}
			ResultSet rs1 = c9.statement.executeQuery("select * from marks where id="+i);
//			setting the textfield with necessary details retrieved from the table marks
			if(rs1.next()){

				float mark1 = Float.parseFloat(rs1.getString("mark1"));
				float mark2 = Float.parseFloat(rs1.getString("mark2"));
				float mark3 = Float.parseFloat(rs1.getString("mark3"));
				float mark4 = Float.parseFloat(rs1.getString("mark4"));
				float mark5 = Float.parseFloat(rs1.getString("mark5"));
				float mark6 = Float.parseFloat(rs1.getString("mark6"));

				
//				calculation for percentage
				float percentage = ((mark1+mark2+mark3+mark4+mark5+mark6)/600)*100;

				markA.setText(rs1.getString("mark1"));
				markA.setEditable(false);
				markB.setText(rs1.getString("mark2"));
				markB.setEditable(false);
				markC.setText(rs1.getString("mark3"));
				markC.setEditable(false);
				markD.setText(rs1.getString("mark4"));
				markD.setEditable(false);
				markE.setText(rs1.getString("mark5"));
				markE.setEditable(false);
				markF.setText(rs1.getString("mark6"));
				markF.setEditable(false);

				percen.setText(Float.toString(percentage));
				percen.setEditable(false);


			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

	}


}
