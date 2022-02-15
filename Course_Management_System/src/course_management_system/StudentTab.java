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

public class StudentTab extends JFrame implements ActionListener {
//	Main frame of the student window when logged in successfully
	private JMenuBar menuBar;
	private JMenu view, choose, exit;
	private JMenuItem modules, grades, instructor,exx,choose3;
	private JLabel label;
	private ImageIcon backG;
	StudentTab(){
	
		setTitle("Course-Management-System");
		setSize(1920,1030);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		view = new JMenu("View");
		menuBar.add(view);
		
		choose = new JMenu("Choose a module");
		menuBar.add(choose);
		
		exit = new JMenu("Exit");
		menuBar.add(exit);
		
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
		
		exx = new JMenuItem("Exit");
		exx.setIcon(new ImageIcon("resources/exit.png"));
		exx.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		exx.addActionListener(this);
		exit.add(exx);
		
		choose3 = new JMenuItem("Choose for 3rd year");
		choose3.setIcon(new ImageIcon("resources/options.png"));
		choose3.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		choose3.addActionListener(this);
		choose.add(choose3);
		
		
		backG = new ImageIcon(((new ImageIcon("resources/stBg.jpg")).getImage()).getScaledInstance(1900, 950, Image.SCALE_DEFAULT));
		label = new JLabel(backG);
		add(label);
		
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new StudentTab();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String msg = e.getActionCommand();
//		action when the menuItem is click
		if(msg=="modules") {
			new ViewModules();
			
			
		}
		else if(msg=="grades") {
			new ViewGrade(StudentLogin.unique); {}
			
		}
		else if(msg=="instructor") {
			new StudentViewInstructor();
			
		}
		else if(msg=="Choose for 3rd year") {
			new ChooseModule();
			
		}
		
		if(msg.equals("Exit")) {
        	System.exit(0);
        }
		
		
	}
}
