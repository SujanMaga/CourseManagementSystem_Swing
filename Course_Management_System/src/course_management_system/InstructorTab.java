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

public class InstructorTab extends JFrame implements ActionListener {
//	Main frame of the instructor window when logged in successfully
	private JMenuBar menuBar;
	private JMenu view, exit, addU;
	private JMenuItem modules, section,exx, marksAdd;
	private JLabel label;
	private ImageIcon backG;
	InstructorTab(){
		setTitle("Course-Management-System");
		setSize(1920,1030);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		view = new JMenu("View");
		menuBar.add(view);
		
		addU = new JMenu("Add");
		menuBar.add(addU);
		
		exit = new JMenu("Exit");
		menuBar.add(exit);
		
		modules = new JMenuItem("modules");
		modules.setIcon(new ImageIcon("resources/modules.png"));
		modules.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		modules.addActionListener(this);
		view.add(modules);
		
		
		
		section = new JMenuItem("section");
		section.setIcon(new ImageIcon("resources/section.png"));
		section.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		section.addActionListener(this);
		view.add(section);
		
		marksAdd = new JMenuItem("Add Marks");
		marksAdd.setIcon(new ImageIcon("resources/grades.png"));
		marksAdd.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		marksAdd.addActionListener(this);
		addU.add(marksAdd);
		
		
		exx = new JMenuItem("Exit");
		exx.setIcon(new ImageIcon("resources/exit.png"));
		exx.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		exx.addActionListener(this);
		exit.add(exx);
		
		
		backG = new ImageIcon(((new ImageIcon("resources/teacherBg.jpg")).getImage()).getScaledInstance(1900, 950, Image.SCALE_DEFAULT));
		label = new JLabel(backG);
		add(label);
		
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new InstructorTab();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if(msg=="modules") {
			new ViewModules();
			
		}

		if(msg=="section") {
			new InstructorViewSection();
			
		}
		if(msg=="Add Marks") {
			new AddMarks();
		}
		
		if(msg.equals("Exit")) {
        	System.exit(0);
        }
		
		
	}
}
