package course_management_system;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class AdminTab extends JFrame implements ActionListener {
//	Main frame of the admin window when logged in successfully
	
	private JMenuBar menuBar;
	private JMenu view, addU, updateU, delU, exit;
	private JMenuItem modules, grades, instructor,student, insAdd, stuAdd,marksAdd,modulesAdd, insUp, stuUp, modUp,couDel, exx;
	private JLabel label;
	private ImageIcon backG;
	AdminTab(){
		setTitle("Course-Management-System");
		setSize(1920,1030);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		view = new JMenu("View/Delete");
		menuBar.add(view);
		
		addU = new JMenu("Add");
		menuBar.add(addU);
		
		updateU = new JMenu("Update");
		menuBar.add(updateU);
		
		delU = new JMenu("Delete");
		menuBar.add(delU);
		
		
		exit = new JMenu("Exit");
		menuBar.add(exit);
		
//		menuitem with actionListener to perform actions
		modules = new JMenuItem("modules");
		modules.setIcon(new ImageIcon("resources/modules.png"));
		modules.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		modules.addActionListener(this);
		view.add(modules);
		
		grades = new JMenuItem("grades");
		grades.setIcon(new ImageIcon("resources/grades.png"));
		grades.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		grades.addActionListener(this);
		view.add(grades);
		
		instructor = new JMenuItem("instructor");
		instructor.setIcon(new ImageIcon("resources/teacher.png"));
		instructor.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		instructor.addActionListener(this);
		view.add(instructor);
		
		student = new JMenuItem("student");
		student.setIcon(new ImageIcon("resources/std.png"));
		student.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		student.addActionListener(this);
		view.add(student);
		
		insAdd = new JMenuItem("Add Instructor");
		insAdd.setIcon(new ImageIcon("resources/addIns.png"));
		insAdd.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		insAdd.addActionListener(this);
		addU.add(insAdd);
		
		stuAdd = new JMenuItem("Add Student");
		stuAdd.setIcon(new ImageIcon("resources/addStu.png"));
		stuAdd.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		stuAdd.addActionListener(this);
		addU.add(stuAdd);
		
		marksAdd = new JMenuItem("Add Marks");
		marksAdd.setIcon(new ImageIcon("resources/grades.png"));
		marksAdd.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		marksAdd.addActionListener(this);
		addU.add(marksAdd);
		
		modulesAdd = new JMenuItem("Add Modules");
		modulesAdd.setIcon(new ImageIcon("resources/modules.png"));
		modulesAdd.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		modulesAdd.addActionListener(this);
		addU.add(modulesAdd);
		
		insUp = new JMenuItem("Update Instructor");
		insUp.setIcon(new ImageIcon("resources/upT.png"));
		insUp.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		insUp.addActionListener(this);
		updateU.add(insUp);
		
		stuUp = new JMenuItem("Update Student");
		stuUp.setIcon(new ImageIcon("resources/upS.png"));
		stuUp.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		stuUp.addActionListener(this);
		updateU.add(stuUp);
		
		modUp = new JMenuItem("Update Modules");
		modUp.setIcon(new ImageIcon("resources/upM.png"));
		modUp.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		modUp.addActionListener(this);
		updateU.add(modUp);
		
		couDel = new JMenuItem("Delete Course");
		couDel.setIcon(new ImageIcon("resources/delCou.png"));
		couDel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		couDel.addActionListener(this);
		delU.add(couDel);
		
		exx = new JMenuItem("Exit");
		exx.setIcon(new ImageIcon("resources/exit.png"));
		exx.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		exx.addActionListener(this);
		exit.add(exx);
		
		
		backG = new ImageIcon(((new ImageIcon("resources/AdminBg.jpg")).getImage()).getScaledInstance(1900, 950, Image.SCALE_DEFAULT));
		label = new JLabel(backG);
		add(label);
		
		setVisible(true);
		

		

		
		
		
	}
	public static void main(String[] args) {
		new AdminTab();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		
		if(msg.equals("modules")){
            new ViewModules();
            
        }
       
        if(msg.equals("grades")){
            new ViewStudent();
            
        }
        
        if(msg.equals("instructor")){
            new ViewInstructor();
            
        }
        if(msg.equals("student")){
            new ViewStudent();
            
        }
        if(msg.equals("Add Student")){
            new StudentRegister();
            
        }
        if(msg.equals("Add Instructor")) {
        	new AddInstructor();
        }
        if(msg.equals("Add Marks")) {
        	new AddMarks();
        }
        if(msg.equals("Add Modules")) {
        	new AddModules();
        }
        if(msg.equals("Update Instructor")) {
        	new UpdateInstructor();
        }
        if(msg.equals("Update Student")) {
        	new UpdateStudent();
        }
        if(msg.equals("Update Modules")) {
        	new UpdateModules();
        }
        if(msg.equals("Delete Course")) {
        	new DeleteCourse();
        }
        if(msg.equals("Exit")) {
        	System.exit(0);
        }
	}
}
