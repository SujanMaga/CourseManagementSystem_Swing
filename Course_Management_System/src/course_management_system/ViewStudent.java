package course_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;



public class ViewStudent extends JFrame implements ActionListener {
	
	private JTable studentTable;
	private JScrollPane scrollPane;
	private JLabel label1, heading;
	private JTextField idTextField;
	private JButton view, del;
	
	public void loadDetail() {
        try {
            ConDb c7 = new ConDb();
            String q = "select * from student";
            PreparedStatement st = c7.connection.prepareStatement(q);
            ResultSet rs = st.executeQuery();
//        load details and place it in the studentTable
//        needs external jar file rs2xml
            studentTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            c7.connection.close();
        } catch (Exception e) {
        	
        }

    }
	
	ViewStudent(){
		setTitle("Course-Management-System");
		setBounds(100, 100, 1000, 550);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		

		
		label1 = new JLabel("Enter Id of a student");
		label1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 16));
		label1.setBackground(Color.BLACK);
		label1.setBounds(69, 92, 285, 40);
		add(label1);
		
		heading = new JLabel("Student Details");
		heading.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		heading.setBounds(399, 10, 240, 55);
		add(heading);
		
		idTextField = new JTextField();
		idTextField.setBounds(364, 92, 240, 32);
		idTextField.setColumns(10);
		add(idTextField);
		
		view = new JButton("View result");
		view.setForeground(Color.WHITE);
		view.setBackground(Color.BLUE);
		view.setFocusable(false);
		view.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		view.setBounds(649, 92, 170, 33);
		view.addActionListener(this);
		add(view);
		
		del = new JButton("Del");
		del.setForeground(Color.WHITE);
		del.setBackground(Color.BLUE);
		del.setFocusable(false);
		del.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 17));
		del.setBounds(840, 92, 120, 33);
		del.addActionListener(this);
		add(del);
		
		
		
		studentTable = new JTable();
		
		
//		overriding mouseClicked only to use that method
		studentTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg) {
               int row = studentTable.getSelectedRow();
               idTextField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            }
        });
		
//		Scrolling effect on studentTable
		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(studentTable);
		scrollPane.setBounds(0, 166, 986, 321);
		add(scrollPane);
		
		
		loadDetail();
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ViewStudent();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			ConDb c5 = new ConDb();
            if(e.getSource() == view){            
                new ViewGrade(idTextField.getText());
                
            };
//			admins delete instructor
            if(e.getSource() == del) {
            	new DeleteStudent(idTextField.getText());
                dispose();
                new ViewStudent();
                c5.connection.close();
            }
        }
        catch(Exception ee){
        	JOptionPane.showMessageDialog(null,"Deletion Unsuccessful");
        }
    }
	}

